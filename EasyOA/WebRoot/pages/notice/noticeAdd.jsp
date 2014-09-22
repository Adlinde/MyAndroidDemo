<%@ page language="java" pageEncoding="UTF-8"%>
<form method="post" action="addNotice.action" id="noticeForm">
 <table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="20%" align="right">标题：</td>
    <td >
    <input type="text" name="notice.title" class="easyui-validatebox" data-options="required:true" style="width:220px"/>
    <input type="radio" name="notice.status"  value="1" />
    紧急
    <input type="radio" name="notice.status" checked="checked" value="0" />
    一般</td>
   
  </tr>
  <tr>
    <td align="right">显示时间段：</td>
    <td><input name="notice.begindate" type="text" class="easyui-datebox " size="10" title="开始时间不能晚于结束时间"/> 
      to
      <input name="notice.enddate" type="text" class="easyui-datebox" size="10" /></td>
   
  </tr>
 
  <tr>
    <td align="right">内容：</td>
    <td><textarea name="notice.content" class="easyui-tooltip" title="暂不支持图片" cols="45" rows="5"></textarea></td>
  
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="javascript:;"  class="easyui-linkbutton" onclick="saveData()">发布</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
</table>
</form>
<script>
function saveData(){
  	$("#noticeForm").ajaxSubmit({
    dataType:"json",
    success:function(da){
    	if(da.st==1){
    		alert("发布成功");
    		$('#w').window('close');
    		$('#noticeGrid').datagrid('reload');
    	}else{
    		alert("发布失败");
    		$('#w').window('close');
    	}
  }
  });
}



</script>