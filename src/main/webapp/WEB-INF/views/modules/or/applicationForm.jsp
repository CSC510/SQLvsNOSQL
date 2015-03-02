<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>application Manage</title>
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
		<li><a href="${ctx}/or/application/?house.id={application.house.id}">application list</a></li>
		<li class="active"><a href="<c:url value='${fns:getAdminPath()}/or/room/form?id=${application.id}&house.id=${application.house.id}&room.id=${application.room.id }'><c:param name='house.name' value='${application.house.name}'/></c:url>">application<shiro:hasPermission name="or:application:edit">${not empty article.id?' edit':' new'}</shiro:hasPermission><shiro:lacksPermission name="or:application:edit"> detail</shiro:lacksPermission></a></li>	</ul><br/>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="application" action="${ctx}/or/application/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">House:：</label>
			<div class="controls">
				<tags:treeselect id="house" name="house.id" value="${application.house.id}" labelName="house.name" labelValue="${application.house.name}"
					title="house" url="" module="house" selectScopeModule="true" notAllowSelectRoot="true" notAllowSelectParent="true" cssClass="required"/>&nbsp;
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">Room:：</label>
			<div class="controls">
				<tags:treeselect id="room" name="room.id" value="${application.room.id}" labelName="room.number" labelValue="${application.room.roomNumber}"
					title="room" url="" module="room" selectScopeModule="true" notAllowSelectRoot="true" notAllowSelectParent="true" cssClass="required"/>&nbsp;
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label" for="startTime">start：</label>
			<div class="controls">
				<input id="startTime" name="startTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="endTime">end：</label>
			<div class="controls">
				<input id="endTime" name="endTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${application.endTime}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="comment">comment:</label>
			<div class="controls">
				<form:textarea path="comment" rows="5" maxlength="255"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="or:application:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="Apply"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
