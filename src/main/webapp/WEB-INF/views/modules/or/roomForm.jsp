<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>roomManage</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${ctx}/or/room/?house.id=${room.house.id}">room list</a></li>
		<li class="active"><a href="<c:url value='${fns:getAdminPath()}/or/room/form?id=${room.id}&house.id=${room.house.id}'><c:param name='house.name' value='${room.house.name}'/></c:url>">room<shiro:hasPermission name="or:room:edit">${not empty article.id?' edit':' new'}</shiro:hasPermission><shiro:lacksPermission name="or:application:edit"> detail</shiro:lacksPermission></a></li>	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="room" action="${ctx}/or/room/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
       
		<div class="control-group">
			<label class="control-label" for="roomNumber">Room Number:</label>
			<div class="controls">
				<form:input path="roomNumber" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
				
		<div class="control-group">
			<label class="control-label">In house:</label>
			<div class="controls">
                <tags:treeselect id="house" name="house.id" value="${room.house.id}" labelName="house.name" labelValue="${room.house.name}"
					title="house" url="" module="house" selectScopeModule="true" notAllowSelectRoot="true" notAllowSelectParent="true" cssClass="required"/>&nbsp;
				 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="placeNumber">Place Number:</label>
			<div class="controls">
				<form:input path="placeNumber" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
				<div class="control-group">
			<label class="control-label" for="monthRate">Month Rate:</label>
			<div class="controls">
				<form:input path="monthRate" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="remarks">remark:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="or:room:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="save"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
