<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatepassword.jsp' starting page</title>
    
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
  	<strong>${message}</strong>
	<form action="updatepassword.do" method = "post">
		<p>
			<label>旧密码:<input name = "oldPassword"/></label>			
		</p>
		<p>
			<label>新密码:<input name = "newPassword"/></label>
		</p>
		<p>
			<label>新密码确认:<input name = "newPasswordConfirm"/></label>
		</p>
		<p>
			<button type = "submit">确定</button>
			<a href = "wellcom.jsp">返回</a>
		</p>
	</form>
  </body>
</html>
