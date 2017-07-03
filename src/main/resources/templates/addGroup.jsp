<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Добавить группу</title>
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
		<img src="img/add_group.png" style="width:250px; height:280px;">
    </div>
	
	<div class="adder">
    	<div class="container">
			<h1>Добавить группу</h1>
			<form action="addGroup" id="form_add">
				<input type="text" name="id" value="${id }" hidden>
				<label>Номер группы:</label>
				<input type="number" step="1" min="000" max="999" placeholder="125" name="groupId" value="${number }" required>
				<span id='span_cnt_students'>*</span><br>				
				
				<label>Курс:</label>
				<input type="number" step="1" min="1" max="6" placeholder="1" name="course" value="${course }" id="course" required>
				<span id='span_course'>*</span><br>
				
				<label>Специализация:</label>
				<input type="text" name="specialization" value="${spec }" id="specialization" required>
				<span id='span_specialization'>*</span><br><br>
				
				
				<c:choose>
					<c:when test="${id != null }">
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