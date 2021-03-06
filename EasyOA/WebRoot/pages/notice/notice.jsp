﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="../util.jsp" %>
</head>
<body>
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:380px;padding-top:20px">
  </div>

   	<table class="easyui-datagrid" title="通告列表" id="noticeGrid"
			data-options="rownumbers:true,url:'selallnoticeNotice.action',
			method:'post',toolbar:toolbar,pagination:true,checkOnSelect:false">
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
	
	

	
	
	
	<script type="text/javascript">
	
		function operate(value,row,index){
		return "<a href='javascript:;' onclick='toEditNotice("+row.uuid+")' >修改</a>&nbsp;&nbsp;<a href='javascript:;' onclick='delNotice("+row.uuid+")'>删除</a>&nbsp;&nbsp;<a href=''>查看</a>";
		}
		
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
		
		function delNotice(id){
		alert(id);
		confirm("是否删除?");
			$.ajax({
			dataType:"json",
			url:"delNotice.action?notice.uuid="+id,
			success:function(data){
			  if(data.status==1){
				alert(data.msg);
		 		//var path="selallnoticeNotice.action";
		  		//$("#noticeGrid").datagrid({
        		//	url:encodeURI(encodeURI(path))
        		//});
        		$('#noticeGrid').datagrid('reload');
			  }else{
		 		$('#w').window('close');
				alert(data.msg);
			  }
			}
			});
		}
		
		
		function viewTask(){
		   $('#w').panel('setTitle','添加通告');
		   $('#w').window('refresh','noticeAdd.jsp');
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
		        	confirm("是否删除?");
		            delNotice(this.uuid);
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
		
	</script>
   
</body>
</html>

