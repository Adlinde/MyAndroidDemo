<%@ page language="java"  pageEncoding="UTF-8"%>


<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/themes/default/jquery.Jcrop.min.css"/>
<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/jquery.Jcrop.min.js"></script>

<div id="userformdiv">
<form method="post" action="saveuser.action" id="userForm">
<table width="95%" border="0"  class="table_thintd" align="center">
  <tr>
    <td width="18%" align="right">登录名：</td>
    <td width="33%"><input type="text" name="user.uuid" id="textfield" /><input type="hidden" id="realuserpic" name="user.userPic"/></td>
    <td rowspan="6" align="center" valign="middle"><img id="userIcon"  src="" width="100" height="140" alt="" /></td>
  </tr>
  <tr>
    <td align="right">密码：</td>
    <td><input type="password" name="user.password" id="textfield2" class="easyui-tooltip" title=""/></td>
  </tr>
  <tr>
    <td align="right">真实姓名：</td>
    <td><input type="text" name="user.name" id="textfield3" /></td>
  </tr>
  <tr>
    <td align="right">所在部门：</td>
    <td>
    <input  class="easyui-combotree" name="user.oaDept.uuid" data-options="url:'loadDeptsuser.action',method:'get',required:true" style="width:150px;">
    </td>
  </tr>
  <tr>
    <td align="right">性别：</td>
    <td><input name="user.sex" type="radio" id="radio" value="1" checked="checked" /> 
      男
      <input type="radio" name="user.sex" id="radio2" value="2" />
      女</td>
  </tr>
  <tr>
    <td align="right">角色：</td>
    <td>
          <input  name="user.oaRole.uuid" class="easyui-combobox" id="language" 
			data-options="url:'${pageContext.request.contextPath}/loadRolesuser.action',valueField:'uuid',textField:'roleName'">
    </td>
  </tr>
  <tr>
    <td align="right">状态：</td>
    <td><input name="user.state" type="radio" id="radio3" value="1" checked="checked" />
正常
  <input type="radio" name="user.state" id="radio4" value="2" />
冻结</td>
    <td align="center"><a href="javascript:;" onclick="changeDiv();">选择图片</a></td>
  </tr>
  <tr>
    <td colspan="3" align="center">
        <a href="javascript:;" onclick="saveUser()" class="easyui-linkbutton" style="vertical-align: middle"> 保 存 </a>
    </td>
  </tr>
</table>
</form>
</div>
<div id="picDiv" style="display:none">
<img src="${pageContext.request.contextPath}/images/headpic.jpg" id="target" alt="未显示" height="270px" width="300px" style="margin-left: 20%" />  
   <form id="picForm" action="${pageContext.request.contextPath}/uploaduser.action" method="post" enctype="multipart/form-data">
        <input type="file" name="pic"/>
        <input type="button" value="上传" onclick="upload()"/>
   </form>
  <input type="button" value="确定" onclick="saveCoords()"/>
    <form id="coordForm" action="${pageContext.request.contextPath}/saveCoorduser.action" method="post" >
       <input type="hidden" name="coord.x"/>
       <input type="hidden" name="coord.x2"/>
       <input type="hidden" name="coord.y"/>
       <input type="hidden" name="coord.y2"/>
       <input type="hidden" name="coord.w"/>
       <input type="hidden" name="coord.h"/>
       <input type="hidden" name="user.userPic" />
    </form>
</div>
<script>
//div互相切换方法
function changeDiv(){
		$("#userformdiv").slideUp("slow");
		$("#picDiv").slideDown("slow");
		
}
//选择上传图片方法
 function upload(){ 
       $("#picForm").ajaxSubmit({
          dataType:"json",
          success:function(da){
            if(da.status==1){
               $("#target").attr("src","${pageContext.request.contextPath}/"+da.path);
               $("input[name='user.userPic']").val(da.path);
               $("#target").Jcrop({
                  onSelect:showCoords
               });
            }
          }
       });
    }
    //获取截图坐标的方法
    function showCoords(c){
       $("input[name='coord.x']").val(c.x);
       $("input[name='coord.y']").val(c.y);
       $("input[name='coord.x2']").val(c.x2);
       $("input[name='coord.y2']").val(c.y2);
       $("input[name='coord.w']").val(c.w);
       $("input[name='coord.h']").val(c.h);
    }
    
	//保存截图下来的图片
    function saveCoords(){
      $("#coordForm").ajaxSubmit({
         dataType:"json",
         success:function(da){
            if(da.status==1){
                $("#realuserpic").val(da.path);
                $("#userIcon").attr("src","${pageContext.request.contextPath}/"+da.path);
                $("#userformdiv").slideDown("slow");
                $("#picDiv").slideUp("slow");
            }
         }
      });
    }
    //想数据库添加一个用户
    function saveUser(){
      $("#userForm").ajaxSubmit({
         dataType:"json",
         success:function(da){
            if(da.status==1){
            $("#noticeGrid").datagrid({
       		 url:"selalluser.action"
        	});	    	
             $('#w').window('close');
            }else{
            	alert("添加用户失败！");
            }
         }
      });
    }
</script>
