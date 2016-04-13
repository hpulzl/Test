<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="qb.entity.Qusbank"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改试题界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  </head>
  
<body class=""> 
  <!--<![endif]-->
    <%
      Qusbank qus = (Qusbank)request.getAttribute("qusbank");
    %>
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> 管理员
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="HomePage.jsp">关于</a></li>
                            <li class="divider"></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="#">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="HomePage.jsp"><span class="first">信息安全考试系统</span> <span class="second">后台管理 </span></a>
        </div>
    </div>
    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>主页管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="HomePage.jsp">主页</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>试卷管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li class="active"><a href="TestPaperSer">试卷操作</a></li>
            <li ><a href="selectQusandTestSer?pageNo=1">一键生成试卷</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>试题管理<i class="icon-chevron-up"></i></a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="addQusbank.jsp">添加试题</a></li>
            <li ><a href="SelectQusbankSer?pageNo=1">试题操作</a></li>
        </ul>
    </div>
     <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">修改试题信息</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="HomePage.jsp">主页</a> <span class="divider">/</span></li>
            <li><a href="SelectQusbankSer">试题操作</a> <span class="divider">/</span></li>
            <li class="active">修改试题</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" id="updateQusbank"><i class="icon-save"></i> 保存</button>
    <button id="reloadQusbank" class="btn">刷新</button>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active">修改</li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
     <%if(qus!=null){ %>
	    <form id="qustab">
	        <label>试题及选项</label>
	        <textarea type="text" id="qusissue"  class="span3" row="30" cols="10" ><%=qus.getQusissue() %></textarea>
	        <p class="text-warning" id="qusissue_info">请输入试题及选项</p>
	        <input type="hidden" id="qusid" value="<%=qus.getQusid() %>" >
	        <label>试题答案</label>
	        <input id="qusanswer" type="text"  value="<%=qus.getQusanswer() %>" class="span3">
	        <p class="text-warning" id="qusanswer_info">请输入试题答案</p>
	        <label>试题类型</label>
	        <select name="qusType" id="qusType" class="input-xlarge">
	        <%if(qus.getQustype().equals("多选题")){ %>
	          <option  selected="selected" value="多选题">多选题</option>
	          <option value="判断题">判断题</option>
	          <option value="单选题">单选题</option>
	          <%}else if(qus.getQustype().equals("单选题")){
	          %>
	          	  <option   value="多选题">多选题</option>
		          <option value="判断题">判断题</option>
		          <option selected="selected" value="单选题">单选题</option>
		      <%}else{ %>
		      	  <option  value="多选题">多选题</option>
		          <option selected="selected" value="判断题">判断题</option>
		          <option value="单选题">单选题</option>
		      <%} %>
	    	</select>
	    </form>
    <%} %>
      </div>
  </div>
</div>
        </div>
    </div>
    </div>
 <script src="lib/bootstrap/js/bootstrap.js"></script>
 <script src="myjs/adminoperator.js" type="text/javascript"></script>
 </body>

</html>
