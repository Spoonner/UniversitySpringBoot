<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Add student</title>
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
		<img src="img/student-icon-1106111526.png">
    </div>

	<div class="adder">
    	<div class="container">
			<h1>Добавить студента</h1>
		
			<form name="id" action="addStudent?id=${id }" method="get" id="form_add" 
				onsubmit="return validate()">
				<input type="text" name="id" value="${id }" hidden>
				<label> Name: </label>
				<input type="text" name="fname" value="${fname }" id="fname" maxlength="50" size="15" placeholder="First name" required> 
				<span id='span_fname'>*</span><br> 
				<label></label>
				<input type="text" name="lname" id="lname" value="${lname }" maxlength="50" size="15" placeholder="Last name" required>
				<span id='span_lname'>*</span><br> 
				<label></label>
				<input type="text" name="tname" id="tname" value="${tname }" maxlength="50" size="15" placeholder="Third name">
				<span id='span_tname'></span><br> 
				
				<label> E-mail: </label>
				<input type="email" name="email" id="email" value="${email }" maxlength="50" size="30" placeholder="example@mail.com" required>
				<span id='span_email'>*</span><br>
				
				<label> Password: </label>
				<input type="password" name="password" value="${password }" id="password" maxlength="32" required>
				<span id='span_password'>*</span><br>
				
				<label> Date of birth:</label>
				<input type="text" name="birthdate" value="${birthdate }" id="date" placeholder="13/01/1994" required> 
				<span id='span_date'>*</span><br>
				
				<label> Entry date: </label>
				<input type="text" name="entrydate" value="${entrydate }" id="entrydate" placeholder="01/09/2012" required>
				<span id='span_entry_date'>*</span><br>
				
				<label> Size of the scolarship: </label>
				<input type="number" step="0.01" min="0" name="scolar" value="${scolar }" id="salary" placeholder="550.65"/>
				<span id='span_salary'></span><br>
				
				<label> Form of studies:</label>
				<c:choose>
					<c:when test="${form == 'K' }">
						<input type="radio" name="form" value="B"> Budget  </input>
						<input type="radio" name="form" value="K" checked> Contract</input><br>
					</c:when>
					<c:when test="${form == 'B' }">
						<input type="radio" name="form" value="B" checked> Budget  </input>
						<input type="radio" name="form" value="K"> Contract</input><br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="form" value="B"> Budget  </input>
						<input type="radio" name="form" value="K" checked> Contract</input><br>
					</c:otherwise>		
				</c:choose>
				
				<label> Group:</label>
				<select name="academicGroup">
					<c:forEach var="academicGroup" items="${groups}">
						<c:choose>
							<c:when test="${currentGroup == academicGroup }">
								<option value="${academicGroup.groupId }" selected>${academicGroup.groupNumber }</option>
							</c:when>
							<c:otherwise>
								<option value="${academicGroup.groupId }">${academicGroup.specialization}-${academicGroup.groupNumber }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<br>
				
				<c:choose>
					<c:when test="${currentGroup != null }">
						<input type="submit"  id="send" name="buttonPressed" value="Change" />
					</c:when>
					<c:otherwise>
						<input type="submit"  id="send" name="buttonPressed" value="Submit" />
					</c:otherwise>
				</c:choose>
				
				
				<input type="reset" value="Reset" />
			</form>
		</div>
	</div>

</body>
</html>