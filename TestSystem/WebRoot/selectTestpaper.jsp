<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="qb.entity.Testpaper"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is select qusbank page">
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
 	<%
    	response.setCharacterEncoding("utf-8");
    	request.setCharacterEncoding("utf-8");
    	List<Testpaper> list =(List<Testpaper>)request.getAttribute("list");
    	Integer totalPage = (Integer)request.getAttribute("totalPage");
    	Integer pagenumber = (Integer)request.getAttribute("pageNo");
     %>
  <!--<![endif]-->
    
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
            <li class="active"><a href="TestPaperSer?pageNo=1">试卷操作</a></li>
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
            <h1 class="page-title">试卷列表</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="HomePage.jsp">主页</a> <span class="divider">/</span></li>
            <li class="active">试卷列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
	<div class="btn-toolbar">
	    <button id="addTest_btn" class="btn btn-primary"><i class="icon-plus"></i> 添加试卷</button>
	  <div class="btn-group">
	  </div>
	</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>序号</th>
          <th>试卷名</th>
          <th>试卷难度</th>
          <th>题量</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <%
      if(list!=null&&list.size()>0){
      	int i=1;
      	Iterator<Testpaper> it = list.iterator();
        while(it.hasNext()){
        Testpaper t = it.next();
        %>	
        <tr>
         <td><%=i++%></td>
          <td><%=t.getTestname()%></td>
          <td><%=t.getTestdifficult()%></td>
          <td>30</td>
          <td>
              <a href="AdminUpdateTestSer?testid=<%=t.getTestid() %>"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal">
              <input type="hidden" id="testid<%=i-1 %>" value='<%=t.getTestid() %>'>
              <i class="icon-remove"></i></a>
          </td>
        </tr>
       <%
       }
       }
       %>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
    <%
    	if(pagenumber<=1){
    %>
    	 <li><a>上一页</a></li>
    	 <li><a href="TestPaperSer?pageNo=<%=++pagenumber %>">下一页</a></li>
    <%
    	}else if(pagenumber >= totalPage){
    %>
     	<li><a href="TestPaperSer?pageNo=<%=--pagenumber %>">上一页</a></li>
    	<li><a>下一页</a></li>
    <%
    	}else{ 
    	Integer p = pagenumber;
    %>
        <li><a href="TestPaperSer?pageNo=<%=--p %>">上一页</a></li>
        <li><a href="TestPaperSer?pageNo=<%=++pagenumber %>">下一页</a></li>
    <%
    	} 
    %>
    </ul>
  </div>
	<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h3 id="myModalLabel">删除 </h3>
	    </div>
	    <div class="modal-body">
	        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除该试卷吗？</p>
	    </div>
	    <div class="modal-footer">
	        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	        <button class="btn btn-danger" data-dismiss="modal" id="delconfirm">确定</button>
	    </div>
	</div>
       </div>
   </div>
</div>
 <script src="lib/bootstrap/js/bootstrap.js"></script>
 <script src="myjs/adminoperator.js" type="text/javascript"></script>
 </body>
 </html>
