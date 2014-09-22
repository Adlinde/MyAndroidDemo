<%@ page language="java" pageEncoding="UTF-8"%>

<form method="post" action="addMeeting.action" id="meetingForm">
 <table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="20%" align="right">会议室名称：</td>
    <td >
    <input type="text" name="meeting.meetingName" class="easyui-validatebox" data-options="required:true" style="width:220px"/>
  </td>
   
  </tr>
  <tr>
    <td align="right">描述：</td>
    <td><textarea name="meeting.meetingDesc" class="easyui-tooltip" title="暂不支持图片" cols="45" rows="5"></textarea></td>
  
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="javascript:;"  class="easyui-linkbutton" onclick="saveData()">保存</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
</table>
</form>
<script>
  function saveData(){
  
  	$('#meetingForm').ajaxSubmit({
  		dataType:"json",
  		success:function(da){
  			if(da.status==1){
  				 $('#w').window('close');
  				 alert("添加会议室成功");
   				 $("#meetingGrid").datagrid("reload");
  			}else{
  				 alert("添加会议室失败");
  				 $("#meetingGrid").datagrid("reload");
  			}
  		}
  	});  
  }

</script>