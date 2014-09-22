<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="pages/util.jsp" %>

<script type="text/javascript">


 $.extend($.fn.validatebox.defaults.rules, {  
    /*必须和某个字段相等*/
    equalTo: {
        validator:function(value,param){
            return $(param[0]).val() == value;
        },
        message:'两次密码输入不一致'
    }
  
});

function doExit(){

var result=confirm("确定要退出该系统吗？");
if(result){
  location.href='exituser.action';
  return true;
}
return false;
}


function doEdit(){

  $("#editForm").ajaxSubmit({
                  dataType:"json",
                  success:function(da){
            if(da.status==2){
               $('#w').window('close');
               location.href='${pageContext.request.contextPath}/'+da.msg;
            }else{
            	alert(da.msg);
             $('#w').window('close');
            
            }
         }
               });

}


</script>
</head>

<body class="easyui-layout">


	<div data-options="region:'north',border:false" style="height:70px;padding:0px">
         <div class="top_bar">
             <div class="top_logo">
                 <img src="${pageContext.request.contextPath}/images/top_log.png" height="50"/>
             </div>
             
             <div class="top_nav">
             
             <a href="javascript:;" onclick="$('#w').window('open')">修改密码</a> |  <a href="javascript:;" onclick="doExit()">安全退出</a>
            
             </div>
            
             <div id="w" class="easyui-window " title="修改密码" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:300px;height:220px;padding:10px;">
  			 <form id="editForm" action="editPwduser.action" method="post" >
		<table cellpadding="5">
			<tr>
				<td>原密码:</td>			
				<td><input id="oldpwd" name="oldPwd" validType="length[6,32]" missingMessage="请输入原密码" class="easyui-validatebox" required="true" type="password" /> </td>
			</tr>
			<tr>

				<td>新密码:</td>
				
				<td><input id="newpwd" name="newPwd" validType="length[6,32]" class="easyui-validatebox" missingMessage="请输入新密码" required="true" type="password" value=""/></td>
			</tr>
			<tr>
				<td>确认密码:</td>

		
				<td><input type="password" id="repwd" required="true" class="easyui-validatebox" missingMessage="请再次确认密码"  validType="equalTo['#w input[name=newPwd]']"/> 

</td>
			</tr>
		    
		     <tr>
    <td colspan="2" align="center">
        <a href="javascript:;" class="easyui-linkbutton" onclick="doEdit()">修改</a>


    
    </td>
    </tr>
		</table>
	</form>
	</div>
	
         </div>
    </div>



	<div data-options="region:'west',split:true,title:'导航栏'" style="width:130px;">
    
      <div class="easyui-accordion" style="width:500px;height:300px;" data-options="fit:true">
		<div title="我的桌面" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			  <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('我的任务','pages/desdisk/task.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>我的任务</h4>
                      </a>
                   </li>
                   
                     <li>
                      <a href="javascript:;" onclick="nva('通知公告','pages/desdisk/mynotice.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>通知公告</h4>
                      </a>      
                   </li>
                   
                     <li>
                       <a href="javascript:;" onclick="nva('我的便签','pages/desdisk/note.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>我的便签</h4>
                      </a>  
                   </li>
                   
                     <li>
                       <a href="javascript:;" onclick="nva('常用工具','http://www.baidu.com')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>常用工具</h4>
                      </a>   
                   </li>
 
              </ul>
              
		</div>
        
		<div title="通告管理" data-options="iconCls:'icon-help'" style="padding:10px;">
			  <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('通告列表','pages/notice/notice.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>通告列表</h4>
                      </a>
                   </li>
              </ul>
		</div>
        
		<div title="文档管理" data-options="iconCls:'icon-search'" style="padding:10px;">
	            <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('文档列表','pages/document/document.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>文档列表</h4>
                      </a>
                   </li>
                   
                     <li>
                      <a href="javascript:;" onclick="nva('文档回收站','pages/document/recycle.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>文档回收站</h4>
                      </a>      
                   </li>
                </ul>
		</div>
        
        <div title="行政管理" data-options="iconCls:'icon-search'" style="padding:10px;">
	
            <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('会议室管理','pages/execute/meetingRooms.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>会议室管理</h4>
                      </a>
                   </li>
                   
                     <li>
                      <a href="javascript:;" onclick="nva('用车管理','pages/execute/cars.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>用车管理</h4>
                      </a>      
                   </li>
                   
                  
              </ul>
		</div>
        
        <div title="人事管理" data-options="iconCls:'icon-search'" style="padding:10px;">
	           <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('请假管理','pages/person/dayoff.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>请假管理</h4>
                      </a>
                   </li>
                   
                     <li>
                      <a href="javascript:;" onclick="nva('出差管理','pages/person/businessTrip.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>出差管理</h4>
                      </a>      
                   </li>
                   
              </ul>
		</div>
        
        <div title="系统管理" data-options="iconCls:'icon-search'" style="padding:10px;">
	           <ul class="ul_nav">
                   <li>
                      <a href="javascript:;" onclick="nva('组织结构管理','pages/system/orgnization.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>组织结构管理</h4>
                      </a>
                   </li>
                   
                     <li>
                      <a href="javascript:;" onclick="nva('用户管理','pages/system/users.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>用户管理</h4>
                      </a>      
                   </li>
                    <li>
                       <a href="javascript:;" onclick="nva('角色管理','pages/system/roles.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>角色管理</h4>
                      </a>   
                   </li>
                   
                    <li>
                       <a href="javascript:;" onclick="nva('操作日志','pages/system/logs.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>操作日志</h4>
                      </a>   
                   </li>
                   
                    <li>
                       <a href="javascript:;" onclick="nva('上传文件设置','pages/system/uploadSet.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>上传文件设置</h4>
                      </a>   
                   </li>
                   
                    <li>
                       <a href="javascript:;" onclick="nva('字典设置','pages/system/dic.jsp')">
                        <img src="${pageContext.request.contextPath}/images/earth.png"  width="50" height="50"/>
                        <h4>字典设置</h4>
                      </a>   
                   </li>
              </ul> 
		</div>
	</div>
  </div>
    
    
    

	<div data-options="region:'south',border:false" style="height:20px;background:#fff;line-height:20px">
            <center>2014&copy;版权信息</center>
    </div>

	<div data-options="region:'center',title:'工作区',url:'myjob.txt'" id="mainArea" style="padding:20px">
 
         <table width="100%"  height="100%" border="0" cellpadding="10">
          <tr>
            <td align="center" width="50%" height="50%">

               <div class="easyui-panel" title="待处理任务" data-options="fit:true">

		              <table class="easyui-datagrid" 
                            data-options="singleSelect:true,url:'toWaitListApplyResult.action',method:'get',
                            rowStyler: function(index,row){
                                if (row.listprice < 30){
                                    return 'background-color:#6293BB;color:#fff;font-weight:bold;';
                                }
                              }
                          ">
                        <thead>
                            <tr>

						<th data-options="field:'title',width:100">任务标题</th>
						
						<th data-options="field:'startTime',width:200">发起时间</th>
			
					
						<th data-options="field:'operation',width:200">操作</th>


					</tr>
                        </thead>
                    </table>
                
   <div style="float:right; margin:10px"><a href="javascript:;" onclick="nva('我的任务','pages/desdisk/task.jsp')">查看更多 >> </a></div>
               </div>
            
            </td>
            <td align="center">
              <div class="easyui-panel" title="通知公告" data-options="fit:true">
		 <table class="easyui-datagrid" 
                            data-options="singleSelect:true,url:'datagrid_data1.json',method:'get',
                            rowStyler: function(index,row){
                                if (row.listprice < 30){
                                    return 'background-color:#6293BB;color:#fff;font-weight:bold;';
                                }
                              }
                          ">
                        <thead>
                            <tr>
                                <th data-options="field:'itemid',width:200">标题</th>
                                <th data-options="field:'listprice',width:100">日期</th>
                                <th data-options="field:'productname',width:150,align:'center',formatter:opts">操作</th>
                            </tr>
                        </thead>
                    </table>
		
   <div style="float:right; margin:10px"><a href="#">查看更多 >> </a></div>
              </div>
            </td>
          </tr>
          <tr>
            <td align="center">
                <div class="easyui-panel" title="我的便签" data-options="fit:true">
		 <table class="easyui-datagrid" 
                            data-options="singleSelect:true,url:'datagrid_data1.json',method:'get',
                            rowStyler: function(index,row){
                                if (row.listprice < 30){
                                    return 'background-color:#6293BB;color:#fff;font-weight:bold;';
                                }
                              }
                          ">
                        <thead>
                            <tr>
                                <th data-options="field:'itemid',width:200">内容</th>
                                
                                <th data-options="field:'productname',width:150,align:'center',formatter:opts">操作</th>
                            </tr>
                        </thead>
                    </table>
		
   <div style="float:right; margin:10px"><a href="#">查看更多 >> </a></div>
              </div>
            
            </td>
            <td align="center">
                <div class="easyui-panel" title="常用工具" data-options="fit:true">
		
		
              </div>
            </td>
          </tr>
        </table>


    </div>

</body>
</html>

<script>
 function nva(vanName,url){
	 $("#mainArea").panel("setTitle","当前位置 >> 工作区 >> "+vanName);
     $("#mainArea").html(createFrame(url));
 }
 
 function createFrame(url)
{
	var s = '<iframe id="mainF" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function opts(val,row){
	 return "<a href='javascript:viewTask()'>审核</a> | <a href='#'>查看</a>";
	
}


function viewTask(){

   
   $('#w').panel('setTitle','嗷嗷嗷');
   $('#w').panel('refresh', 'aa.txt');
 
   $('#w').window('open');	
}
</script>
