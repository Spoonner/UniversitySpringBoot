<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Добавить преподавателя</title>
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
				<li><a href="adminPage">&lt Go back</a></li>
			</ul>
		</div>
	</div>
	
	<div class="lefticon">
		<img src="img/professor.jpg" style="width:250px; height:auto;">
    </div>
	
	<div class="adder">
    	<div class="container">
    		<h1>Добавить преподавателя</h1>
			<form action="addTeacher" method="get" id="form_add">
			
				<input type="text" name="id" value="${id }" hidden>
				<label>Имя:</label>
				<input type="text" name="firstName" value="${fname }" id="fname" maxlength="50" size="15" placeholder="First name" required>
				<span id='span_fname'>*</span><br> 
				<label></label>
				<input type="text" name="lastName" value="${lname }" id="lname" maxlength="50" size="15" placeholder="Last name" required>
				<span id='span_lname'>*</span><br> 
				<label></label>
				<input type="text" name="thirdName" value="${tname }" id="tname" maxlength="50" size="15" placeholder="Third name" required>
				<span id='span_fname'></span><br> 
		
				<label> E-mail: </label>
				<input type="email" name="email" value="${email }" id="email" maxlength="50" size="30" placeholder="example@mail.com" required>
				<span id='span_email'>*</span><br>
				
				<label> Password: </label>
				<input type="password" name="password" value="${pass }" id="password" maxlength="32" required>
				<span id='span_password'>*</span><br>
				
				<label>Должность:</label>
				<input type="text" name="post" value="${post }" required><br>
				
				<label>Зарплата:</label> 
				<input type="number" step="0.01" min="0" placeholder="2550.65" name="salary" value="${salary }" id="salary" required>
				<span id='span_salary'></span><br>
				
				<label>Стаж работы</label>
				<input type="number" step="1" min="0" placeholder="25" name="exp" value="${exp }" id="exp" required/>
				<span id='span_exp'></span><br>
				
				<c:choose>
					<c:when test="${post != null }">
						<input type="submit"  id="send" name="buttonPressed" value="Change" />
					</c:when>
					<c:otherwise>
						<input type="submit"  id="send" name="buttonPressed" value="Submit" />
					</c:otherwise>
				</c:choose>
				<input type="reset" value="Очистить" />	
			</form>
		</div>
	</div>
</body>
</html>