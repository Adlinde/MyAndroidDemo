package com.oa.common;

import java.io.Serializable;
import java.util.List;

import com.oa.util.Page;
/**
 * 通用BaseService接口
 * @author Administrator
 *
 */
public interface IBaseService{

	/**
	 * 通用的保存方法
	 * @param t
	 * @throws Exception
	 */
    public <T>  int save(T t);
    
	/**
	 * 通用的更新方法
	 * @param t
	 * @throws Exception
	 */
	public <T>  int update(T t);
	
	/**
	 * 通用的删除方法
	 * @param t
	 * @throws Exception
	 */
	public <T>  int delete(T t);
	
	/**
	 * 通用的根据id查询返回一个对象
	 * @param <T>
	 * @param hql
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T selObjById(String hql,Serializable id);
	
	/**
	 * 通用的根据name查询返回一个对象
	 * @param <T>
	 * @param hql
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T selObjByName(String hql,String name);
	
	/**
	 * 通用的查出所有的方法
	 * @param hql
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> findAll(String hql,Object ...value);
	
	/**
	 * 通用的分页查询方法
	 * @param hql
	 * @param obj
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> findAllByPage(String hql,Page page,Object ...value);
	
	/**
	 * 通用的查询总数方法
	 * @param hql
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public int findAllCount(String hql,Object ...value);
}
