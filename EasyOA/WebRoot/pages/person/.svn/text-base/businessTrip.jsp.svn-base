<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
		<script type="text/javascript">
		function add(){
		$("#addForm").ajaxSubmit({
		dataType:'json',
		success:function(data){
		 $('#w').window('close');
		alert(data.msg);
		}
		});
		}
		</script>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
  
  <div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="出差申请" style="padding:10px">
			 <form action="addEvection.action" method="post" id="addForm">
                 <table width="80%" border="0" class="table_thintd" >
                      <tr>
                        <td align="right">姓名：</td>
                        <td>${sessionScope.currentUser.name}</td>
                         <input type="hidden" name="evection.oaUserByUserid.uuid" value="${sessionScope.currentUser.uuid}"/>
                        <td align="right">部门：</td>
                        <td>${sessionScope.currentUser.oaDept.deptName}</td>
                         
                           <input type="hidden" name="evection.oaUserByNextUserid.uuid" value="${sessionScope.currentUser.oaDept.oaUser.uuid}"/>
                      </tr>
                      
                     <tr>
                        <td align="right">出差日期：</td>
                        <td colspan="3">
                             <input type="text" name="evection.begintime"  class="easyui-datebox"  size="10"/>
                                                   to
                             <input type="text" name="evection.endtime"  class="easyui-datebox"  size="10"/>  
                        </td>
                      </tr>
                      
                      <tr>
                        <td align="right">出差地点</td>
                        <td><input name="evection.adress" type="text" /></td>
                        <td align="right">交通工具：</td>
                        <td>
                            <input class="easyui-combobox" id="language" name="evection.oaDictionary.dictionaryUuid"
			data-options="url:'loadVehicleEvection.action',valueField:'dictionaryUuid',textField:'dictionnaryValue'">
                        
                        </td>
                      </tr>
                      
                      
                       <tr>
                        <td align="right">出差事由：</td>
                        <td colspan="3">
                            <textarea name="evection.evectionResion" cols="60" rows="8"></textarea>
                        </td>
                      </tr>
                      
                       <tr>
                        <td align="right">工作任务：</td>
                        <td colspan="3">
                            <textarea name="evection.evectionWork" cols="60" rows="8"></textarea>
                        </td>
                      </tr>
                      
                      
                      
                       <tr>
                        <td align="right">借款金额：</td>
                        <td colspan="3">
                            <input name="evection.money"  type="text" />
                        </td>
                      </tr>
                      
                      
                   
                      
                       <tr>
                      
                        <td colspan="4" align="center">
                        	<a href="javascript:;"  onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-save',toggle:true">提交申请</a>
                        </td>
                      </tr>
                    </table>     
                    </form>      
  </div>	
</div>
  
  
 

</body>
</html>
