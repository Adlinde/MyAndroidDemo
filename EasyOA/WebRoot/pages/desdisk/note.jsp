<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="../util.jsp" %>
<script type="text/javascript">
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				viewTask();
		    }
		},{
			text:'删除选中',
			iconCls:'icon-cut',
			handler:function(){
			   deleteData();
			}
		}];
		
		
		
		function viewTask(){
		   $('#w').panel('setTitle','添加便签');
		   $('#w').window('refresh','noteAdd.jsp');
		   $('#w').window('center');	
		   $('#w').window('open');	
		}
		
		function cks(){
		   return "<input type='checkbox' name='uuid'/>";
		}
		
		function deleteData(){
		   var rows = $('#noticeGrid').datagrid('getChecked');
		   if(rows.length != 0){
		        $(rows).each(function(){
		            alert(this.uuid);
		        });
		   }else{
		     alert("请选择要删除的数据");
		   }
		}
		
		function viewData(rowIndex, rowData){
		   $('#w').panel('setTitle','查看');
		   $('#w').window('refresh','noticeAdd.jsp');
		   $('#w').window('center');	
		   $('#w').window('open');	
		}
		$(document).ready($.ajax({
			   type: "POST",
			   url: "toListBqAction.action",
			   dataType: "json",
			   success: function(msg){
			     alert( "Data Saved: " + msg.rows[0].title );
			   }
			}));
	</script>
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>

   	<table class="easyui-datagrid" title="便签列表" id="noticeGrid"
			data-options="rownumbers:true,url:'${pageContext.request.contextPath}/toListBqAction.action',
			method:'get',toolbar:toolbar,pagination:true,checkOnSelect:false,onDblClickRow:viewData">
		<thead>
			<tr>
			    <th data-options="field:'aa',width:30,checkbox:true"></th>
				<th data-options="field:'title',width:150">标题</th>
				<th data-options="field:'content',width:300">内容</th>
				<th data-options="field:'startTime',width:160">发布时间</th>
				<th data-options="field:'operations',width:60">操作</th>			
			</tr>
		</thead>
	</table>
	<a href="toListBqAction.action">查看便签列表</a>
	
<table class="easyui-datagrid" title="待处理任务列表" id="noteGrid"
				data-options="rownumbers:true,url:'toListBqAction.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
				<thead>
					<tr>

						<th data-options="field:'title',width:100">任务标题</th>
						
						<th data-options="field:'startTime',width:200">发起时间</th>
			
					
						<th data-options="field:'operation',width:200">操作</th>


					</tr>
					
				</thead>
			</table>
	
	
	
	
   
</body>
</html>

