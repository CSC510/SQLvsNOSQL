<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page isELIgnored="false"%> 
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
  <head>   
    <title>Welcome</title>
	<meta name="decorator" content="default"/>
  </head>
  
  <body> 
  Hello world!! <br>
    <ul class="nav nav-tabs">
		<li><a href="${ctx}/oa/leave/">��������</a></li>
		<li><a href="${ctx}/oa/leave/list">��������</a></li>
		<li class="active"><a href="${ctx}/oa/leave/detail?id=${leave.id}">��ٲ鿴</a></li>
	</ul>
  </body>
</html>
