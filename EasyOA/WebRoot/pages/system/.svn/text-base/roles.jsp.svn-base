<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:380px;padding-top:20px">
  </div>
  
				<table class="easyui-datagrid" title="角色列表" id="noticeGrid" 
						data-options="rownumbers:true,url:'../a/noticeData.txt',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
							<th data-options="field:'name',width:150">排序</th>
							<th data-options="field:'promulgate',width:160">名称</th>
							<th data-options="field:'statuss',width:160,">操作</th>
									
						</tr>
					</thead>
				</table>
				

</body>
</html>
<script>
	var toolbar = [{
			text:'添加新角色',
			iconCls:'icon-add',
			handler:function(){
				addRoles();
		    }
		}];


 $(function(){
		
 });
 
 function addRoles(){
      $('#w').panel('setTitle',' 添加新角色');
	  $('#w').window('refresh','roleAdd.jsp');
	  $('#w').window('center');	
	  $('#w').window('open');	
 }
</script>