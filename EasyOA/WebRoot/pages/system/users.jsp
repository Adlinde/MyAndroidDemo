<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="../util.jsp" %>

</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:380px;padding-top:20px">
  </div>
  
				<table class="easyui-datagrid" title="用户列表" id="noticeGrid" 
						data-options="rownumbers:true,url:'selalluser.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
							<th data-options="field:'uuid',width:200">用户名</th>
							<th data-options="field:'name',width:200">真实姓名</th>
							<th data-options="field:'oaRole',width:180">角色</th>
							<th data-options="field:'oaDept',width:180">部门</th>
							<th data-options="field:'asdzxc',width:60,formatter:opt">操作</th>	
						</tr>
					</thead>
				</table>
				

</body>
</html>
<script>
	var toolbar = [{
			text:'添加新用户',
			iconCls:'icon-add',
			handler:function(){
				addUser();
		    }
		}];


 $(function(){
		
 });
 
 function addUser(){
      $('#w').panel('setTitle',' 添加新用户');
	  $('#w').window('refresh','userAdd.jsp');
	  $('#w').window('center');	
	  $('#w').window('open');	
 }
  function opt(value,row,index){ 
    return  "<a href='javascript:;' onclick='selByIduser.action?user.uuid='"+row.uuid+">编辑</a>";
 }
</script>