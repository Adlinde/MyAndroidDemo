package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.oa.common.BaseDaoImpl;
import com.oa.dao.IDocumentDao;
import com.oa.entity.OaDocument;
/**
 * 文档dao
 * @author Administrator
 *
 */
public class DocumentDaoImpl extends BaseDaoImpl implements IDocumentDao {

	/**
	 * 文档模糊查询的方法
	 */
	public List<OaDocument> selAllDocsByKeys(final int pageIndex, final int pageSize,
			final OaDocument document ,final Date beginTime,final Date endTime) throws Exception {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List>() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql="from OaDocument doc where 1=1";
						ArrayList<Object> value=new ArrayList<Object>();
						if(document!=null){
							if(document.getFilename()!=null&&document.getFilename().length()>0){
								hql+=" and doc.filename like ?";
								value.add(document.getFilename());
								
							}
							if(document.getOaUser()!=null&&document.getOaUser().getName()!=null&&document.getOaUser().getName().length()>0){
								hql+=" and doc.oaUser.name like ?";
								value.add(document.getOaUser().getName());
								
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
						Query query = session.createQuery(hql);
						if (null != value && value.size() > 0) {
							for (int i = 0; i < value.size(); i++) {
								query.setParameter(i, value.get(i));
							}
						}
						query.setFirstResult((pageIndex - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.list();
					}

				});
		return list;
	}

	/**
	 * 获取文档总数
	 */
	public int getDocsCount(final OaDocument document,final Date beginTime,final Date endTime) throws Exception {
		int count = 0;
		count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="from OaDocument doc where 1=1";
				ArrayList<Object> value=new ArrayList<Object>();
				if(document!=null){
					if(document.getFilename()!=null&&document.getFilename().length()>0){
						hql+=" and doc.filename like ?";
						value.add(document.getFilename());
						
					}
					if(document.getOaUser()!=null&&document.getOaUser().getName()!=null&&document.getOaUser().getName().length()>0){
						hql+=" and doc.oaUser.name like ?";
						value.add(document.getOaUser().getName());
						
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
				Query query = session.createQuery(hql);
				if (null != value && value.size() > 0) {
					for (int i = 0; i < value.size(); i++) {
						query.setParameter(i, value.get(i));
					}
				}
				return Integer.valueOf(query.uniqueResult() + "");
			}
		});
		return count;
	}




}
