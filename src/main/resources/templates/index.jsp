<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Главная</title>
	<link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.jsp" %>


    <div class="jumbotron">
      <div class="container">
        <h1>База данных "Университет"</h1>
      </div>
    </div> 

    <div class="content">
    	<div class="container">
      
      <section class="students-list">
			<h2>ТОП 10 студентов</h2>	
			<table class="table-students" border="1">
				<tr>
					<th>ID</th>
					<th>Фамилия</th>
					<th>Имя</th>						
					<th>Отчество</th>
					<th>Форма обучения</th>
					<th>Дата рождения</th>
					<th>Дата поступления</th>
					<th>Средняя оценка</th>
					<th>Размер стипендии</th>
				</tr>
				<c:forEach var="student" items="${topStudents}">
					<tr>
						<td>${student.getIdZ()}</td>
						<td>${student.lastName}</td>
						<td>${student.firstName}</td>						
						<td>${student.thirdName}</td>
						<c:if test="${student.formOfStudies == 'K'}">
						<td>Контракт</td>
						</c:if>
						<c:if test="${student.formOfStudies == 'B'}">
						<td>Бюджет</td>
						</c:if>
						<td>${student.dateOfBirth}</td>
						<td>${student.dateOfEntry}</td>
						<td>${student.avarageMark}</td>
						<td>${student.scolarshipSize}</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>	
		</section>
			<%--Here we go with graph--%>
      </div>
    </div>
</body>
</html>
