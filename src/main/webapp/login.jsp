<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	if(window.top!==window){
  		window.top.location.href = window.location.href;
  	}
  </script>
  
  <body>
  	<strong>${message}</strong>
	<form action="login.do" method = "post">
		<p>
			<label>Account:<input name = "account" value = "0001"/></label>			
		</p>
		<p>
			<label>Password:<input name = "password" type = "password" value = "123456"/></label>
		</p>
		<p>
			<button type = "submit">Login</button>
		</p>
	</form>
	<form action="vip/qry.do" method = "post">
		<input name = "code" value = "13888888888"/>
		<button type = "submit" >点击查询</button>
	</form>
	<%session.removeAttribute("message"); %>
  </body>
</html>
