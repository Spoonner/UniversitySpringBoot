<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">

<style type="text/css">
	ul li {
		display: inline-block;
	}
	
	a {
		text-decoration: none;
		color: #007A00;
		font-weight: bolder;
		font-size: 1em;
		text-transform: uppercase;
		margin: 0px 20px 0px 20px;
	}
	
	a:hover {
		text-decoration: none;
		color: #33CC33;
	}
	
	.jumbotron {
		background-image: url('img/jumbotrone.jpg');
		height: 600px;
		background-repeat: no-repeat;
		background-size: cover;
	}
	
	.jumbotron .container {
		position: relative;
		top:100px;
	}
	
	.jumbotron h1 {
		color: #fff;
		font-size: 48px;	
		font-family: 'Open Sans Light', sans-serif;
		font-weight: bold;
	}
	
	h1 {
		margin: 30px 0 40px 0;
		float: right;
	}
	
	table, th, td, tr{
		border: 1px solid #000;
		padding:2px;
		width: auto;
	}
	
	th {
		height: 28px;
		background-color: #00B800;
		color: white;
		border-color: black;
	}
	
	tr:nth-child(even){
		background-color: #E0F4E0;
	}
	
	tr:nth-child(odd){
		background-color: #FFF;
	}
	
	input[type="submit"] {
		background-color: #0C0;
		background-repeat: repeat-x;
		border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
		color: #fff;
		font-size: 1em;
		text-transform: uppercase;
		padding: 0% 20%;
		border-radius: 3px;	
		margin: 0;
		padding: 3% 25%;
	}
</style>
</head>
<body>
	<div class="nav">
		<div class="container">
			<ul class="pull-left">
				<li><a href="index">HOME</a></li>
				
				<c:if test="${who == 'admin'}">
					<li><a href="adminPage">admin page</a></li>
			</ul>
			<ul class="pull-right">
					<label>You're logged in as "Admin" </label>
					<li class="active"><a href="logoutServlet" name="logout">Log out</a></li>
			</ul>
				</c:if>
			</ul>
			<ul class="pull-left">
				<c:if test="${who == 'student'}">
					<li><a href="studentPage">student page</a></li>
			</ul>
			<ul class="pull-right">
					<label>You're logged in as "Student" </label>
					<li class="active"><a href="logoutServlet" name="logout">Log out</a></li>
				</c:if>
			</ul>
			<ul class="pull-left">
				<c:if test="${who == 'teacher'}">
					<li><a href="teacherPage">teacher page</a></li>
			</ul>
			<ul class="pull-right">
					<label>You're logged in as "Teacher" </label>
					<li class="active"><a href="logoutServlet" name="logout">Log out</a></li>
				</c:if>
			</ul>
			<c:if test="${who !='admin' && who !='student' && who !='teacher'}">
				<form method="get" action="mainServlet">
				<ul class="pull-right">
					<li><input type="text" placeholder="login" name="login" /></li>
					<li><input type="password" placeholder="password" name="password"/>
						<!-- pattern="^[0-9]+$"  --></li>
					<li><input type="submit" name="log" value="login" /></li>
				</ul>
			</form>
			</c:if>
		</div>
	</div>
</body>