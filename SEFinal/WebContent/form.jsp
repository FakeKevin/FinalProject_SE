<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="style/style.css">
<title>Login</title>
</head>
<body>
	<div class="sideBar">
		<a href="welcome.html">Home</a>
	</div>
<div class="main">
		<div class="container">
			<div class="headerText">
					<form action="HomeController" method="post">
					Email: <input name="email" type="email" /><br /> 
					Password: <input name="password" type="password" /><br />
					<input type="submit" value="Go!" />
	</form>
			
			</div>
			<div class="images">
				<img src="Images/crypto_lock.png" alt="Protection!!" width="350" length="500">
			</div>
		</div>
	</div>
</body>
</html>
