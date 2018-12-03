<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="style/style.css">
<title>User Dashboard</title>
</head>
<body>
	<div class="sideBar">
		<a href="welcome.html">Home</a>
	</div>
	<div class="main">
		<div class="container">
			<div class="headerText">
				<form action="AccountController" method="post">
					<div class="row">
						<div class="column"><button id="dashSubmit">Save Password</button></div>
						<div class="column"><button id="submit">Retrieve/Show Passwords</button></div>
						<div class="column"><button id="submit">Delete Password</button></div>
						<div class="column"><button id="submit">Show Password</button></div>
					</div> 
				</form>

			</div>
			<div class="images">
				<img src="Images/crypto_lock.png" alt="Protection!!" width="350"
					length="500">
			</div>
		</div>
	</div>
</body>
</html>
