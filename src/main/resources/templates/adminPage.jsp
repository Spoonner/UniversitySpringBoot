<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Админка</title>
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" />
	<link rel="stylesheet"
		href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css" />
	<link rel="stylesheet" href="css/style.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</head>
<body>
<!-- %@include file="header.jsp" %-->

	<div class="nav" id="admin-nav">
		<div class="container">
			<ul class="pull-left">
				<li><a href="index">HOME</a></li>
			</ul>
			<ul class="pull-right">
			<h1 id="header-admin-page">Управляйте базой данных университета, господин Одмин!</h1>
			</ul>
		</div>
	</div>
	
	<div class="empty"></div>
	
	<article>
		<section class="students-list">
		
			<h2>Студенты</h2>	
			<a href="addStudent" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<!--<nav class="nav-local">
				<a href="addStudent" class="link-add">Добавить студента</a>
			</nav>-->
			<table class="table-students">
				<tr>
					<th>Действие</th>
					<th>ID</th>
					<th>Фамилия</th>
					<th>Имя</th>						
					<th>Отчество</th>
					<th>Группа</th>
					<th>Почта</th>				
					<th>Форма обучения</th>
					<th>Дата рождения</th>
					<th>Дата поступления</th>
					<th>Средняя оценка</th>
					<th>Размер стипендии</th>
				</tr>
				<c:forEach var="student" items="${students}">
					<tr>
						<td>
							<a href="addStudent?id=${student.getIdZ() }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteStudent?id=${student.getIdZ() }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
								style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${student.getIdZ()}</td>
						<td>${student.lastName}</td>
						<td>${student.firstName}</td>						
						<td>${student.thirdName}</td>
						<td>${student.academicGroup }</td>
						<td>${student.email }</td>
						<c:if test="${student.formOfStudies == 'K'}">
							<td>Контракт</td>
						</c:if>
						<c:if test="${student.formOfStudies == 'B'}">
							<td>Бюджет</td>
						</c:if>
						<td>${student.dateOfBirth}</td>
						<td>${student.dateOfEntry}</td>
						<td>${student.avarageMark}</td>
						<c:if test="${student.formOfStudies == 'K'}">
							<td>-</td>
						</c:if>
						<c:if test="${student.formOfStudies == 'B'}">
							<td>${student.scolarshipSize}</td>
						</c:if>
						
					</tr>
				</c:forEach>
			</table>
			<br><hr>	
		</section>
		
			
		<section class="groups-list">	
			<h2>Группы</h2>
			<a href="addGroup" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<table class="table-groups">
				<tr>
					<th>Действие</th>
					<th>ID</th>
					<th>Специализация</th>	
					<th>Номер</th>
					<th>Курс</th>
					<th>Количество студентов</th>
				</tr>
				<c:forEach var="academicGroup" items="${groups}">
					<tr>
						<td>
							<a href="addGroup?id=${academicGroup.groupId }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteGroup?id=${academicGroup.groupId }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
									style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${academicGroup.groupId }</td>
						<td>${academicGroup.specialization }</td>
						<td>${academicGroup.groupNumber }</td>
						<td>${academicGroup.course }</td>
						<td>${academicGroup.countOfStudents }</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>
		</section>
		
			
		<section class="marks-list">	
			<h2>Оценки</h2>
			<a href="addMark" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<table class="table-marks">
				<tr>
					<th>Действие</th>
					<th>ID оценки</th>
					<th>Дата</th>
					<th>Студент</th>
					<th>Балл</th>
					<th>Предмет</th>
				</tr>
				<c:forEach var="mark" items="${marks}">
					<tr>
						<td>
							<a href="addMark?id=${mark.idM }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteMark?id=${mark.idM }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
									style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${mark.idM }</td>
						<td>${mark.dateM }</td>
						<td>${mark.student }</td>
						<td>${mark.mark }</td>
						<td>${mark.subject }</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>
		</section>
		
			
		<section class="schedule-list">	
			<h2>Расписание</h2>
			<a href="addSchedule" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<table class="table-schedule">
				<tr>
					<th>Действие</th>
					<th>ID</th>
					<th>Дата</th>
					<th>Предмет</th>
					<th>Аудитория</th>
					<th>Номер пары</th>
					<th>Группа</th>
					<th>Преподаватель</th>
				</tr>
				<c:forEach var="schedule" items="${schedules }">
					<tr>
						<td>
							<a href="addSchedule?id=${schedule.id }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteSchedule?id=${schedule.id }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
									style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${schedule.id }</td>
						<td>${schedule.day }</td>
						<td>${schedule.subject }</td>
						<td>${schedule.room }</td>
						<td>${schedule.number }</td>
						<td>${schedule.academicGroup }</td>
						<td>${schedule.teacher }</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>
		</section>
		
		
		<section class="teachers-list">	
			<h2>Преподаватели</h2>
			<a href="addTeacher" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<table class="table-teachers">
				<tr>
					<th>Действие</th>
					<th>Табельный номер</th>
					<th>Фамилия</th>
					<th>Имя</th>
					<th>Отчество</th>
					<th>Почта</th>
					<th>Должность</th>
					<th>Стаж работы</th>
				</tr>
				<c:forEach var="teacher" items="${teachers }">
					<tr>
						<td>
							<a href="addTeacher?id=${teacher.idTable }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteTeacher?id=${teacher.idTable }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
									style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${teacher.idTable }</td>
						<td>${teacher.lastName }</td>
						<td>${teacher.firstName }</td>												
						<td>${teacher.thirdName }</td>
						<td>${teacher.email }</td>
						<td>${teacher.post }</td>
						<td>${teacher.experience }</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>
		</section>
			
		<section class="subjects-list">
			<h2>Предметы</h2>
			<a href="addSubject" class="link-add">  
				<img class="img-icon" alt="add" src="img/add_icon.png" 
				title="add new" style="width: 35px; height: auto;">
			</a>
			<table class="table-subjects">
				<tr>
					<th>Действие</th>
					<th>ID</th>
					<th>Название</th>
					<th>К-во часов</th>
					<th>Форма занятия</th>
				</tr>
				<c:forEach var="subject" items="${subjects }">
					<tr>
						<td>
							<a href="addSubject?id=${subject.idS }" class="link-action">
							<img src="img/edit_icon.png" alt="edit" 
								style="width: 25px; height: auto;">
							</a>
							<a href="deleteSubject?id=${subject.idS }" class="link-action">
							<img src="img/delete_icon.png" alt="delete" 
									style="width: 25px; height: auto;">
							</a>
						</td>
						<td>${subject.idS }</td>
						<td>${subject.name }</td>
						<td>${subject.countOfHours }</td>
						<td>${subject.form }</td>
					</tr>
				</c:forEach>
			</table>
			<br><hr>
			
		</section>
	</article>
	
	
	<%@include file="footer.jsp" %>
</body>
</html>