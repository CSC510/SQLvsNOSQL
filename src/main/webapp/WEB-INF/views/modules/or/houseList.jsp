<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>house manage</title>
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
		<li class="active"><a href="${ctx}/or/house/">house list</a></li>
		<shiro:hasPermission name="or:house:edit"><li><a href="${ctx}/or/house/form">add house</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="house" action="${ctx}/or/house/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><th>备注</th><shiro:hasPermission name="or:house:edit"><th>operation</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="house">
			<tr>
				<td><a href="${ctx}/or/house/form?id=${house.id}">${house.name}</a></td>
				<td>${house.remarks}</td>
				<shiro:hasPermission name="or:house:edit"><td>
    				<a href="${ctx}/or/house/form?id=${house.id}">修改</a>
					<a href="${ctx}/or/house/delete?id=${house.id}" onclick="return confirmx('确认要删除该house吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
