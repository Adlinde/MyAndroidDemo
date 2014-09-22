package com.oa.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseServiceImpl;
import com.oa.entity.OaUser;
import com.oa.service.IUserService;
/**
 * �û�service
 * @author Administrator
 *
 */
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
	/**
	 * log��־��¼ʵ����
	 */
	Logger  log  = LogManager.getLogger(UserServiceImpl.class);
	/**
	 * �û�����ҵ���ж�
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
