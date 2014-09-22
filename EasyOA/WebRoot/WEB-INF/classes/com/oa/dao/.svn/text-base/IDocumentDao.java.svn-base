package com.oa.dao;


import java.util.Date;
import java.util.List;

import com.oa.common.IBaseDao;
import com.oa.entity.OaDocument;
/**
 * 文档dao接口
 * @author Administrator
 *
 */
public interface IDocumentDao extends IBaseDao {
	/**
	 * 模糊查询所有文档的方法
	 * @param pageIndex 页码号
	 * @param pageSize 每页总数
	 * @param document 文档对象
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @return 返回文档列表
	 * @throws Exception
	 */
   public List<OaDocument> selAllDocsByKeys(int pageIndex,int pageSize,OaDocument document,Date beginTime,Date endTime)throws Exception;
   
   /**
    * 获取文档总数的方法
    * @param document 文档对象
    * @param beginTime 开始时间
    * @param endTime 结束时间
    * @return 返回文档总数
    * @throws Exception
    */
	public int getDocsCount(OaDocument document,Date beginTime,Date endTime)throws Exception;
}
