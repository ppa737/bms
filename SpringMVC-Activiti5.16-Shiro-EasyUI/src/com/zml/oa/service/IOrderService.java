package com.zml.oa.service;

import java.util.List;

import com.zml.oa.entity.Order;

/***
 * 快递信息服务接口
 * @author 
 *
 */
public interface IOrderService {

	public void doAdd(Order oder) throws Exception;
	
	public void doUpdate(Order oder) throws Exception;
	
	public void doDelete(Order oder) throws Exception;
	
	public List<Order> findList(Order oder) throws Exception;
	
	public List<Order> queryForPage(String hql,int pageNumber,int pageSize) throws Exception;
	
	public List<Order> queryForPage(Order order,int pageNumber,int pageSize) throws Exception;
	
	public  Long  queryCount(String countHql)throws Exception;

	public List<Order> queryForPage(String hql,String countHql) throws Exception ;
		
}
