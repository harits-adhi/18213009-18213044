<?php
	$opt = array('location'=>'http://localhost/soap-server.php','uri' =>'http://localhost/');
	$api = new SoapClient(NULL,$opt);
	echo $api->helloword();
	echo("<br>");
	echo $api->addition(5,5);
	echo("<br>");
	echo $api->getData();
?>