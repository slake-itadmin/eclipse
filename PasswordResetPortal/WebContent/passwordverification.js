$(document).ready(function() {
	$('#new_password').keyup(function() {
		// set password variable
		var pswd1 = $(this).val();

		//validate letter
		if (pswd1.match(/[A-Za-z]/)) {
			$('#letter').removeClass('invalid').addClass('valid');
		} else {
			$('#letter').removeClass('valid').addClass('invalid');
		}

		//validate capital letter
		/*if (pswd1.match(/[A-Z]/)) {
			$('#capital').removeClass('invalid').addClass('valid');
		} else {
			$('#capital').removeClass('valid').addClass('invalid');
		}*/

		//validate number
		if (pswd1.match(/\d/)) {
			$('#number').removeClass('invalid').addClass('valid');
		} else {
			$('#number').removeClass('valid').addClass('invalid');
		}
		
		//validate symbol
		if (pswd1.match(/\W/)) {
			$('#symbol').removeClass('invalid').addClass('valid');
		} else {
			$('#symbol').removeClass('valid').addClass('invalid');
		}
		
		//validate the length
		if (pswd1.length < 6) {
			$('#length_1').removeClass('valid').addClass('invalid');
		} else {
			$('#length_1').removeClass('invalid').addClass('valid');
		}

	}).focus(function() {
		$('#pswd_info_1').show();
	}).blur(function() {
		$('#pswd_info_1').hide();
	});
});