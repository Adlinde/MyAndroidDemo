package com.oa.common;

import java.io.Serializable;
import java.util.List;

import com.oa.util.Page;
/**
 * 通用BaseService实现类
 * @author Administrator
 *
 */
public class BaseServiceImpl implements IBaseService{

	private IBaseDao baseDao;//baseDao的属性
	
	/**
	 * 通用的删除业务
	 */
	public <T> int delete(T t) {
		int result = 1;
		try {
			baseDao.delete(t);
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 通用的保存业务
	 */
	public <T> int save(T t) {
		int result = 1;
		try {
			baseDao.save(t);
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 通用的更新业务
	 */
	public <T> int update(T t) {
		int result = 1;
		try {
			baseDao.update(t);
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 通用的查出所有的业务
	 */
	public<T> List<T> findAll(String hql, Object ...value) {
		List ls=null;
		try {
			ls=baseDao.findAll(hql, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	/**
	 * 通用的分页查询业务
	 */
	public <T> List<T> findAllByPage(String hql, Page page,Object ...value){
		List ls=null;
		try {
			ls=baseDao.findAllByPage(hql,page.getPageIndex(),page.getPageSize(),value);
			page.setList(ls);
			page.setPageCount(baseDao.findAllCount("select count(*) "+hql));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	/**
	 * 通用的查出所有总数的业务
	 */
	public int findAllCount(String hql, Object ...value){
		int count=0;
		try {
			count=baseDao.findAllCount(hql, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 通用的根据ID查询对象业务
	 */
	public <T> T selObjById(String hql, Serializable id) {
		T t=null;
		try {
			t=(T) baseDao.selObjById(hql, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	/**
	 * 通用的根据名字查询对象业务
	 */
	public <T> T selObjByName(String hql, String name) {
		T t=null;
		try {
			t=(T) baseDao.selObjByName(hql, name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
