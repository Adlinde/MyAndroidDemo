
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>easy oa首页</title>
<link href="${pageContext.request.contextPath}/login/images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.min.js"></script>
		<script >
			//表单提交处理
           $(function(){   		
               $("input[name='sm1']").bind("click",dologin);       
           });
         
           function  dologin(){
           		if($("#username").val()==""){
           			alert("请输入用户名！");
           			return false;
           		};
           		if($("#userpass").val()==""){
           			alert("请输入密码！");
           			return false;
           		}        		
               $(".logForm").ajaxSubmit({
                  cache:false,
                  dataType:"json",
                  success:function(da){
                       if(da.status==2){
                          location.href=da.msg;
                       }else{
                          $("#tip").text(da.msg);
                          $("input[name='sm1']").bind("click",dologin);
                       }
                   }, 
                    beforeSend:function(){
                       $("input[name='sm1']").unbind("click");
                       $("#tip").text("登陆中...");
                   }
               });
           }
           //验证码变化
           function changeImage(){
           		$("#vdimgck").attr("src","imageCode?time="+Math.random()+"");        
           }
        </script>
</head>
<body>
<div id="container">
  <div id="header">
    <h1></h1>
    <ul class="nav">
    </ul>
  </div>
  <div id="content">
    <div class="left_main">
      <h2>最新通知</h2>
      <ul class="news" id="qdkb_html" style="color:#FFFFFF;">
        &nbsp;&nbsp;&nbsp;&nbsp;
        公司出游注意事项 --
      </ul>
      <div class="help_center">
        <h3><a href="http://help.dedecms.com/" target="_blank">帮助中心</a></h3>
        <p><strong>提供专业的技术问题解答</strong></p>
      </div>
      <div class="bbs">
        <h3><a href="http://bbs.dedecms.com/" target="_blank">技术论坛</a></h3>
        <p><strong>发布新产品信息,技术问题解答,资源更新等信息</strong></p>
      </div>
    </div>
    <form  class="logForm" method="post" action="loginuser.action">
      <fieldset class="right_main">
        <legend>用户登录</legend>
        <dl class="setting">
          <dt>
            <label>用户名</label>
          </dt>
          <dd><span class="text_input">
            <input type="text" name="user.uuid" id="username"/>
            </span></dd>
          <dt>
            <label>密　码</label>
          </dt>
          <dd><span class="text_input">
            <input type="password" name="user.password" id="userpass" />
            </span></dd>
          <dt>
            <label>验证码</label>
          </dt>
          <dd><span class="short_input">
            <input  id="vdcode" type="text" style="text-transform: uppercase;" name="imageCode"/>
            </span> <span class="yzm"><img id="vdimgck" class="codeimage"  onclick="changeImage();" style="cursor: pointer;" title="看不清？点击更换" alt="验证码" src="${pageContext.request.contextPath}/imageCode"/>
                &nbsp;&nbsp;<font color="red" ><a href="javascript:;" onclick="changeImage();">看不清</a></font></span>
          <input type="button" name="sm1"  class="login_btn" />
          </dd>
          <dd>
			<font color="red" id="tip"></font> 
		 </dd>
        </dl>
      </fieldset>
    </form>
  </div>
  <div id="footer"></div>
</div>
</body>
</html>