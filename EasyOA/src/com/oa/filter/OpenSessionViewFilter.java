package com.oa.filter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
/**
 * session过滤器
 * @author Administrator
 *
 */
public class OpenSessionViewFilter extends
		org.springframework.orm.hibernate3.support.OpenSessionInViewFilter {
	/**
	 * 关闭session方法
	 */
	@Override
	protected void closeSession(Session session, SessionFactory sessionFactory) {
		session.flush();
		super.closeSession(session, sessionFactory);
	}
	
	/**
	 * 得到session方法
	 */
	@Override
	protected Session getSession(SessionFactory sessionFactory)
			throws DataAccessResourceFailureException {
		Session session=sessionFactory.openSession();
		session.setFlushMode(FlushMode.COMMIT);
		return session;
	}

}
