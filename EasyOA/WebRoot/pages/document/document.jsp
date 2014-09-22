﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
		<script>
		function opt(value,row,index){
		return "<a href='javascript:;' onclick='toEditDoc("+row.uuid+")' >修改</a>&nbsp;&nbsp;<a href='javascript:;' onclick='delDoc("+row.uuid+")'>删除</a>";
		}

		
	function searchDoc(){
		$('#docGrid').datagrid('load', {
       "document.filename":$("#filename").val(),
       "document.oaUser.name":$("#username").val(),
       "beginTime":$("#begintime").val(),
       "endTime":$("#endTime").val()\
       
});
		}
		
		function delDoc(id){
		$.ajax({
		dataType:"json",
		url:"${pageContext.request.contextPath}/deleteDocument.action?document.uuid="+id,
		success:function(data){
		if(data.status==2){
		alert(data.msg);
		 var path="${pageContext.request.contextPath}/listDocument.action?state=1";
		  $("#docGrid").datagrid({
        url:encodeURI(encodeURI(path))
        });
		}else{
		 $('#w').window('close');
		alert(data.msg);
		}
		
		}
		});
		}
		</script>
</head>
<body>
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
	<div id="cc" data-options="fit:true" >
		<div data-options="region:'west'" style="width:130px;">
		     <ul id="treeDemo" class="ztree"></ul>
		</div>
		<div data-options="region:'center'" style="padding :10px; width: 93%" >
		    
		      <div style="padding:5px;background: #FFFEE6 ;width: 99%" >
		                                          文件名 ：<input type="text" id="filename" style="width:100px;vertical-align: middle"/>
		                                           拥有者 ：<input type="text" id="username"  style="width:100px;vertical-align: middle"/>
		                                           创建日期 ：<input type="text" id="begintime"  style="width:90px" class="easyui-datebox" />
		                                           to
		                     <input type="text" id="endtime" name="" style="width:90px" class="easyui-datebox"/>      
		     
		      <a href="javascript:;"  onclick="searchDoc()" class="easyui-linkbutton" style="vertical-align: middle">检索</a>
		     
		      </div>
		      
		
				<table class="easyui-datagrid" title="文档列表" id="docGrid" 
						data-options="rownumbers:true,url:'listDocument.action?state=1',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
						   
							<th data-options="field:'filename',width:100">文件名</th>
							<th data-options="field:'oaSysSetting',width:100">文件类型</th>
							
							<th data-options="field:'oaUser',width:100">所有者</th>
							<th data-options="field:'fileCreattime',width:160">创建时间</th>			
                             <th data-options="field:'aa',width:160,formatter:opt">操作</th>		
						</tr>
					</thead>
				</table>
				
		</div>
	</div>

</body>
</html>
<script>
	var toolbar = [{
			text:'添加文件夹',
			iconCls:'icon-add',
			handler:function(){
				addFold();
		    }
		},{
			text:'添加文件',
			iconCls:'icon-add',
			handler:function(){
			  addFile();
			}
		}];



 var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	async: {
		enable: true,
		url: "loadDeptsTreeDocument.action"
	},
	 callback:{
                onClick:onCheck
            }
	
};
function onCheck(e,treeId,treeNode){
   var path="${pageContext.request.contextPath}/"+treeNode.link;
        $("#docGrid").datagrid({
        url:encodeURI(encodeURI(path))
        });
            
            
            }

 $(function(){
	$('#cc').layout();
	$.fn.zTree.init($("#treeDemo"), setting);		
 });
 
 function addFold(){
      $('#w').panel('setTitle',' 创建新文件夹');
	  $('#w').window('refresh','foldAdd.jsp');
	  $('#w').window('center');	
	  $('#w').window('open');	
 }
 
 
  function addFile(){
      $('#w').panel('setTitle',' 创建新文件');
	  $('#w').window('refresh','fileAdd.jsp');
	  $('#w').window('center');	
	  $('#w').window('open');	
 }
		
		function toEditDoc(id){
		 $('#w').panel('setTitle',' 修改文件夹');
	  $('#w').window('refresh','foldEdit.jsp');
	  $('#w').window('center');	

	  $('#w').window('open');
		}

</script>