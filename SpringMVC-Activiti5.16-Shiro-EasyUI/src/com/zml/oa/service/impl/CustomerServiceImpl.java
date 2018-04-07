package com.zml.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.oa.entity.Customer;
import com.zml.oa.pagination.Page;
import com.zml.oa.service.IBaseService;
import com.zml.oa.service.ICustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{

	
	@Autowired 
	private IBaseService<Customer> baseService;
	
	@Override
	public Serializable doAdd(Customer customer) throws Exception {
		return this.baseService.add(customer);
	}

	@Override
	public void doUpdate(Customer customer) throws Exception {
		this.baseService.update(customer);
	}

	@Override
	public void doDelete(Customer customer) throws Exception {
		this.baseService.delete(customer);
	}

	@Override
	public List<Customer> toList(Integer userId) throws Exception {
		List<Customer> list = this.baseService.findByPage("Customer", new String[]{}, new String[]{});
		return list;
	}

	@Override
	public Customer findById(Integer id) throws Exception {
		return this.baseService.getUnique("Customer", new String[]{"id"}, new String[]{id.toString()});
	}

	@Override
	public List<Customer> findByStatus(Integer userId, String status, Page<Customer> page) throws Exception {
		List<Customer> list = this.baseService.getListPage("Customer", new String[]{"userId","status"}, new String[]{userId.toString(), status}, page);
		return list;
	}

	@Override
	public List<Customer> queryForPage(String hql, String countHql)
			throws Exception {
		return this.findByPage(hql,countHql);
	}
}
