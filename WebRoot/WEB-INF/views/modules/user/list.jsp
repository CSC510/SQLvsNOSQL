<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page isELIgnored="false"%> 
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <c:forEach items="${userList}" var="user">
       UserName:  ${user.userName } <br>
	   Courses : <br>
     <c:forEach items="${user.courses}" var="course">
       courseName:  ${course.courseName } <br>

	 </c:forEach>
	</c:forEach>
  </body>
</html>
