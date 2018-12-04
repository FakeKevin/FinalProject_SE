<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<table style="width: 50%">
					<form action="AccountController" method="post">
						<div class="row">
							<div class="column">
								<tr>
									<th>Location:</th>
									<th><input name="location" type="text" /></th>
								</tr>
								<tr>
									<th>Username:</th>
									<th><input name="username" type="text" /></th>
								</tr>
								<tr>
									<th>Password:</th>
									<th><input name="password" type="password" /></th>
									<th><input name="menu" type="submit" value="Save" /></th>
								</tr>
							</div>
						</div>
					</form>
				</table>
			</div>
			<form action = "AccountController" method="post">
			<input name="menu" type="submit" value="Retrieve" />
				<table border="1">
					<tr>
						<th>Location</th>
						<th>Username</th>
						<th>Password</th>
						<th><input name="menu" type="submit" value="Delete" /></th>
					</tr>
					<c:forEach var="item" items="${retrieved}">
						<tr>
							<td>${item.location}</td>
							<td>${item.username}</td>
							<td>${item.password}</td>
							<td><input name="id" type="radio"
								value=${item.id} /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<div class="images">
				<img src="Images/crypto_lock.png" alt="Protection!!" width="350"
					length="500">
			</div>
		</div>
	</div>
</body>
</html>
