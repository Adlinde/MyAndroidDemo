<%@ page language="java"  pageEncoding="UTF-8"%>
<script type="text/javascript">

function saveData(){
  $("#editFold").ajaxSubmit({
  dataType:"json",
  success:function(data){

  if(data.status==2){
    $('#w').window('close');
    var path="${pageContext.request.contextPath}/"+data.msg;
   $("#docGrid").datagrid({
        url:encodeURI(encodeURI(path))
        });
            
    }
  else{
  alert(data.msg);
  }
  }
  });
}
</script>
<form action="editFoldDocument.action" method="post" id="editFold">
<table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="30%" align="right">文件夹名称：</td>
    <td >
    <input type="text" id="name" name="document.filename" class="easyui-validatebox" data-options="required:true" style="width:220px"/>
   </td>
   
  </tr>
  <tr>
    <td align="right">路径：</td>
    <td><input class="easyui-combotree" name="document.path" data-options="url:'loadDeptsDocument.action',method:'get',required:true" style="width:150px;"></td>
   
  </tr>
 
  <tr>
    <td align="right">备注：</td>
    <td><textarea name="document.remark" class="easyui-tooltip" title="暂不支持图片" cols="45" rows="5"></textarea></td>
  
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="javascript:;"  class="easyui-linkbutton" onclick="editData()">修改</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
  
</table>
  </form>
