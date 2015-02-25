<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${functionName}Manage</title>
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
		<li><a href="${r"${ctx}"}/${urlPrefix}/">${functionName}列表</a></li>
		<li class="active"><a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">${functionName}<shiro:hasPermission name="${permissionPrefix}:edit">${r"${not empty "+className+".id?'修改':'添加'}"}</shiro:hasPermission><shiro:lacksPermission name="${permissionPrefix}:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="${className}" action="${r"${ctx}"}/${urlPrefix}/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${r"${message}"}"/>
		<div class="control-group">
			<label class="control-label" for="name">name:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="remarks">remark:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="${permissionPrefix}:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="save"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
