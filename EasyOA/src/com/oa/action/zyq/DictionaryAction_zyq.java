package com.oa.action.zyq;

import com.oa.common.BaseAction;
import com.oa.service.IDictionaryService;
/**
 * �ֵ�action��
 * @author zyq
 *
 */
public class DictionaryAction_zyq extends BaseAction{
		private IDictionaryService dictionaryService;//�ֵ�ҵ��ʵ����

		public IDictionaryService getDictionaryService() {
			return dictionaryService;
		}

		public void setDictionaryService(IDictionaryService dictionaryService) {
			this.dictionaryService = dictionaryService;
		}	
}
