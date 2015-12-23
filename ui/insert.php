<?php
//panggil file config.php untuk menghubung ke server
include('config.php');

//tangkap data dari form
/*$admin=$_POST['username'];
$iddd = mysql_query("SELECT * from admin where username='$admin'");
$idd = mysql_fetch_assoc($iddd);*/

$id = $_GET["id"];

$nama = $_POST['namamak'];
$harga = $_POST['hargamak'];
$jenis = $_POST['jenismak'];
$deskripsi = $_POST['deskmak'];

//simpan data ke database
$query = mysql_query("insert into food values('$id','$nama', '$harga', '$jenis', '$deskripsi')") or die(mysql_error());

if ($query) {
	header('location:edit.php?action=get_admin&id='.$id);
}
?>