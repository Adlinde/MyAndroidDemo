<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/icon.css" />
<link href="${pageContext.request.contextPath}/css/kriss.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div id="w" class="easyui-window" title=" "
		data-options="modal:true,closed:true"
		style="width:500px;height:300px;padding-top:20px"></div>


	<div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="待处理任务" style="padding:10px">
			<div style="padding:5px;background: #FFFEE6">

				发起时间段 ：<input type="text" name="" style="width:90px"
					class="easyui-datebox" /> to <input type="text" name=""
					style="width:90px" class="easyui-datebox" /> 任务类型 ： <select
					class="easyui-combobox" name="">
					<option value="WV">请假申请</option>
					<option value="WI">出差申请</option>
					<option value="WY">用车申请</option>
				</select> <a href="#" class="easyui-linkbutton"
					style="vertical-align: middle">检索</a>

			</div>
			<table class="easyui-datagrid" title="待处理任务列表" id="noteGrid"
				data-options="rownumbers:true,url:'toWaitListApplyResult.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
				<thead>
					<tr>
						<th data-options="field:'title',width:100">任务标题</th>
						<th data-options="field:'startTime',width:200">发起时间</th>
						<th data-options="field:'operation',width:200">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="已处理任务" style="padding:10px">
			<div style="padding:5px;background: #FFFEE6">
				发起时间段 ：<input type="text" name="" style="width:90px"
					class="easyui-datebox" /> to <input type="text" name=""
					style="width:90px" class="easyui-datebox" /> 任务类型 ： <select
					class="easyui-combobox" name="">
					<option value="WV">请假申请</option>
					<option value="WI">出差申请</option>
					<option value="WY">用车申请</option>
				</select> <a href="#" class="easyui-linkbutton"
					style="vertical-align: middle">检索</a>

			</div>

			<table class="easyui-datagrid" title="已处理任务列表"
				data-options="rownumbers:true,url:'../a/noticeData.txt',
						method:'get',pagination:true,checkOnSelect:false">
				<thead>
					<tr>
						<th data-options="field:'title',width:100">任务标题</th>
						<th data-options="field:'startUser',width:100">发起人</th>
						<th data-options="field:'startTime',width:200">发起时间</th>
						<th data-options="field:'startTime',width:200"></th>
					
						<th data-options="field:'operation',width:200">操作</th>

					</tr>
				</thead>
			</table>

		</div>


	</div>




</body>
</html>
<script>
	var toolbar = [ {
		text : '审核',
		iconCls : 'icon-add',
		handler : function() {
			audit();
		}
	} ];

	function audit() {
		$('#w').panel('setTitle', '审核');
		$('#w').window('refresh', 'audit.jsp');
		$('#w').window('center');
		$('#w').window('open');
	}
</script>