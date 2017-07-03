<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Добавить предмет</title>
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
		<img src="img/subject.jpg" style="width:300px; height:auto;">
    </div>
	
	<div class="adder">
    	<div class="container">
    		<h1>Добавить предмет</h1>
			<form action="addSubject" id="form_add">
				<input type="text" name="id" value="${id }" hidden>
				<label>Название:</label>
				<input type="text" name="name" value="${name }" id="name">
				<span id='span_name'>*</span><br>
				
				<label>К-во часов:</label>
				<input type="number" step="1" min="0" max="300" placeholder="72" name="countHours" value="${countHours }" id="countHours" required>
				<span id='span_hours'>*</span><br>
				
				<label>Форма занятия:</label>
				<select name="form">
					<c:choose>
						<c:when test="${form == 'lecture' }">
							<option value="lecture" selected>Лекция</option>
						</c:when>
						<c:otherwise>
							<option value="lecture">Лекция</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${form == 'laba' }">
							<option value="laba" selected>Лабораторная</option>
						</c:when>
						<c:otherwise>
							<option value="laba">Лабораторная</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${form == 'practice' }">
							<option value="practice" selected>Практика</option>
						</c:when>
						<c:otherwise>
							<option value="practice">Практика</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${form == 'seminar' }">
							<option value="seminar" selected>Семинар</option>
						</c:when>
						<c:otherwise>
							<option value="seminar">Семинар</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${form == 'webinar' }">
							<option value="webinar" selected>Вебинар</option>
						</c:when>
						<c:otherwise>
							<option value="webinar">Вебинар</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${form == 'exam' }">
							<option value="exam">Экзамен</option>
						</c:when>
						<c:otherwise>
							<option value="exam">Экзамен</option>
						</c:otherwise>
					</c:choose>
				</select><br>
				
				<c:choose>
					<c:when test="${currentGroup != null }">
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