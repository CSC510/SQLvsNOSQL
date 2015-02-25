<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
  <head>   
    <title>My JSP 'index.jsp' starting page</title>
	<meta name="decorator" content="default"/>
  </head>
  
  <body>
		<form action="user/reg" >
			用户名：<input type=text name=userName /><br/>
			<input type=hidden name=method value=reg2   />
			<input type=submit value=注册  />
		</form>
  </body>
</html>
