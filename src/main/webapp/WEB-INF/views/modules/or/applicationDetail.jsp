<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Application Detail</title>
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
		<li><a href="${ctx}/or/application/list/?house.id=${application.house.id}">Application list</a></li>
		<li class="active"><a href="${ctx}/or/application/detail?id=${application.id}">application detail</a></li>
	</ul>
	<form class="form-horizontal">
		<div class="control-group">
			<div class="controls">
				<a href="${ctx}/or/house/detail?id=${application.house.id }"><h3>${application.house.name}</h3></a>
			</div>
		</div>
		<div class="control-group">
		    <label class="control-label">Applicant:：</label>
			<div class="controls">
				<a href="${ctx }/sys/user/form?id=${application.createBy.id}">${application.createBy.name}</a>
			</div>
		</div>
		<div class="control-group">
		    <label class="control-label">Room：</label>
			<div class="controls">
				${application.room.roomNumber}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Duration：</label>
			<div class="controls">
				${application.startTime}~ ${ application.endTime}
				
		   </div>
		</div>
		
		<div class="control-group">
			<label class="control-label"> Stautus：</label>
			<div class="controls">
				${ application.processStatus}
				 <shiro:hasPermission name="or:application:audit">
			     	<a href="${ctx}/or/application/audit?id=${application.id}" class="btn btn-primary" >Approve</a>
			     </shiro:hasPermission>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Comment：</label>
			<div class="controls">
				${application.comment }
			</div>
		</div>

		
         <input id="btnCancel" class="btn" type="button" value="back" onclick="history.go(-1)"/>
	</form>
	
</body>
</html>
