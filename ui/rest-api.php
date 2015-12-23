<?php
	function get_info_by_id($id) {
		$info = array();
		mysql_connect('localhost', 'root', '');
		mysql_select_db('makanan');
		$result = mysql_query('SELECT * FROM `food` JOIN `kantin` WHERE `food`.id=`kantin`.id and `kantin`.id = ' . $id);
		$info = mysql_fetch_array ($result, MYSQL_ASSOC); 
		return $info; 
	}
	
	function get_admin_by_id($id) {
		$info = array();
		mysql_connect('localhost', 'root', '');
		mysql_select_db('makanan');
		$result = mysql_query('SELECT * FROM admin WHERE id = ' . $id);
		$info = mysql_fetch_array ($result, MYSQL_ASSOC); 
		return $info; 
	}
	
	if (isset($_GET["action"])) {
		switch ($_GET["action"]) {
			case "get_info";
				if (isset($_GET["id"])) 
					$value = get_info_by_id($_GET["id"]);
				else
					$value = "ERROR";
				break;
			case "get_admin";
				if (isset($_GET["id"])) 
					$value = get_admin_by_id($_GET["id"]);
				else
					$value = "ERROR";
				break;
		}
	}
	
	exit(json_encode($value));
	
?>