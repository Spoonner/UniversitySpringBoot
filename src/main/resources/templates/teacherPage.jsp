<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		h3 {
			display: inline-block
		}
		.link-add {
			display: inline-block;
			border: none;
			margin: 10px;
			border-radius: 20px;
			padding: 4px 13px;
			font-size: 0.9em;
			font-weight: bold;
			color: #00A300;
			text-transform: uppercase;
			vertical-align: bottom;
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

		<h2>Персональная информация</h2>
		<h3>${teacher.lastName }
		${teacher.firstName }
		${teacher.thirdName }</h3>
		<label>E-mail:</label>${teacher.email }<br>
		<label>Табельный номер:</label>${teacher.idTable}<br>
		<label>Стаж:</label>${teacher.experience }<br>
		<label>Зарплата:</label>${teacher.salaly }<br>
		<label>Должность:</label>${teacher.post }<br>
		
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
						<th>Аудитория</th>
						<th>Группа</th>
						<th>Предмет</th>
					</tr>
					<c:forEach var="schedule" items="${schedules }">
						<tr>
							<td>${schedule.day }</td>
							<td>${schedule.number }</td>
							<td>${schedule.room }</td>
							<td>${schedule.group }</td>
							<td>${schedule.subject }</td>
						</tr>
					</c:forEach>
					</table>
				</section>  
			    <section id="content2">		
					<h3>Мои оценки</h3>
					<a href="addMarkTeacher" class="link-add">  
						<img class="img-icon" alt="add" src="img/add_icon.png" 
						title="add new" style="width: 35px; height: auto;">
					</a>
					<table border="1">
					<tr>
						<th>Оценка</th>
						<th>Дата</th>
						<th>Студент</th>
						<th>Предмет</th>
					</tr>					
						<c:forEach var="mark" items="${marks }">
							<tr>
								<td>${mark.mark }</td>
								<td>${mark.dateM }</td>
								<td>${mark.student }</td>
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