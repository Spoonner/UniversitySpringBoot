<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Добавить расписание</title>
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
		<img src="img/next-lecture-icon.png" style="width:250px; height:280px;">
    </div>
	
	<div class="adder">
    	<div class="container">
    		<h1>Добавить расписание</h1>
			<form action="addSchedule" id="form_add">
				<input type="text" name="id" value="${id }" hidden>
				<label>День:</label>
				<input type="text" placeholder="13/01/2015" name="day" value="${day }" id="date" required>
				<span id='span_date'>*</span><br> 
				
				<label>Номер пары:</label>
				<input type="number" step="1" min="1" max="8" placeholder="2" name="number" value="${number }" id="number" required>
				<span id='span_number'>*</span><br>
				
				<label>Аудитория:</label>
				<input type="number" step="1" min="1" placeholder="333" name="room" value="${room }" id="room" required>
				<span id='span_room'>*</span><br> 
				
				<label>Группа:</label>
				<select name="group">
					<c:forEach var="group" items="${groups }">
						<c:choose>
							<c:when test="${currentGroup == group }">
								<option value="${group.groupId }" selected>${group.groupNumber }</option>
							</c:when>
							<c:otherwise>
								<option value="${group.groupId }">${group.groupNumber }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select><br>
				<label>Предмет</label>
				<select name="subject">
					<c:forEach var="subject" items="${subjects }">
						<c:choose>
							<c:when test="${currentSubject == subject }">
								<option value="${subject.idS }" selected>${subject.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${subject.idS }">${subject.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select><br>
				<label>Преподаватель:</label>
				<select name="teacher">
					<c:forEach var="teacher" items="${teachers }">
						<c:choose>
							<c:when test="${currentSubject == subject }">
								<option value="${teacher.idTable }" selected>${teacher.lastName} ${teacher.firstName }</option>
							</c:when>
							<c:otherwise>
								<option value="${teacher.idTable }">${teacher.lastName} ${teacher.firstName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
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