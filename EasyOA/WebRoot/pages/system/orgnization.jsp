<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
	<div id="cc" data-options="fit:true" >
		<div id="depttree" data-options="region:'west'" style="width:220px;">
		     <ul id="treeDemo" class="ztree"></ul>
		</div>
        
        
		<div data-options="region:'center'" style="padding :10px" >
			<form id="deptinfo" method="post">
		       <table id="deptGrid" width="45%" border="0" class="table_thintd bg_yellow" >              
                      <tr>
                        <td align="center" colspan="2"> <h3>机构信息</h3></td>
                      </tr>
                      <tr>
                        <td align="right">部门名称：</td>
                        <td><input type="hidden" id="deptUuid" name="dept.uuid"/><input id="deptName" name="dept.deptName" type="text" /></td>
                      </tr>
                      <tr>
                        <td align="right">所属部门：</td>
                        <td>
                           <input id="deptFather" name="dept.oaDept.uuid" class="easyui-combotree" data-options="url:'loadDeptsuser.action',method:'get',required:true" style="width:200px;">
                        </td>
                      </tr>
                      <tr>
                        <td align="right">部门负责人：</td>
                        <td>
                           <input id="deptUser" name="dept.oaUser.uuid" class="easyui-combobox" data-options="url:'selOneAlluser.action',method:'get',valueField:'uuid',textField:'uuid'" style="width:200px;">
                        </td>
                      </tr>
      
                       <tr>
                        <td align="right">联系电话：</td>
                        <td>
                          <input id="deptPhone" name="dept.phone" type="text" />
                        </td>
                      </tr>
                      
                      <tr>
                        <td align="right">移动电话：</td>
                        <td>
                           <input id="deptMobilePhone" name="dept.mobilePhone" type="text" />
                        </td>
                      </tr>
                      
                       <tr>
                        <td align="right">传真：</td>
                        <td>
                           <input id="deptFax" name="dept.fax" type="text" />
                        </td>
                      </tr>
                      
                       <tr>
                        <td colspan="2" align="center">
                        	<a href="javascript:;" onclick="updateDept()" class="easyui-linkbutton">保存</a>
                        	<a href="javascript:;" onclick="addDept()" class="easyui-linkbutton" >新增</a>
                        	<a href="javascript:;" onclick="delDept()" class="easyui-linkbutton" >删除</a>
                        </td>
                      </tr>
                    </table>
		    </form>			
		</div>
	</div>

</body>
</html>
<script>

var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	async: {
		enable: true,
		url: "loadTreedept.action"
	},
	callback: {
		onClick:zTreeOnClick
	}
};
//树形菜单单击事件
 function zTreeOnClick(event, treeId, treeNode){
	 	var path="${pageContext.request.contextPath}/"+treeNode.link;
		$.ajax({
 		dataType:"json",
 		type:"post",
 		url:path,
 		success:function(data){
 			$("#deptUuid").val(data.uuid);
 			$("#deptName").val(data.deptName);
 			$("#deptFather").combotree('setValue',data.oaDept);
 			$("#deptUser").combobox('setValue',data.oaUser);
 			$("#deptPhone").val(data.phone);
 			$("#deptMobilePhone").val(data.mobilePhone);
 			$("#deptFax").val(data.fax);	
 		}
		});
	}
 $(function(){
	$('#cc').layout();
	$.fn.zTree.init($("#treeDemo"), setting);		
 });
 
 //更新部门信息
 function updateDept(){
 	 $("#deptinfo").ajaxSubmit({
 		  url:"${pageContext.request.contextPath}/updatedept.action",
          dataType:"json",
		  success:function(da){
 		  if(da.status==2){  
           alert("修改部门信息成功！");
         $('#cc').layout();
	$.fn.zTree.init($("#treeDemo"), setting);	
                         	
          }else{
            alert("修改部门信息失败！");
          }	
 		}
		});
 }
 //添加部门信息
 function addDept(){
		$("#deptinfo").ajaxSubmit({
 		  url:"${pageContext.request.contextPath}/adddept.action",
          dataType:"json",
		  success:function(da){
 		  if(da.status==2){
             alert("添加部门信息成功！"); 
             $('#cc').layout();
	$.fn.zTree.init($("#treeDemo"), setting);	
                      
          }else{
            alert("添加部门信息失败！");
          }	
 		}
		});
 }
 //删除部门信息
 function delDept(){
		$("#deptinfo").ajaxSubmit({
 		  url:"${pageContext.request.contextPath}/deldept.action",
          dataType:"json",
		  success:function(da){
 		  if(da.status==2){	  	 
             alert("删除部门信息成功！"); 
           $('#cc').layout();
	$.fn.zTree.init($("#treeDemo"), setting);	
                 	
          }else{
            alert("删除部门信息失败！");
          }	
 		}
		});
 }
</script>