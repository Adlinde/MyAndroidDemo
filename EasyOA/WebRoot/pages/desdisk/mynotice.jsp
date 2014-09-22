<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp"%>
</head>

<body>
	<div id="w" class="easyui-window" title=" "
		data-options="modal:true,closed:true"
		style="width:500px;height:300px;padding-top:20px"></div>
	<%--<div title="通告列表" style="padding:10px">
   	<table class="easyui-datagrid" title="通告列表" id="noticeGrid"
			data-options="rownumbers:true,url:'toListCh_notice.action',
			method:'get',toolbar:toolbar,pagination:true,checkOnSelect:false">
		<thead>
			<tr>
			    <th data-options="field:'aa',width:30,checkbox:true"></th>
				<th data-options="field:'title',width:120">标题</th>
				<th data-options="field:'status',width:60">状态</th>	
				<th data-options="field:'pubdate',width:190">发布时间</th>	
				<th data-options="field:'content',width:220">内容</th>
				<th data-options="field:'oaUserByUserid',width:120">发布人</th>	
                <th data-options="field:'puttime',width:160,formatter:operate">操作</th>			
			</tr>
		</thead>
	</table>
	
	</div>
	--%>
	<div title="通告列表" style="padding:10px">

		<table class="easyui-datagrid" title="通告列表" id="noteGrid"
			data-options="rownumbers:true,url:'${pageContext.request.contextPath}/toListCh_notice.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
			<thead>
				<tr>
					<th data-options="field:'aa',width:30,checkbox:true"></th>
					<th data-options="field:'title',width:120">标题</th>
					<th data-options="field:'status',width:60">状态</th>
					<th data-options="field:'pubdate',width:190">发布时间</th>
					<th data-options="field:'content',width:220">内容</th>
					<th data-options="field:'oaUserByUserid',width:120">发布人</th>
					<th data-options="field:'puttime',width:160">操作</th>
				</tr>

			</thead>
		</table>



	</div>



	<script type="text/javascript">
		var toolbar = [ {
			text : '删除选中',
			iconCls : 'icon-cut',
			handler : function() {
				deleteData();
			}
		} ];

		function cks() {
			return "<input type='checkbox' name='uuid'/>";
		}

		function deleteData() {
			var rows = $('#noticeGrid').datagrid('getChecked');
			if (rows.length != 0) {
				$(rows).each(function() {
					alert(this.uuid);
				});
			} else {
				alert("请选择要删除的数据");
			}
		}

		function viewData(rowIndex, rowData) {
			$('#w').panel('setTitle', '查看');
			$('#w').window('refresh', 'mynoticeAdd.jsp');
			$('#w').window('center');
			$('#w').window('open');
		}
	</script>

</body>
</html>

