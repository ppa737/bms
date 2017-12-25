package com.zml.oa.service;

import java.util.List;

import com.zml.oa.entity.ExpressInfo;

/***
 * 快递信息服务接口
 * @author 
 *
 */
public interface IExpressInfoService {

	public void doAdd(ExpressInfo expressInfo) throws Exception;
	
	public void doUpdateExpressInfo(ExpressInfo expressInfo) throws Exception;
	
	public void deleteExpressInfo(ExpressInfo expressInfo) throws Exception;
	
	public List<ExpressInfo> findList(ExpressInfo expressInfo) throws Exception;
	
	public List<ExpressInfo> queryForPage(String hql,int pageNumber,int pageSize) throws Exception;
	
	public List<ExpressInfo> queryForPage(ExpressInfo expressInfo,int pageNumber,int pageSize) throws Exception;
	
	public  Long  queryCount(String countHql)throws Exception;

	public List<ExpressInfo> queryForPage(String hql,String countHql) throws Exception ;
		
}
