var allowSubmit = true;

$(document).ready(function(){
	validateAll();
	
	$( "#form_add" ).submit(function( event ) {
		validateAll();
		if(!allowSubmit)
		  event.preventDefault();
	});
});

function validateAll(){
	
	$('#fname').blur(function(){
		var firstName = $('#fname').val();
		validateName(firstName, 3, $('#fname'), $('#span_fname'));
	});
	
	
	$('#lname').blur(function(){
		var lastName = $('#lname').val();
		validateName(lastName, 3, $('#lname'), $('#span_lname'));
	});
	
	
	$('#email').blur(function(){
		var emailAddress = $('#email').val();
		validateEmail(emailAddress,$('#email'),$('#span_email'));
	});
	
	
	$('#password').blur(function() {
		var passwd = $('#password').val();
		validateName(passwd, 6, $('#password'), $('#span_password'));
	});
	
	
	$('#date').blur(function(){
		   var dtVal=$('#date').val();
		   if(validateDate(dtVal)){
			   $('#span_date').html('&#10003').css('color', 'green').css('font-size', '1em');
			   $('#date').css('border-color', 'initial').css('border-radius','3px').css('border-width', '1px');
		   }
		   else{
			   $('#date').css('border-color', '#FF9900').css('border-radius','3px');
			   $('#span_date').text('* invalid date format. Must be dd/mm/yyyy').css('color', 'red').css('font-size', '1em');
		   }
	});
	
	
	$('#entrydate').blur(function(){
		   var dtVal=$('#entrydate').val();
		   if(!dtVal){
			   var d = new Date();
			   dtVal = d.getDate() + '/' +(d.getMonth()+1) + '/' + d.getFullYear();
			   $('#entrydate').val(dtVal);
		   }
		   if(validateDate(dtVal)){
			   $('#span_entry_date').html('&#10003').css('color', 'green').css('font-size', '1em');
			   $('#entrydate').css('border-color', 'initial').css('border-radius','3px').css('border-width', '1px');
		   }
		   else{
			   $('#entrydate').css('border-color', '#FF9900').css('border-radius','3px');
			   $('#span_entry_date').text('* invalid date format').css('color', 'red').css('font-size', '1em');
		   }
	});
	
	
	$('#mark').blur(function(){
		var averageMark = $('#mark').val();
		validateNumber(averageMark, 1, 100, $('#mark'), $('#span_mark'));
	});
	
	$('#salary').blur(function(){
		var scolarshipSize = $('#salary').val();
		if(!scolarshipSize){
			scolarshipSize = 0;
			$('#salary').val(0);
		}
		validateNumber(scolarshipSize, 0, 100000, $('#salary'), $('#span_salary'));
	});
	
	
	$('#cnt_students').blur(function(){
		var countOfStudents = $('#cnt_students').val();
		if(!countOfStudents){
			countOfStudents = 0;
			$('#cnt_students').val(countOfStudents);
		}
		validateNumber(countOfStudents, 0, 40, $('#cnt_students'), $('#span_cnt_students'));
	});
	
	
	$('#course').blur(function(){
		var course = $('#course').val();
		if(!course){
			course = 1;
			$('#course').val(course);
		}
		validateNumber(course, 1, 6, $('#course'), $('#span_course'));
	});
	
	
	$('#exp').blur(function(){
		var course = $('#exp').val();
		validateNumber(course, 0, 70, $('#exp'), $('#span_exp'));
	});
	
	
	$('#specialization').blur(function(){
		var specialization = $('#specialization').val();
		validateName(specialization, 2, $('#specialization'), $('#span_specialization'));
	});	
	
	
	$('#room').blur(function(){
		var room = $('#room').val();
		validateNumber(room, 1, 9999, $('#room'), $('#span_room'));
	});
	
	$('#number').blur(function(){
		var number = $('#number').val();
		validateNumber(number, 1, 8, $('#number'), $('#span_number'));
	});
	
	$('#countHours').blur(function(){
		var countHours = $('#countHours').val();
		validateNumber(countHours, 1, 300, $('#countHours'), $('#span_hours'));
	});
	
	$('#name').blur(function(){
		var specialization = $('#name').val();
		validateName(specialization, 4, $('#name'), $('#span_name'));
	});	
	
}


function validateDate(dtValue){
	var dtRegex = new RegExp('^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./]([0]?[1-9]|[1][0-2])[./]([0-9]{4})$'); //(/\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/);
	return dtRegex.test(dtValue);
}

function validateNumber(number, min, max, input, span){
	if(isNaN(number)){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* not a number').css('color', 'red').css('font-size', '1em');
		allowSubmit = false;
	} else
	if(number < min || number > max){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* параметр должен быть в диапазоне [' + min + '..' + max + ']')
			.css('color', 'red')
			.css('font-size', '1em');
		allowSubmit = false;
	} else {
		span.html('&#10003').css('color', 'green').css('font-size', '1em');
		input.css('border-color', 'initial').css('border-radius','3px').css('border-width', '1px');
		allowSubmit = true;
	}
}

function validateName(name, min, input, span){
	if (name.length == 0){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* это поле обязательно').css('color', 'red').css('font-size', '1em');
		allowSubmit = false;
		//$('.send').attr('disabled',true);
	} else
	if (name.length < min){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* field must be at least ' + min + ' characters long!').css('color', 'red').css('font-size', '1em');
		allowSubmit = false;
		//$('.send').attr('disabled',true);
	}
	else{
		span.html('&#10003').css('color', 'green').css('font-size', '1em');
		input.css('border-color', 'initial').css('border-radius','3px').css('border-width', '1px');
		allowSubmit = true;
		//$('#send').removeAttr('disabled');
	}
}

function validateEmail(emailAddress, input, span){
	var at = emailAddress.indexOf('@');
	var dot = emailAddress.indexOf('.');
	
	if (emailAddress.length == 0){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* это поле обязательно').css('color', 'red').css('font-size', '1em');
		allowSubmit = false;
	}
	else 
	if (at<1 || dot <1){
		input.css('border-color', '#FF9900').css('border-radius','3px');
		span.text('* email введен не верно').css('color', 'red');
		allowSubmit = false;
	}
	else{
		span.html('&#10003').css('color', 'green').css('font-size', '1em');
		input.css('border-color', 'initial').css('border-radius','3px').css('border-width', '1px');
		allowSubmit = true;
	}
}
