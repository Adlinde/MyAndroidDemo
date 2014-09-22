<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
		
		<script type="text/javascript">
		function add(){
		
		var begintime=$("#begintime").val();
		var endtime=$("#endtime").val();
		var reason=$("#leavereason").val();
		var day=$("#leaveday").val();
		var type=$("#type").val();
		
		 if(day==""){
		alert("请假天数不能为空");
		return false;
		}
		
		else if(reason==""){
		alert("请假事由不能为空");
		return false;
		}
		
		
	    $("#addForm").ajaxSubmit({
                  dataType:"json",
                  success:function(data){
                  
                       alert(data.msg);
}
});
		}
       
		</script>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
  
  <div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="请假申请" style="padding:10px">
			 
			 <form action="addLeave.action" method="post" id="addForm">
                 <table width="80%" border="0" class="table_thintd" >
                      <tr>
                        <td align="right">姓名：</td>
                        <td>${sessionScope.currentUser.name}</td>
                        <input type="hidden" name="leave.oaUserByUserid.uuid" value="${sessionScope.currentUser.uuid}"/>
                        <td align="right">部门：</td>
                        <td>${sessionScope.currentUser.oaDept.deptName}</td>
                        <input type="hidden" name="leave.oaUserByNextUserid.uuid" value="${sessionScope.currentUser.oaDept.oaUser.uuid}"/>
                      </tr>
                      
                     <tr>
                        <td align="right">时间：</td>
                        <td colspan="3">
                             <input type="text" name="leave.begintime" id="begintime" class="easyui-datebox"  size="10"/>
                                                   to
                             <input type="text" name="leave.endtime" id="endtime" class="easyui-datebox"  size="10"/>  
                        </td>
                      </tr>
                      
                      <tr>
                        <td align="right">请假天数</td>
                        <td><input name="leave.leaveDay" type="text" id="leaveday"/></td>
                        <td align="right">请假类型：</td>
                        <td>
                            <input class="easyui-combobox" id="type" name="leave.oaDictionary.dictionaryUuid"
			data-options="url:'loadTypeLeave.action',valueField:'dictionaryUuid',textField:'dictionnaryValue'">
                        
                        </td>
                      </tr>
                      
                    
                      <tr>
                        <td align="right">请假事由：</td>
                        <td colspan="3">
                            <textarea name="leave.leaveReason" id="leavereason" cols="60" rows="8"></textarea>
                        </td>
                      </tr>

                       <tr>
                        <td colspan="4" align="center">
                        	<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-save',toggle:true" onclick="add()">提交申请</a>
                        </td>
                      </tr>
                    </table>  
                    </form>         
  </div>	
</div>
  
  
 

</body>
</html>
