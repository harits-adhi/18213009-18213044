<?php 
include('config.php');
include('cek-login.php');
?>

<html>
<head>
<title>Input Sukses!</title>
</head>

<body>

<h1>Input Sukses, anda ingin melakukan input lagi?</h1>
<a href="index.php?action=get_admin&id=<?php $id = $_GET["id"]; echo $id;?>">Input</a>
<a href="logout.php">Logout</a>


</body>
</html>