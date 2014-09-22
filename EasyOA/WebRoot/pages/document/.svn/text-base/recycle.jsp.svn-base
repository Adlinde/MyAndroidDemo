<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
	<script>

	</script>
</head>
<body >

				<table class="easyui-datagrid" title="文档回收列表" id="docGrid" 
						data-options="rownumbers:true,url:'listDocument.action?state=2',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
						 <th data-options="field:'aa',width:30,checkbox:true"></th>
						 <th data-options="field:'filename',width:100">文件名</th>
							<th data-options="field:'oaSysSetting',width:100">文件类型</th>
							
							<th data-options="field:'oaUser',width:100">所有者</th>
							<th data-options="field:'fileCreattime',width:160">创建时间</th>			
                        		
                         
						</tr>
					</thead>
				</table>
		
</body>
</html>
<script>
	var toolbar = [{
			text:'还原选中',
			iconCls:'icon-undo',
			handler:function(){
				undoFile();
		    }
		},{
			text:'彻底删除',
			iconCls:'icon-cancel',
			handler:function(){
			  deleteFile();
			}
		}];


 
 function undoFile(){
    var rows = $('#docGrid').datagrid('getChecked');
  
		   if(rows.length != 0){
		   var result=confirm("您确定要还原该文件吗？");
		   if(result){
		    $(rows).each(function(){

		       $.ajax({
		dataType:"json",
		url:"${pageContext.request.contextPath}/recycleDocument.action?document.uuid="+this.uuid,
		success:function(data){
		if(data.status==2){
		alert(data.msg);
		 var path="${pageContext.request.contextPath}/listDocument.action?state=2";
		  $("#docGrid").datagrid({
        url:encodeURI(encodeURI(path))
        });
		}else{
		 $('#w').window('close');
		alert(data.msg);
		}
		
		}
		});
					         
		        });	   
		   }else{
		   return false;
		   }
		   }else{
		     alert("请选择要还原的文件");
		   }
 }
 
 function deleteFile(){
   var rows = $('#docGrid').datagrid('getChecked');
  
		   if(rows.length != 0){
		   var result=confirm("彻底删除后文件将无法恢复，您确定要删除吗？");
		   if(result){
		    $(rows).each(function(){

		       $.ajax({
		dataType:"json",
		url:"${pageContext.request.contextPath}/deleteDocument.action?document.uuid="+this.uuid,
		success:function(data){
		if(data.status==2){
		alert(data.msg);
		 var path="${pageContext.request.contextPath}/listDocument.action?state=2";
		  $("#docGrid").datagrid({
        url:encodeURI(encodeURI(path))
        });
		}else{
		 $('#w').window('close');
		alert(data.msg);
		}
		
		}
		});
					         
		        });	   
		   }else{
		   return false;
		   }
		   }else{
		     alert("请选择要删除的文件");
		   }
 }
 

</script>
 

</script>