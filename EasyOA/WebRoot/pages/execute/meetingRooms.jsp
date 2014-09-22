<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="../util.jsp" %>
</head>
<body >
  <div id="w" class="easyui-window" title=" " data-options="modal:true,closed:true" style="width:500px;height:300px;padding-top:20px">
  </div>
  
  
  <div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="会议室预定" style="padding:10px">
			<form action="">
			  <div style="padding:5px;background: #FFFEE6">
		                                      
		                                          预定时间段 ：<input type="text" name="meetingPreplot.begintime" style="width:90px" class="easyui-datebox" />
		                                           to
		                     <input type="text" name="meetingPreplot.endtime" style="width:90px" class="easyui-datebox" />
		                                            提示：预定时间段必须为同一天
		     
		      </div>
		      <table class="easyui-datagrid" title="可预订会议室查询列表" 
						data-options="rownumbers:true,url:'selyesmeetingMeeting.action',
						method:'get',pagination:true,checkOnSelect:false" id="applyGrid">
					<thead>
						<tr>
						    <th data-options="field:'ck',width:30,checkbox:true"></th>
							<th data-options="field:'meetingName',width:200">会议名称</th>                 
							<th data-options="field:'meetingDesc',width:400">会议室描述</th>
						
						</tr>
					</thead>
				</table>
                
               <div style="padding:5px;background:#FFFEE6">
                   预订人 ：
			<input class="easyui-combobox"  name="meetingPreplot.oaUserByPreplotUserid.uuid"
			data-options="url:'${pageContext.request.contextPath}/selOneAlluser.action',valueField:'uuid',textField:'name'">
                   请选择会议类型 ：
                   <input class="easyui-combobox" name="meetingPreplot.oaDictionary.dictionaryUuid"
			data-options="url:'loadMeetingTypeMeetingPreplot.action',valueField:'dictionaryUuid',textField:'dictionnaryValue'">
                     <a href="#" class="easyui-linkbutton" style="vertical-align: middle">预定</a>
              </div>
          </form>      
                
		</div>
		
		<div title="会议预定管理" style="padding:10px"> 
              <div style="padding:5px;background: #FFFEE6">
                预订人 ：<input type="text" name=""   size="10" />
                   请选择会议类型 ：
                   <input class="easyui-combobox" id="language" name="meetingPreplot.oaDictionary.dictionaryUuid"
			data-options="url:'loadMeetingTypeMeetingPreplot.action',valueField:'dictionaryUuid',textField:'dictionnaryValue'">
                  <a href="#" class="easyui-linkbutton" style="vertical-align: middle">检索</a>
                  
                  <a href="#" class="easyui-linkbutton" style="vertical-align: middle">取消预定</a>
		     
		      </div>
		      
		      
		      <table class="easyui-datagrid" title="会议室列表"
						data-options="rownumbers:true,url:'selappmeetingMeetingPreplot.action',
						method:'get',pagination:true,checkOnSelect:false">
					<thead>
						<tr>
						    <th data-options="field:'ck',width:30,checkbox:true"></th>
							<th data-options="field:'oaMeeting',width:250">会议室名称</th>
							<th data-options="field:'begintime',width:150">会议室起始时间</th>
                            <th data-options="field:'endtime',width:150">会议室结束时间</th>
                            <th data-options="field:'oaUserByRecorder',width:60">记录人</th>
							<th data-options="field:'oaUserByPreplotUserid',width:60">预订人</th>
							<th data-options="field:'preplotTime',width:160">预定时间</th>			
						</tr>
					</thead>
				</table>
             
             
		</div>
		
		<div title="会议室管理"  style="padding:10px">
			   <table class="easyui-datagrid" title="现有会议室列表" id="meetingGrid"
						data-options="rownumbers:true,url:'selallmeetingMeeting.action',
						method:'get',pagination:true,checkOnSelect:false,toolbar:toolbar,">
					<thead>
						<tr>
							<th data-options="field:'meetingName',width:150">会议室名称</th>
							<th data-options="field:'meetingDesc',width:400">会议室描述</th>
							<th data-options="field:'meetingState',width:400">会议室状态</th>
                            <th data-options="field:'puttime',width:100,formatter:operate">操作</th>				
						</tr>
					</thead>
				</table>  
		</div>
	</div>
  
  
 

</body>
</html>
<script>


	function saveapply(){
		var rows = $('#applyGrid').datagrid('getChecked');
		   if(rows.length==1){		        
		    $.ajax({
			dataType:"json",
			url:"addMeetingPreplot.action?meetingPreplot.oaMeeting.uuid="+rows,
			success:function(data){
			  if(data.st==1){
				alert(data.msg);
        		$('#applyGrid').datagrid('reload');
			  }else{
		 		$('#w').window('close');
				alert(data.msg);
			  }
			  }
			  });
		   }else{
		     alert("只能选择一个会议室预定");
		   }
	}
	
	

	function operate(value,row,index){
		return "<a href='javascript:;' onclick='toEditNotice("+row.uuid+")' >修改</a>&nbsp;&nbsp;<a href='javascript:;' onclick='delMeeting("+row.uuid+")'>删除</a>";
		}
	
	
	function delMeeting(id){
		confirm("是否删除?");
			$.ajax({
			dataType:"json",
			url:"delCar.action?meeting.uuid="+id,
			success:function(data){
			  if(data.status==1){
			  	alert(data.msg);
			  	$('#carsGrid').datagrid('reload');
			  }else{
			  	alert(data.msg);
			  	$('#carsGrid').datagrid('reload');
			  }
			}
			});
		}
	
	
	
	
	var toolbar = [{
			text:'添加会议室',
			iconCls:'icon-add',
			handler:function(){
				addMeetingRoom();
		    }
		}];
		
		
	 function addMeetingRoom(){
		   $('#w').panel('setTitle','添加会议室');
		   $('#w').window('refresh','meetingRommAdd.jsp');
		   $('#w').window('center');	
		   $('#w').window('open');	
     }
 

</script>