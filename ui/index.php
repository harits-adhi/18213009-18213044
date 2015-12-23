<?php 
include('cek-login.php');
?>
<html>
<head>
<title>Input Makanan Kantin</title>
</head>

<body>
<h1>Form Input Makanan Kantin</h1>

<?php 

echo "Selamat Datang <strong>".$_SESSION['username']."</strong>";
?>
<?php
		if (isset($_GET["action"]) && isset($_GET["id"]) && isset($_GET["action"]) == "get_info") {
			$info = file_get_contents('http://localhost/ui/rest-api.php?action=get_admin&id=' . $_GET["id"]);
			$info = json_decode($info,true);
		}
	?>
	
<form name="input_data" action=" insert.php?id=<?php echo $_GET["id"] ?>" method="post">
<table border="0" cellpadding="5" cellspacing="0">
    <tbody>
		<tr>
        	<td>Username</td>
        	<td>:</td>
        	<td><input type="text" name="username" maxlength="100" required="required" value="<?php echo $info['username']; ?>" disabled /></td>
        </tr>
    	<tr>
        	<td>Nama Makanan</td>
        	<td>:</td>
        	<td><input type="text" name="namamak" maxlength="100" required="required" placeholder="Pizza" required /></td>
        </tr>
    	<tr>
        	<td>Harga Makanan</td>
        	<td>:</td>
        	<td><input type="text" name="hargamak" maxlength="100" required="required" placeholder="15000" required/></td>
        </tr>
    	<tr>
        	<td>Jenis Makanan</td>
        	<td>:</td>
        	<td><input type="text" name="jenismak" maxlength="50" required="required" placeholder="Makanan Berat" required/></td>
        </tr>
    	<tr>
        	<td>Deskipsi Makanan</td>
        	<td>:</td>
        	<td><textarea name="deskmak" required="required" placeholder='Pizza merupakan makanan khas dari itali'></textarea></td>
        </tr>
        <tr>
        	<td align="right" colspan="3"><input type="submit" name="submit" value="Simpan" /></td>
        </tr>
    </tbody>
</table>
</form>

<a href="logout.php">Logout</a>

</body>
</html>