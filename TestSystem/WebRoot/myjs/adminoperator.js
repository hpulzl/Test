$(document).ready(function(){
	 $("[rel=tooltip]").tooltip();
     $(function() {
         $('.demo-cancel-click').click(function(){return false;});
     });
     //删除试卷的信息 添加的点击事件
	$("button#delconfirm").click(function(){
		var testid = $("#"+test).val();
		$.ajax({
	        cache: true,
	        type: "POST", 
	        url:"AdminDelSer",
	        data:{testid : testid},
	        async: false,
	        dataType:"json",
	        success: function(data) {
		        if(data ==false){
		        	alert("删除失败");
		        }else{
		        	window.location.reload(this);
		        }
	      	}
    	});
	});
	//刷新界面 所添加的点击事件
	$("button#reloadtestPaper").click(function (){
		window.location.reload(this);
	});
	//更新数据，点击更新按钮后添加更新的方法。
	$("#saveTestpaper").click(function(){
		var testname = $("#testname").val();
		var testdifficult = $("#difficult  option:selected").val();
		var testid = $("#testid").val();
		$.ajax({
	        cache: true,
	        type: "POST", 
	        url:"AdminUpdateSer",
	        data:{testname : testname ,testdifficult : testdifficult,testid : testid},
	        async: false,
	        dataType:"json",
	        success: function(data) {
		        if(data ==false){
		        	alert("修改失败!");
		        }else{
		        	alert("修改成功!");
		        }
	      	}
    	});
	});
	var jsonTestid = "";
	//添加试卷，点击跳转至添加界面
	$("#addTest_btn").click(function(){
		window.location.href = "addTestpaper.jsp";
	});
	$("#testname_info").hide();
	//添加试卷，点击添加按钮，将数据提交到后台进行添加操作。
	$("#addTestpaper").click(function(){
		var testname = $("#add_testname").val();
		var testdifficult = $("#add_difficult  option:selected").val();
		
		if(testname==null || testname==""){
			$("#testname_info").show();
		}else{
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"AdminAddTestpaperSer",
		        data:{testname : testname ,testdifficult : testdifficult},
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("添加失败!");
			        }else{
			        	alert("添加成功!");
			        	$.each(data,function(index,val){
			        		jsonTestid = val.testid;
			        	});
			        }
		      	}
	    	});
		}
	});
	$("#createTip").hide();
	//点击一键生成按钮，在后台生成试卷
	$("#creat_testPaper").click(function(){
		if(jsonTestid==null || jsonTestid==""){
			$("#createTip").show();
			return;
		}
		$.ajax({
	        cache: true,
	        type: "POST", 
	        url:"CreateTestPaperSer",
	        data:{jsonTestid : jsonTestid},
	        async: false,
	        dataType:"json",
	        success: function(data) {
		        if(data ==false){
		        	alert("生成试卷失败!");
		        }else{
		        	alert("生成试卷成功!");
		        	window.location.reload(this);
		        }
	      	}
    	});
	});
	//一键生成试卷界面，点击生成试卷，执行对应的方法。
	/*$("#createTestandQus").click(function(){
		var testandQusid = $("#"+testandQus).val();
		if(testandQusid!=null || testandQusid!=""){
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"CreateTestPaperSer",
		        data:{jsonTestid : testandQusid},
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("生成试卷失败!");
			        }else{
			        	alert("生成试卷成功!");
			        	window.location.reload(this);
			        }
		      	}
	    	});
		}
	});*/
	
	
	//删除一键生成试卷.
	$("#delCreateTestpaper").click(function(){
		var testandQusid = $("#"+testandQus).val();
		if(testandQusid!=null || testandQusid!=""){
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"DelCreateTestpaperSer",
		        data:{jsonTestid : testandQusid},
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("删除失败!");
			        }else{
			        	alert("删除成功!");
			        	window.location.reload(this);
			        }
		      	}
	    	});
		}
	});
	//先设置两个提示信息为隐藏。
	$("#qusissue_info").hide();
	$("#qusanswer_info").hide();
	//添加试题，点击添加按钮，在后台进行添加操作。
	$("#addQusbank_btn").click(function(){
		var qusissue = $("#add_qusissue").val();
		var qusType = $("#add_qusType option:selected").val();
		var qusanswer = $("#add_qusanswer").val();
		
		if(qusissue==null || qusissue==""){
			$("#qusissue_info").show();
		}else if(qusanswer==null || qusanswer==""){
			$("#qusanswer_info").show();
		}else{
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"AddQusbankSer",
		        data:{qusissue : qusissue ,qusType : qusType ,qusanswer :qusanswer },
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("添加失败!");
			        }else{
			        	alert("添加成功!");
			        	window.location.reload(this);
			        }
		      	}
	    	});
		}
	});
	//查询试题界面，点击添加试题按钮，直接跳转到添加试题界面
	$("#addQus_btn").click(function(){
		window.location.href = "addQusbank.jsp";
	});
	var qus ="";
	var test = "";
	var testandQus = "";
	//找到表格的所在行数
	$("table td").click(function(){
		var row = $(this).parent().index()+1; //行位置
		qus = "qusid"+row;
		test = "testid"+row;
		testandQus = "testqusid"+row;
	});
	$("#delQusconfirm").click(function(){
		var qusid = $("#"+qus).val();
		$.ajax({
			type: "POST",
			url: "DelQusbankSer",
			data:{qusid : qusid},
			dataType:"json",
			success: function(data){
				if(data ==false){
		        	alert("删除失败!");
		        }else{
		        	alert("删除成功!");
		        	window.location.reload(this);
		        }
			}
		});
	});
	//点击刷新
	$("#reloadQusbank").click(function(){
		window.location.reload(this);
	});
	$("#qusissue_info").hide();
	$("#qusanswer_info").hide();
	//修改试题，点击修改试题
	$("#updateQusbank").click(function(){
		var qusissue = $("#qusissue").val();
		var qusanswer = $("#qusanswer").val();
		var qusid = $("#qusid").val();
		var qusType = $("#qusType option:selected").val();
		
		if(qusissue==null||qusissue==""){
			$("#qusissue_info").show();
		}else if(qusanswer==null||qusanswer==""){
			$("#qusanswer_info").show();
		}else{
			$.ajax({
		        cache: true,
		        type: "POST", 
		        url:"ToUpdateQusbankSer",
		        data:{qusissue : qusissue ,qusType : qusType 
				,qusanswer :qusanswer ,qusid : qusid},
		        async: false,
		        dataType:"json",
		        success: function(data) {
			        if(data ==false){
			        	alert("修改失败!");
			        }else{
			        	alert("修改成功!");
			        	window.location.reload(this);
			        }
		      	}
	    	});
		}
	});
});
function create(id){
	var testandQusid = id;
	if(testandQusid!=null || testandQusid!=""){
		$.ajax({
	        cache: true,
	        type: "POST", 
	        url:"CreateTestPaperSer",
	        data:{jsonTestid : testandQusid},
	        async: false,
	        dataType:"json",
	        success: function(data) {
		        if(data ==false){
		        	alert("生成试卷失败!");
		        }else{
		        	alert("生成试卷成功!");
		        	window.location.reload(this);
		        }
	      	}
    	});
	}
}