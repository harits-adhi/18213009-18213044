<?php
class API{
	function helloword(){
		return "Hello World!";
		}
	
	function addition($a,$b){
		return ($a+$b);
		}
		
	function getData(){
		mysql_connect('localhost','root','');
		mysql_select_db('aks');
		$result = mysql_query('SELECT * from jadwal');
			while ($row = mysql_fetch_array($result,MYSQL_ASSOC)){
				foreach ($row as $column)
				{
					 $var = $column;
				}
			}
		return $var;
		}
	}
	$opt = array('uri'=>'http//localhost');
	$server = new SoapServer(NULL,$opt);
	$server -> setClass('API');
	$server -> handle();
?>