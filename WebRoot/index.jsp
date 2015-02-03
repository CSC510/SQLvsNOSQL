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
		<li><a href="${ctx}/oa/leave/">待办任务</a></li>
		<li><a href="${ctx}/oa/leave/list">所有任务</a></li>
		<li class="active"><a href="${ctx}/oa/leave/detail?id=${leave.id}">请假查看</a></li>
	</ul>
  </body>
</html>
