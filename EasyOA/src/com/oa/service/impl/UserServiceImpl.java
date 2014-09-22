package com.oa.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseServiceImpl;
import com.oa.entity.OaUser;
import com.oa.service.IUserService;
/**
 * 用户service
 * @author Administrator
 *
 */
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
	/**
	 * log日志记录实体类
	 */
	Logger  log  = LogManager.getLogger(UserServiceImpl.class);
	/**
	 * 用户登入业务判断
	 */
	public OaUser getRealOaUser(OaUser user) {
		OaUser result_user=null;
		String hql="from OaUser u where u.uuid=?";
		try {
			result_user=super.selObjById(hql, user.getUuid());
			if(null!=result_user){
				if(!result_user.getPassword().equals(user.getPassword())){
					result_user=null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result_user;
	}
		
}
