$(document).ready(function() {
	
	$('#update').click(function() {
		if(confirm("是否需要增加该联系人？")==false){
			return false
		}
		var reMethod = "POST";
		$.ajax({
			type: reMethod,
			url: "contains.jhtml?choice=update",
			data: "name=" + $("#name").val() +  '&sex=' + $("#sex").val() + 
					'&phone=' + $("#phone").val()+ '&email=' + $("#email").val()+
					  '&qq=' + $("#qq").val()+ '&workspace=' + $("#workspace").val()+
					    '&address=' + $("#address").val() + '&postcode=' + $("#postcode").val(),
			dataType: 'html',
			success: function(result,status, xhr) {
				if(xhr.status==200){
					alert("更新成功")
				}else{
					alert("更新失败")
				}

			}
		});
	});
	$('#sendmsg').click(function() {
		if(confirm("是否需要发送该信息？")==false){
			return false
		}
		var reMethod = "POST";
		$.ajax({
			type: reMethod,
			url: "messages.jhtml?choice=update",
			data: "reciver=" + $("#reciver").val() + '&content=' + $("#content").val() + 
					'&sender=' + $("#sender").val(),
			dataType: 'html',
			success: function(result,status, xhr) {
				if(xhr.status==200){
					alert("发送成功")
				}else{
					alert("发送失败")
				}

			}
		});
	});
	
	$('#changemsg').click(function() {
		if(confirm("是否需要更新个人信息？")==false){
			return false
		}
		var reMethod = "POST";
		$.ajax({
			type: reMethod,
			url: "informsg.jhtml?choice=changemsg",
			data: "name=" + $("#name").val() + '&id=' + $("#userid").val()  +'&password=' + $("#password").val() + 
					'&phone=' + $("#phone").val()+ '&email=' + $("#email").val()+ 
							'&postcode=' + $("#postcode").val(),
			dataType: 'html',
			success: function(result,status,xhr) {
				if(xhr.status==200){
					alert("修改成功");
				}else{
					alert("修改失败");
				}

			}
		});
	});
	
});
function deleteuser(id){
	var reMethod = "POST";
	if(confirm("是否需要删除该用户？")==false){
		return false
	}
	$.ajax({
		type: reMethod,
		url: "contains.jhtml",
		data :"choice=delete&"+"id="+id,
		dataType: 'html',
		success: function(result,status,xhr) {
			if(xhr.status==200){
				alert("修改成功");
			}else{
				alert("修改失败");
			}

		}
	});
	$(location).attr('href', 'contains.jhtml');
}

function saveUserImg(){
    var file = document.getElementById("imgOne").files[0]; //获取微模块信息
    var formData = new FormData(); //创建表单
    formData.append('image', file);
    $.ajax({
        url: "informsg.jhtml?choice=updateimg",
        type: "POST",
        data: formData,
        contentType: false,
        processData: false,
        async:false,
        cache: false,
        complete:function(data){
            alert("上传成功");

        }
    });
}
function preImg(sourceId) {

	if(!isNormalPic())
		return;
	//获得图片的保存路径
	var url = getFileUrl(sourceId);
	//显示经过等比缩放后的大图
	$("#UserImg").attr("src",url);
}

//获得图片的保存路径
function getFileUrl(sourceId) {
	var url;
	if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
		url = document.getElementById(sourceId).value;
	} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	}

	return url;
}

//验证文件类型与文件大小
function isNormalPic(){

	var fileName = document.getElementById("imgOne").value;

	if(fileName.trim() == "")
		return false;

	var fileSize = document.getElementById('imgOne').files[0].size;
	var str = fileName.substring(fileName.lastIndexOf("\\")+1);
	var end = str.substring(str.indexOf(".")+1);
	if(fileName !=null && (end.toLowerCase() != "png" && end.toLowerCase() != "jpg" && end.toLowerCase() != "gif")){
		alert("头像目前只支持(PNG、GIF、JPG)");
		return false;
	}
	if(fileSize > 2 * 1024 * 1024) {
		alert("上传文件不能超过(2Mb)");
		return false;
	}
	return true;
}

