package com.oa.action.zyq;

import com.oa.common.BaseAction;
import com.oa.service.IRoleAuthService;
/**
 * ��ɫȨ��action��
 * @author Administrator
 *
 */
public class RoleAuthAction_zyq extends BaseAction{
		private IRoleAuthService roleauthService;//��ɫȨ��ʵ����

		public IRoleAuthService getRoleauthService() {
			return roleauthService;
		}

		public void setRoleauthService(IRoleAuthService roleauthService) {
			this.roleauthService = roleauthService;
		}
		
		
}
