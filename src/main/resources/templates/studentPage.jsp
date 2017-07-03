<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//Dp HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dp">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Персональная информация</title>
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" />
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css" />
	<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/tabs.css" />
	<link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"/>
		
	<style type="text/css">
		body {
			background-image: url("img/notebook6.jpg");
			background-repeat: repeat-y;
			background-size: cover;
			height: 100%;
		}
		.personal-info {
			margin-left: 120px;
			margin-right: 100px;
			margin-top: 70px;
			background-color: #fff;
		}
	</style>
</head>
<body>

	<div class="nav">
		<div class="container">
			<ul class="pull-left">
				<li><a href="index">&lt Go back</a></li>
			</ul>
		</div>
	</div>
	<div class="personal-info">
    	<div class="container">
			<h2>Персональная информация студента<br>
			${student.firstName}
			${student.lastName}
			${student.thirdName}
			</h2>
			<label>Номер зачетки:</label>${student.getIdZ()}<br>
			<label>Форма обучения:</label>
			<c:if test="${student.formOfStudies == 'K'}">
				<span>Контракт</span>
			</c:if>
			<c:if test="${student.formOfStudies == 'B'}">
				<span>Бюджет</span>
			</c:if>
			<br>
			<label>Дата рождения:</label>${student.dateOfBirth}<br>
			<label>Дата поступления:</label>${student.dateOfEntry}<br>
			<label>Средняя оценка:</label>${student.avarageMark}<br>
			<label>Размер стипендии:</label>
			<c:choose>
				<c:when test="${student.scolarshipSize == 0.0}">
					<span>нет стипендии</span>
				</c:when>				
				<c:otherwise>
					${student.scolarshipSize}
				</c:otherwise>
			</c:choose>

			<div class="tabs">
			    <input id="tab1" type="radio" name="tabs" checked>
			    <label for="tab1" title="Мое расписание">Расписание</label>
			 
			    <input id="tab2" type="radio" name="tabs">
			    <label for="tab2" title="Мои оценки">Оценки</label>			   
			 
			    <section id="content1">						
						<h3>Мое расписание</h3>
						<table border="1">
						<tr>
							<th>Дата</th>
							<th>№ пары</th>
							<th>Предмет</th>
							<th>Учител</th>
						</tr>
						<c:forEach var="schedule" items="${schedules }">
							<tr>
								<td>${schedule.day }</td>
								<td>${schedule.number }</td>
								<td>${schedule.subject }</td>
								<td>${schedule.teacher }</td>
							</tr>
						</c:forEach>
						</table>
			    </section>  
			    <section id="content2">
					<h3>Мои оценки</h3>
						<table border="1">
						<tr>
							<th>Дата получения</th>
							<th>Оценка</th>
							<th>Предмет</th>
						</tr>
						<c:forEach var="mark" items="${marks }">
							<tr>
								<td>${mark.dateM }</td>
								<td>${mark.mark }</td>
								<td>${mark.subject }</td>
							</tr>
						</c:forEach>
						</table>	
					
			    </section> 
      		</div>
      	</div>
      </div>
	
</body>
</html>