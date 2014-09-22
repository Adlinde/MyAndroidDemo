<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
<html>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
  
  <div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="用车申请" style="padding:10px" id="applycardiv">
		
		
			 <form action="addApplyCar.action" method="post" id="applycarForm">
                 <table width="80%" border="0" class="table_thintd" id="applycarGrid">
                      <tr>
                        <td align="right">车辆编号：</td>
                        <td>
                        <input class="easyui-combobox" id="language" name="applycar.oaCar.number"
			data-options="url:'loadCarnumApplyCar.action',valueField:'number',textField:'number'">
                        </td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td align="right">用车人：</td>
                        <td>${sessionScope.currentUser.name}
                        </td>
                         <input type="hidden" name="applycar.oaUserByUsedcarUuid.uuid"  value="${sessionScope.currentUser.uuid}"/>
                        <td align="right">司机：</td>
                        <td><input name="applycar.driver" type="text" /></td>
                      </tr>
                      <tr>
                        <td align="right">随行人员：</td>
                        <td><input name="applycar.partypeople" type="text" /></td>
                        <td align="right">用车部门：</td>
                        <td>${sessionScope.currentUser.oaDept.deptName}
                        </td>
                        <input type="hidden" name="applycar.userdcardDepartment.uuid" value="${sessionScope.currentUser.oaDept.uuid}"/>
                      </tr>
                      <tr>
                        <td align="right">时间：</td>
                        <td colspan="3">
                             <input type="text" name="applycar.begintime"  class="easyui-datebox"  size="10"/>
		                                           to
		                     <input type="text" name="applycar.endtime"  class="easyui-datebox"  size="10"/>  
                        </td>
                      </tr>
                      <tr>
                        <td align="right">目的地：</td>
                        <td><input name="applycar.adress" type="text" /></td>
                        <td align="right">申请里程：</td>
                        <td><input name="applycar.mileage" type="text" /></td>
                      </tr>
                      
                       <tr>
                        <td align="right">用车事由：</td>
                        <td colspan="3">
                            <textarea name="applycar.reason" cols="60" rows="8"></textarea>
                        </td>
                      </tr>
                      
                         <!--  <tr>
                        <td align="right">下一步审批人：</td>
                        <td colspan="3">
                           <input class="easyui-combobox" id="language" name="language"
			data-options="url:'combobox_data1.json',valueField:'id',textField:'text'">

                        </td>
                      </tr>-->
                      
                       <tr>
                      
                        <td colspan="4" align="center">
                        	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',toggle:true" onclick="saveApplyCar()">提交申请</a>
                        </td>
                      </tr>
                    </table>
                    </form>
                    
                    
                    <script type="text/javascript">
                    	
                    	function saveApplyCar(){
                    	alert("@@@@@@@@");
                    	$("#applycarForm").ajaxSubmit({
                    		dataType:"json",
                    		sucsess:function(da){
                    			if(da.status==1){
                    				alert("申请成功");
                    				$('#applycarForm').trigger("reset");          					
                    			}
                    			if(da.status==2){	
                    			}
                    		}
                    	});
                    	
                    	}
                    </script>
                    

                
</div>
		
		<div title="车辆信息管理" style="padding:10px" id="carsdiv"> 
            
		      <table class="easyui-datagrid" title="车辆列表" id="carsGrid"
						data-options="rownumbers:true,url:'selallCar.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar">
					<thead>
						<tr>
							<th data-options="field:'carnum',width:250">车牌号</th>
							<th data-options="field:'oaDictionary',width:60">车型</th>
							<th data-options="field:'number',width:60,align:'center'">编号</th>
                            <th data-options="field:'comment',width:60,align:'center'">备注</th>
                            <th data-options="field:'state',width:60,align:'center'">状态</th>
							<th data-options="field:'puttime',width:100,align:'right',formatter:operate">操作</th>			
						</tr>
					</thead>
				</table>
             
             
		</div>
		
	
</div>
  
  
 

</body>
</html>
<script>

	function operate(value,row,index){
		return "<a href='javascript:;' onclick='toEditNotice("+row.number+")' >修改</a>&nbsp;&nbsp;<a href='javascript:;' onclick='delCars("+row.number+")'>删除</a>";
		}
		
	var toolbar = [{
			text:'添加车辆信息',
			iconCls:'icon-add',
			handler:function(){
				addCars();
		    }
		}];
		
		
	 function addCars(){
		   $('#w').panel('setTitle','添加车辆信息');
		   $('#w').window('refresh','carsAdd.jsp');
		   $('#w').window('center');	
		   $('#w').window('open');	
     }
     
     
      function delCars(id){
		confirm("是否删除?");
			$.ajax({
			dataType:"json",
			url:"delCar.action?car.number="+id,
			success:function(data){
			  if(data.status==1){
			  	alert("删除成功");
			  	$('#carsGrid').datagrid('reload');
			  }else{
			  	alert("删除失败");
			  	$('#carsGrid').datagrid('reload');
			  }
			}
			});
		}

</script>