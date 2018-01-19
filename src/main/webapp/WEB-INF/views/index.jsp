<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    <style type="text/css">
    	menu, h1, ul{
    		margin : 0;
    	}
    	html, body{
    		margin : 0;
    		height : 100%;
    		font-size : 14px;
    	}
    	body>header{
    		line-height : 80px;
    		text-align : center;
    		background : #999;
    	}
    	body>header>h1{
    		display : inline;
    		txt-align : center
    	}
    	.body{
    		position : absolute;
    		top : 80px;
    		bottom : 0;
    		width : 100%;
    	}
    	.body>menu{
    		position : absolute
			left : 0;
    		width : 180px;
    		heigth : 100%;	
    		background : #eee;
    		box-sizeing : border-box;
    	}
    	.body>main{
    		margin-left : 200px;
    		height : 100%;
    		width : 100%;
    	}
    	main>iframe{
    		height : 100%;
    		width : 100%;
    		boder : 0;
    		display : block;
    	}
    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<header>
  		<h1>佳佳乐VIP消费查询系统</h1>
  		<span>
  			<b>${sessionScope.currentUser.name}</b>
  			<a href = "logout.do">退出登录</a>
  		</span>
  	</header>
  	<section class = "body">
  		<menu>
  			<li>
  				<a>VIP客户查询</a>
  			</li>
  			<li>
  				<a>录入VIP客户</a>
  			</li>
  			<li>
  				<a>VIP客户管理</a>
  			</li>
  			<li>
  				<a>查看VIP消费记录</a>
  			</li>
  			<li>
  				<a>录入VIP消费记录</a>
  			</li>
  			<li>
  				<a>VIP消费记录管理</a>
  			</li>
  			<li>
  				<a href = "updatepassword.do" target = "mainFrame">修改密码</a>
  			</li>
  		</menu>
  		<main>
  			<iframe src = "wellcome.do" name = "mainFrame"></iframe>
  		</main>
  	</section>
  </body>
</html>
