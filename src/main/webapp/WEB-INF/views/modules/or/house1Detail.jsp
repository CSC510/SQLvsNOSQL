<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>House Detail</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('Processing, wait a moment...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("input error");
					if (element.is(":checkbox")||element.is(":radio")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function auditPass(isPass) {
			top.$.jBox.confirm("Are your sure?","System notification",function(v,h,f){
			    if (v == 'ok') {
					$("#pass").val(isPass);
					$("#inputForm").submit();
			    }
			});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/or/house/list/">house list</a></li>
		<li class="active"><a href="${ctx}/or/house/detail?id=${house.id}">house detail</a></li>
	</ul>
	<form class="form-horizontal">
		<div class="control-group">
			<div class="controls">
				<h3>${house.name}</h3>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				${house.houseTypeDictLabel}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Address：</label>
			<div class="controls">
				${house.address}
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">Contact：</label>
			<div class="controls">
				${house.telephone}
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">Rent Stautus：</label>
			<div class="controls">
				${house.rentStatus}
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">Rooms：</label>
			<div class="controls">
			<shiro:hasAnyPermissions name="or:room:view"><a class="btn btn-primary" href="${ctx}/or/room/?house.id=${house.id}">view rooms</a></shiro:hasAnyPermissions>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Applications：</label>
			<div class="controls">
			
			<shiro:hasAnyPermissions name="or:application:view"><a class="btn btn-primary" href="${ctx}/or/application/?house.id=${house.id}">view applications</a></shiro:hasAnyPermissions>
			</div>
		</div>
	</form>
	
</body>
</html>
