<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Добавить оценку</title>
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" />
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css" />
	<link rel="stylesheet" href="css/style.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/formValidation.js"></script>
</head>
<body>
	<div class="nav">
		<div class="container">
			<ul class="pull-left">
				<li><a href="teacherPage">&lt Go back</a></li>
			</ul>
		</div>
	</div>
	
	<div class="lefticon">
		<img src="img/monitoring-evaluation.jpg" style="width:250px; height:280px;">
    </div>
    
	<div class="adder">
    	<div class="container">
			<h1>Добавить оценку</h1>
			<form name="adMarkTeacher" id="form_add">
				<label>Дата выставления:</label>
				<input type="text" name="dateM" id="date" placeholder="01/09/2012" required />
				<span id='span_date'></span><br>
				
				<label>Балл:</label>
				<input type="number" step="1" min="1" max="100" name="mark" id="mark" placeholder="75" required />
				<span id='span_mark'></span>*<br>
				
				<label>Студент:</label>
				<select name="student">
					<c:forEach var="student" items="${students }">
						<option value="${student.idZ }">${student.lastName } ${student.firstName }</option>
					</c:forEach>
				</select><br>	
				
				<label>Предмет:</label>
				<select name="subject">
					<c:forEach var="subject" items="${subjects }">
						<option value="${subject.idS }">${subject.name}</option>
					</c:forEach>
				</select><br>
				<input type="submit" value="Добавить" name="action" />
				<input type="reset" value="Очистить" />	
			</form>
		</div>
	</div>
</body>
</html>