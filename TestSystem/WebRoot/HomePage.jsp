<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="qb.service.UserService"%>
<%@page import="qb.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is Home Page">
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
    	UserService us = new UserService();
    	List<User> userList = us.userListByPage(1, 10);
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
            <li class="active"><a href="HomePage.jsp">主页</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>试卷管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="TestPaperSer?pageNo=1">试卷操作</a></li>
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
	            <h1 class="page-title">管理员主页</h1>
	        </div>
	        
	        <ul class="breadcrumb">
	            <li><a href="HomePage.jsp">主页</a> <span class="divider">/</span></li>
	            <li class="active">我的主页</li>
	        </ul>
	<div class="container-fluid">
		<div class="row-fluid">
		    <div class="alert alert-info">
		        <button type="button" class="close" data-dismiss="alert">×</button>
		        <strong>重要通知：</strong> 管理员主界面更新了！ 
		    </div>
		</div>
		<div class="row-fluid">
		    <div class="block span6">
		        <a href="#tablewidget" class="block-heading" data-toggle="collapse">已注册用户<span class="label label-warning">+10</span></a>
		        <div id="tablewidget" class="block-body collapse in">
		            <table class="table">
		              <thead>
		                <tr>
		                  <th>姓名</th>
		                  <th>班级</th>
		                </tr>
		              </thead>
		              <tbody>
		               
		                <%
		                	if(userList!=null && userList.size()>0){
		                	  for(User u : userList){
		                %>
		                 <tr>
		                  <td><%=u.getUsername() %></td>
		                  <td><%=u.getUserclass() %></td>
		                  </tr>
	                  <%
	                  	}
	                  } 
	                  %>
		                
		              </tbody>
		            </table>
		        </div>
		    </div>
		    <div class="block span6">
		        <a href="#widget1container" class="block-heading" data-toggle="collapse">操作指南 </a>
		        <div id="widget1container" class="block-body collapse in">
		            <h2>管理员操作手册</h2>
		            <p></p>
		            <p>管理员需要手动添加试题，将试题添加完毕后，点击一键生成试卷，产生试卷。</p>
		            <p>管理员添加试卷，添加试卷的问题，类型，答案。</p>
		            <p>管理员一键生成试卷，需要选择试卷的难易程度，试卷的名称（名称不能重复）。</p>
		        </div>
		    </div>
		   </div>
		</div>
	</div>
 <script src="lib/bootstrap/js/bootstrap.js"></script>
  </body>
</html>
