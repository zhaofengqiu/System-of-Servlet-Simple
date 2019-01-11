$(document).ready(function() {
	$("form").submit(function() {
		console.log("test");
		if($('#name').val() == "" || $('#password').val() == ""){
			alert("用户名和密码不能为空");
			return false
		}
	});
	$('#reg').click(function() {
		var reMethod = "POST",
		pwdmin = 6;
		if ($('#name').val() == "") {
			$('#alert').html("用户名不能为空");
			return false;
		}
		var suser =   /^[0-9a-zA-Z]+$/;
		if (!suser.test($('#name').val())) {
			$('#alert').html("用户名只能由数字和字母组成");
			return false;
		} 
		if ($('#name').val().length < 4 || $('#name').val().length > 16) {
			$('#alert').html("用户名位4-16字符");
			return false;
		}
		if ($('#password').val().length < pwdmin) {
			$('#password').focus();
			$('#alert').html("密码不能小于" + pwdmin + "位");
			return false;
		}	
		if ($('#re-password').val() != $('#password').val() && $('#re-password').val() == "") {
			$('#re-password').focus();
			$('#alert').html("两次密码不一致!");
			return false;
		}
		var sphone =  /^1(3|4|5|7|8)\d{9}$/;
		if (!sphone.test($('#phone').val()) || $('#phone').val().length !=11) {
			$('#alert').html("手机号码格式不正确!");
			
			return false;
		} 
		var semail =  /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
			if (!semail.test($('#email').val())) {
				$('#alert').html("邮箱格式不正确!");
				return false;
			}else{
				$('#alert').html("");
			}
		var spostcode = /^[0-9]{6}$/;
		if (!spostcode.test($('#postcode').val())) {
			$('#alert').html("邮编格式不正确!");
			return false;
		}else{
			$('#alert').html("");
		}
		
		$.ajax({
			type: reMethod,
			url: "regist.jhtml",
			data: "name=" + $("#name").val() + '&password=' + $("#password").val() + 
					'&phone=' + $("#phone").val()+ '&email=' + $("#email").val()+ 
							'&postcode=' + $("#postcode").val(),
			dataType: 'html',
			success: function(result) {

				if (result.length > 2) {
					$('#alert').html("注册成功!");
					return false;
				} else {
					$('#alert').html("注册失败!");
					return true;
				}     

			}
		});
	});
	

});