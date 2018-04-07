package com.zml.oa.service;

import java.io.Serializable;
import java.util.List;

import com.zml.oa.entity.Customer;
import com.zml.oa.pagination.Page;

/**
 *  客户信息接口
 * @author ccs
 *
 */
public interface ICustomerService {

	public Serializable doAdd(Customer customer) throws Exception;
	
	public void doUpdate(Customer customer) throws Exception;
	
	public void doDelete(Customer customer) throws Exception;
	
	public List<Customer> toList(Integer userId) throws Exception;
	
	public Customer findById(Integer id) throws Exception;
	
	public List<Customer> findByStatus(Integer userId, String status, Page<Customer> page) throws Exception;

	public List<Customer> queryForPage(String hql, String countHql) throws Exception; 
}
