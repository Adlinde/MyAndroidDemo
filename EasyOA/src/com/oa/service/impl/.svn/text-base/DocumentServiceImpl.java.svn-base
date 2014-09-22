package com.oa.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oa.common.BaseServiceImpl;
import com.oa.dao.IDocumentDao;
import com.oa.dao.impl.DocumentDaoImpl;
import com.oa.entity.OaDocument;
import com.oa.service.IDocumentService;
import com.oa.util.Page;
/**
 * 文档service
 * @author Administrator
 *
 */
public class DocumentServiceImpl extends BaseServiceImpl implements
		IDocumentService {

	private IDocumentDao dao;//文档dao对象
	
	/**
	 * 模糊查询所有文档信息的方法
	 */
	public List<OaDocument> selAllDocsByKeys(Page page,
			OaDocument document, Date beginTime, Date endTime) {
		String hql="from OaDocument doc where 1=1";
		ArrayList<Object> value=new ArrayList<Object>();
		if(document!=null){
			if(document.getFilename()!=null&&document.getFilename().length()>0){
				hql+=" and doc.filename like ?";
				value.add("%"+document.getFilename()+"%");
				
			}
			if(document.getOaUser()!=null&&document.getOaUser().getName()!=null&&document.getOaUser().getName().length()>0){
				hql+=" and doc.oaUser.name like ?";
				value.add("%"+document.getOaUser().getName()+"%");
				
			}
			if(beginTime!=null){
				hql+=" and doc.fileCreattime >=?";
				value.add(beginTime);
			}
			if(endTime!=null){
				hql+=" and doc.fileCreattime <=?";
				value.add(endTime);
			}
		}
		List<OaDocument> list=null;
		try {
			list=dao.findAllByPage(hql,page.getPageIndex(),page.getPageSize(),value);
			page.setList(list);
			page.setPageCount(dao.findAllCount("select count(*) "+hql));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public IDocumentDao getDao() {
		return dao;
	}
	public void setDao(IDocumentDao dao) {
		this.dao = dao;
	}

}
