<%@ page language="java" pageEncoding="UTF-8"%>

<form method="post" action="addCar.action" id="carsForm">
 <table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="20%" align="right">车辆号：</td>
    <td >
    <input type="text" name="car.carnum" />
  </td>
  </tr>
 <tr>
    <td width="20%" align="right">车型：</td>
    <td >
    <input class="easyui-combobox" id="language" name="car.oaDictionary.dictionaryUuid"
			data-options="url:'loadTypeCar.action',valueField:'dictionaryUuid',textField:'dictionnaryValue'">
  </td>
  </tr>
<!-- 编号数据库自动成成   <tr>
    <td width="20%" align="right">编号：</td>
    <td >
    <input type="text" name="textfield" />
  </td>
  </tr> -->
  
  
  <tr>
    <td width="20%" align="right">备注：</td>
    <td >
    <textarea name="car.comment" cols="35" rows="5"></textarea>
  </td>
  </tr>
  
  
  <tr>
    <td colspan="2" align="center">
        <a id="savecar"   href="javascript:;"  class="easyui-linkbutton" onclick="saveData()">保存</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
</table>
</form>
<script>
	
  function saveData(){
  	
  	$("#carsForm").ajaxSubmit({
  		dataType:"json",
  		success:function(da){
  			if(da.st==1){
  				$('#w').window('close');
  				alert("添加车辆信息成功！");
  				 //var path="${pageContext.request.contextPath}/selallCar.action";
  				 //var path="cars.jsp";
   				//$("#carsGrid").datagrid({
        		//url:path
        		
        		//});
        		$('#carsGrid').datagrid('reload');
  			}
  			else{
  				alert("添加车辆信息失败！");
  				$('#w').window('close');
  			}
  		}	
  	}); 
  }

</script>