package com.zml.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zml.oa.entity.Order;
import com.zml.oa.service.IOrderService;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order>  implements IOrderService{

	@Override
	public void doAdd(Order oder) throws Exception {
		this.add(oder);
		
	}

	@Override
	public void doUpdate(Order oder) throws Exception {
		this.update(oder);
	}

	@Override
	public void doDelete(Order oder) throws Exception {
		this.delete(oder);
		
	}

	@Override
	public List<Order> findList(Order oder) throws Exception {
		return this.findByPage("Order", new String[]{}, new String[]{});
	}

	@Override
	public List<Order> queryForPage(String hql, int pageNumber, int pageSize)
			throws Exception {
		List<Order> list = this.findByPage("Order", new String[]{}, new String[]{});
		return list;
	}

	@Override
	public List<Order> queryForPage(Order order, int pageNumber, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long queryCount(String countHql) throws Exception {
		return  this.count(countHql);
	}

	@Override
	public List<Order> queryForPage(String hql, String countHql)
			throws Exception {
		return this.findByPage(hql,countHql);
	}
	
	@Override
	public Order findById(Integer id) throws Exception {
		return this.getUnique("Order", new String[]{"id"}, new String[]{id.toString()});
	}

	@Override
	public void doUpdateRemind(Order order) throws Exception {
		
		String hql = "update Order t set t.remindStatus='" +order.getRemindStatus()+"' where t.orderId="+order.getOrderId();
		this.executeUpdateHql(hql);
		
	}

}
