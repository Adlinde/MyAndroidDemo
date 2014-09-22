<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:380px;padding-top:20px">
  </div>
              <div style="padding:5px;background: #FFFEE6; font-size:12px">
		                                         用户名：<input type="text" name="" style="width:100px;vertical-align: middle"/>
		                                           时间段：<input type="text" name="" style="width:90px" class="easyui-datebox"/>
		                                           to
		                     <input type="text" name="" style="width:90px" class="easyui-datebox"/>      
		     
		      <a href="#" class="easyui-linkbutton" style="vertical-align: middle">检索</a>
		     
		      </div>
  
  
				<table class="easyui-datagrid" title="日志列表" id="logsGrid" 
						data-options="rownumbers:true,url:'../a/noticeData.txt',
						method:'get',pagination:true,checkOnSelect:false">
					<thead>
						<tr>
							<th data-options="field:'name',width:150">用户名</th>
							<th data-options="field:'promulgate',width:150">角色</th>
							<th data-options="field:'statuss',width:250">事件内容</th>
                                                        <th data-options="field:'statuss',width:200">操作时间</th>	
 <th data-options="field:'statuss',width:150">操作</th>		
						</tr>
					</thead>
				</table>
</body>
</html>
<script>
	

</script>