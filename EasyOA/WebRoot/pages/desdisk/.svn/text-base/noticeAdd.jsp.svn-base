<%@ page language="java" pageEncoding="UTF-8"%>

 <table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="20%" align="right">标题：</td>
    <td >
    <input type="text" name="textfield" class="easyui-validatebox" data-options="required:true" style="width:220px"/>
    <input type="radio" name="radio"  value="radio" />
    紧急
    <input type="radio" name="radio" checked value="radio" />
    一般</td>
   
  </tr>
  <tr>
    <td align="right">显示时间段：</td>
    <td><input name="textfield2" type="text" class="easyui-datebox " size="10" title="开始时间不能晚于结束时间"/> 
      to
      <input name="textfield5" type="text" class="easyui-datebox" size="10" /></td>
   
  </tr>
 
  <tr>
    <td align="right">内容：</td>
    <td><textarea name="textarea" class="easyui-tooltip" title="暂不支持图片" cols="45" rows="5"></textarea></td>
  
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="javascript:;"  class="easyui-linkbutton" onclick="saveData()">发布</a>
        <a href="javascript:;" class="easyui-linkbutton">保存</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
</table>
<script>
  function saveData(){
    $('#w').window('close');
    $("#noticeGrid").datagrid("reload");
    
  }

</script>