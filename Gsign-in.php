<html lang="en">
  <head>
  <title>Google-API</title>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="315851137315-hdsh1dueecstusvn81g6eb4mtmjc9ujj.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
	<a href="" onclick="signOut();">Sign out</a>
	<p id="oooo"></p>
    <script>
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
			console.log("Name: " + profile.getName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());
			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			console.log("ID Token: " + id_token);
			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'token.php');
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhr.onload = function() {
				console.log('Signed in as: ' + xhr.responseText);
				document.getElementById("oooo").innerHTML = "<br><b>Token ID :</b> " + xhr.responseText;
			};
			xhr.send('id_token=' + id_token);
			//window.open("token.php");
		};
		
		
		
		function signOut() {
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function () {
			console.log('User signed out.');
			});
		};
			  
		
    </script>
	<br>
  </body>
</html>