package com.oa.interceptor;


import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.oa.entity.OaLogSheet;
import com.oa.entity.OaUser;
import com.oa.service.ILogSheetService;
import com.oa.service.impl.LogSheetServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * session拦截器
 * @author Administrator
 *
 */
public class SessionIntercetor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		
		String ip=ServletActionContext.getRequest().getRemoteAddr();
		String method=ai.getProxy().getMethod();
		//if(method.indexOf("login")>0){
		//	System.out.println("ip:"+ip+"在"+new Date()+"时间执行了"+method+"方法");
		//	return ai.invoke();
		//}
		
		if(!method.equals("login")){
			
			OaUser user=(OaUser) ActionContext.getContext().getSession().get("currentUser");
			
			
			if(user==null){
				System.out.println("ip:"+ip+"在"+new Date()+"时间执行了"+method+"方法");
				return Action.LOGIN;
			}else{
//				ILogSheetService service=new LogSheetServiceImpl();
//				OaLogSheet log=new OaLogSheet();
//				log.setEventType(method);
//				log.setOaUser(user);
//				log.setTime(new Date());
//				service.save(log);
				System.out.println("ip:"+ip+"在"+new Date()+"时间执行了"+method+"方法");
				return ai.invoke();
			}
		}else{
			System.out.println("ip:"+ip+"在"+new Date()+"时间执行了"+method+"方法");
			return ai.invoke();
		}
	}
	
	

}
