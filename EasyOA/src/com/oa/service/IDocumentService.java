package com.oa.service;

import java.util.Date;
import java.util.List;

import com.oa.common.IBaseService;

import com.oa.entity.OaDocument;
import com.oa.util.Page;
/**
 * 文档service接口
 * @author Administrator
 *
 */
public interface IDocumentService extends IBaseService {
    /**
     * 模糊查询所有文档的方法
     * @param page page對象
     * @param document  文檔對象
     * @param beginTime 開始時間
     * @param endTime 結束時間
     * @return 返回文檔集合
     */
	   public List<OaDocument> selAllDocsByKeys(Page page,OaDocument document,Date beginTime,Date endTime);
	

}
