<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>application manage</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/or/application/?house.id=${application.house.id}">application list</a></li>
		<shiro:hasPermission name="or:application:edit"><li><a href="${ctx}/or/application/form?house.id=${application.house.id}">new application</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="application" action="${ctx}/or/application/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>Id ：</label><form:input path="id" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="Search"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>Application Id</th>
			<th>Applicant</th>
			<th>Create Date</th>
			<th>Comment</th>
			<th>Status</th>
			<shiro:hasPermission name="or:application:edit"><th>operation</th></shiro:hasPermission>
		</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="application">
			<tr>
				<td><a href="${ctx}/or/application/detail?id=${application.id}">${application.id}</a></td>
				<td>${application.createBy.name}</td>
				<td>${application.createDate}</td>
				<td>${application.comment}</td>
				<td>${application.processStatus}</td>
				
			    <td>
			    
				    <shiro:hasPermission name="or:application:edit">
    				<a href="${ctx}/or/application/form?id=${application.id}">edit</a>
					<a href="${ctx}/or/application/delete?id=${application.id}" onclick="return confirmx('Are your sure delete this house?', this.href)">delete</a>
				</td></shiro:hasPermission>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
