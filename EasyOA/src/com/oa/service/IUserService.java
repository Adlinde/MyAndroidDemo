package com.oa.service;

import com.oa.common.IBaseService;
import com.oa.entity.OaUser;
/**
 * �û�service�ӿ�
 * @author Administrator
 *
 */
public interface IUserService extends IBaseService {
		public OaUser getRealOaUser(OaUser user);
}
