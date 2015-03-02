<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>room管理</title>
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
		<li class="active"><a href="${ctx}/or/room/?house.id=${room.house.id}">room list</a></li>
		<shiro:hasPermission name="or:room:edit"><li><a href="<c:url value='${fns:getAdminPath()}/or/room/form?id=${room.id}&house.id=${room.house.id}'><c:param name='house.name' value='${room.house.name}'/></c:url>">room add</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="room" action="${ctx}/or/room/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>Room Number：</label><form:input path="roomNumber" htmlEscape="false" maxlength="50" class="input-small"/>
	    <label>Place Number：</label><form:input path="placeNumber" htmlEscape="false" maxlength="50" class="input-small"/>
		
		<label>Status:</label><form:select path="rentStatus"  ><form:option value="" label="--select--"/><form:options items="${fns:getDictList('or_room_rent_status')}" itemLabel="label" itemValue="value" htmlEscape="false" /></form:select>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="Search"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>place number</th><th>room number</th>
		<th>In house</th>
		<th>Status</th>
		<shiro:hasPermission name="or:room:edit"><th>operations</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="room">
			<tr>
				<td><a href="${ctx}/or/room/form?id=${room.id}">${room.placeNumber}</a></td>
				<td>${room.roomNumber }</td>
				<td><a href="${ctx}/or/house/detail?id=${room.house.id}">${room.house.name }</a></td>
				<td>
				${room.rentStatus }
				<c:if test="${room.rentStatus == 'reserved' }">
					<div class="btn btn-disabled">apply</div>
				</c:if>
				<c:if test="${room.rentStatus != 'reserved' }">
				${room.applications }/3
				<shiro:hasPermission name="or:application:edit">
					<a class="btn btn-primary" href="${ctx}/or/application/form?room.id=${room.id}&house.id=${room.house.id}" > apply</a>
				</shiro:hasPermission>
				</c:if>
				</td>
				<shiro:hasPermission name="or:room:edit"><td>
    				<a href="${ctx}/or/room/form?id=${room.id}">edit</a>
					<a href="${ctx}/or/room/delete?id=${room.id}" onclick="return confirmx('Are your sure to delete this room?', this.href)">delete</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
