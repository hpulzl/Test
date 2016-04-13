$(document).ready(function(){
	$("#psd_info").hide();
	$("#name_info").hide();
	$('#login').click(function() {
		var name_state = $('#name');
		var psd_state = $('#psd');
		var name = $('#name').val();
		var psd = $('#psd').val();
		if (name == '' || name == null) {
			$("#name_info").show();
			return false;
		} else if (psd == '' || psd == null) {
			$("#psd_info").show();
			return false;
		} else {
			$("#psd_info").hide();
			$("#name_info").hide();
			//账号密码全部填写之后，提交到后台的servlet
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"AdminLoginSer",
		        data:{adminName : name , adminPassword : psd},
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("登录失败");
			        }else{
			        	alert("登录成功");
			        	/**
			        	 * 使用window.location.href="HomePage.jsp";不管用。可能是
			        	async: false导致的。在网上找到了这个方法.
			        	**/
			        	document.forms[0].action = "HomePage.jsp";
			        	document.forms[0].submit();
			        }
		      	}
	    	});
		}
	});
});
