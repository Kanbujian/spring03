<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户信息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	    .inCenter{
	      margin:20px auto;width:300px 
	    }
	</style>

  </head>
  
  <body>
  <div class="inCenter"> 
    UserName:${user.username}</br>
    PassWord:${user.password}</br>
    Email    &nbsp; :${user.email }</br>
    </div>
  </body>
</html>
