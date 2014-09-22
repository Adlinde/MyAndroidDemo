package com.oa.common;

import java.io.Serializable;
import java.util.List;

/**
 * 通用BaseDao接口
 * @author Administrator
 *
 */
public interface IBaseDao{
	
	/**
	 * 通用的保存方法
	 * @param t
	 * @throws Exception
	 */
    public <T>  void save(T t) throws Exception;
    
	/**
	 * 通用的更新方法
	 * @param t
	 * @throws Exception
	 */
	public <T>  void update(T t) throws Exception;
	
	/**
	 * 通用的删除方法
	 * @param t
	 * @throws Exception
	 */
	public <T>  void delete(T t) throws Exception;
	
	/**
	 * 通用的根据id查询返回一个对象
	 * @param <T>
	 * @param hql
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T selObjById(String hql,Serializable id)throws Exception;
	
	/**
	 * 通用的根据name查询返回一个对象
	 * @param <T>
	 * @param hql
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T selObjByName(String hql,String name)throws Exception;
	
	/**
	 * 通用的查出所有的方法
	 * @param hql
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> findAll(String hql,Object ...value)throws Exception;
	
	/**
	 * 通用的分页查询方法
	 * @param hql
	 * @param obj
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> findAllByPage(String hql,int pageIndex,int pageSize,Object ...value)throws Exception;
	
	/**
	 * 通用的查询总数方法
	 * @param hql
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public int findAllCount(String hql,Object ...value)throws Exception;
}
