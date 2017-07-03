<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body onload="teacherChange();">
	<div class="nav">
		<div class="container">
			<ul class="pull-left">
				<li><a href="adminPage">&lt Go back</a></li>
			</ul>
		</div>
	</div>
	
	<div class="lefticon">
		<img src="img/monitoring-evaluation.jpg" style="width:250px; height:280px;">
    </div>
	
	<div class="adder">
    	<div class="container">
    		<h1>Добавить оценку</h1>
			<form name="adMark" id="form_add">
				<input type="text" name="id" value="${id }" hidden>
				<label>Дата выставления:</label>
				<input type="text" name="dateM" value="${dateM }"id="date" placeholder="01/09/2012" required />
				<span id='span_date'></span><br>
				
				<label>Балл</label>
				<input type="number" step="1" min="1" max="100" name="mark" value="${markValue }" id="mark" placeholder="75" required />
				<span id='span_mark'></span>*<br>
				
				<label>Студент:</label>
				<select name="student">
					<c:forEach var="student" items="${students }">
						<c:choose>
							<c:when test="${currentStudent == student }">
								<option value="${student.idZ }" selected>${student.lastName } ${student.firstName }</option>
							</c:when>
							<c:otherwise>
								<option value="${student.idZ }">${student.lastName } ${student.firstName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select><br>
				
				<label>Преподаватель:</label>
				<select name="teacher" id="teacher" onChange="teacherChange();">
					<c:forEach var="teacher" items="${teachers }">
						<c:choose>
							<c:when test="${currentTeacher == teacher }">
								<option value="${teacher.idTable }" selected>${teacher.lastName } ${teacher.firstName }</option>
							</c:when>
							<c:otherwise>
								<option value="${teacher.idTable }">${teacher.lastName } ${teacher.firstName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select><br>
				
				<c:forEach var="teacherKey" items="${subsForTeacher.keySet() }">
					<div id="${teacherKey.idTable }" hidden>
						<select name="subject">
							<c:forEach var="subject" items="${subsForTeacher.get(teacherKey) }">
								<c:choose>
									<c:when test="${subject == currentSubject }">
										<option value="${subject.idS }" selected>${subject.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${subject.idS }">${subject.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</c:forEach>
				
				<label>Предмет:</label>
				<div id="subjects" style="display: inline-block;"></div><br>
				
				<script type="text/javascript">
					function teacherChange(){
						document.getElementById("subjects").innerHTML = document.getElementById(document.getElementById("teacher").value).innerHTML;
					}
				</script>				
				
				<c:choose>
					<c:when test="${currentTeacher != null }">
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