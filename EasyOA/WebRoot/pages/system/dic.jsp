<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:280px;padding-top:20px">
  </div>
  
				<table class="easyui-datagrid" title="字典列表" id="noticeGrid" 
						data-options="rownumbers:true,url:'../a/noticeData.txt',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
							<th data-options="field:'name',width:100">排序</th>
							<th data-options="field:'promulgate',width:150">名称</th>
							<th data-options="field:'statuss',width:150">操作</th>
										
						</tr>
					</thead>
				</table>
				

</body>
</html>
<script>
	var toolbar = [{
			text:'添加数据',
			iconCls:'icon-add',
			handler:function(){
				addDic();
		    }
		}];


 $(function(){
		
 });
 
 function addDic(){
      $('#w').panel('setTitle',' 添加数据');
	  $('#w').window('refresh','dicAdd.jsp');
	  $('#w').window('center');	
	  $('#w').window('open');	
 }
</script>