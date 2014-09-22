<%@ page language="java"  pageEncoding="UTF-8"%>
<script type="text/javascript">

function saveData(){
  $("#addFile").ajaxSubmit({
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
<form method="post" action="addFileDocument.action" id="addFile" enctype="multipart/form-data">
<table width="95%" border="0"  class="table_thintd" align="center">
  
  <tr>
    <td width="20%" align="right">创建人</td>
    <td >
     ${sessionScope.currentUser.name}
   </td>
   </tr>
  <tr>
  
  <td width="20%" align="right">文件名：</td>
    <td >
    <input type="text" name="document.filename" class="easyui-validatebox" data-options="required:true" style="width:220px"/>
   </td>
   
  </tr>
  <tr>
    <td align="right">路径：</td>
    <td><input class="easyui-combotree" name="document.path" data-options="url:'loadDeptsDocument.action',method:'get',required:true" style="width:150px;"></td>
   
  </tr>
 
  <tr>
    <td align="right">文件上传：</td>
    <td>
       <input type="file" name="doc"/>
        <a href="#" class="easyui-linkbutton" style="vertical-align:top;">上传</a>
    </td>
  
  </tr>
 
  <tr>
    <td align="right">备注：</td>
    <td><textarea name="document.remark" class="easyui-tooltip" title="暂不支持图片" cols="45" rows="5"></textarea></td>
  
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="javascript:;"  class="easyui-linkbutton" onclick="saveData()">保存</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="$('#w').window('close');">取消</a>
    </td>
    </tr>
</table>
</form>