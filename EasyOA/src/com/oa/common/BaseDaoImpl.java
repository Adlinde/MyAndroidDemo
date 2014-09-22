package com.oa.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 通用BaseDao实现类
 * @author Administrator
 *
 */
public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

	/**
	 * 通用的删除方法
	 */
	public <T> void delete(T t) throws Exception {
		this.getHibernateTemplate().delete(t);
	}

	/**
	 * 通用的保存方法
	 */
	public <T> void save(T t) throws Exception {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * 通用的更新方法
	 */
	public <T> void update(T t) throws Exception {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * 通用的查询所有方法
	 */
	public<T> List<T> findAll(String hql, Object... value) throws Exception {
		return this.getHibernateTemplate().find(hql, value);
	}

	/**
	 * 通用的分页查出方法
	 */
	public <T> List<T> findAllByPage(final String hql, 
			final int pageIndex, final int pageSize,final Object... value) throws Exception {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List>() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (null != value && value.length > 0) {
							for (int i = 0; i < value.length; i++) {
								query.setParameter(i, value[i]);
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
	 * 查出所有总数的方法
	 */
	public int findAllCount(final String hql, final Object... value)
			throws Exception {
		int count = 0;
		count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (null != value && value.length > 0) {
					for (int i = 0; i < value.length; i++) {
						query.setParameter(i, value[i]);
					}
				}
				return Integer.valueOf(query.uniqueResult() + "");
			}
		});
		return count;
	}

	/**
	 * 根据的ID查出一个对象
	 */
	public <T> T selObjById(final String hql, final Serializable id)
			throws Exception {
		T t = null;
		t = (T) this.getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setParameter(0, id);
				return (T) (query.uniqueResult());
			}
		});
		return t;
	}

	/**
	 * 根据名字查出一个对象
	 */
	public <T> T selObjByName(final String hql,final String name) throws Exception {
		T t = null;
		t = (T) this.getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setParameter(0, name);
				return (T) (query.uniqueResult());
			}
		});
		return t;
	}

}
