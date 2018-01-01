package com.zml.oa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zml.oa.entity.Message;
import com.zml.oa.entity.Order;
import com.zml.oa.entity.User;
import com.zml.oa.pagination.Pagination;
import com.zml.oa.pagination.PaginationThreadUtils;
import com.zml.oa.service.IOrderService;
import com.zml.oa.util.UserUtil;

/**
 * 订单信息
 * 
 * @author ccs
 * 
 */

@Controller
@RequestMapping("/orderAction")
public class OrderAction {
	private static Logger logger = Logger.getLogger(OrderAction.class);

	@Autowired
	IOrderService orderService;

	/**
	 * 查询订单信息集合
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:order:*")
	@RequestMapping("/toList_page")
	public String toList(Model model) throws Exception {
//		User user = UserUtil.getUserFromSession();

		return "order/list_order";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:order:*")
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "order/add_customer";
	}

	@RequiresPermissions("user:order:*")
	@RequestMapping("/bindTable")
	@ResponseBody
	public Map<String, Object> bindTable(
			@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setCurrentPage(pageNum);
		pagination.setPageNum(pageSize);
		PaginationThreadUtils.set(pagination);
		String hql = "select t from Order t order by t.orderId desc";
		String countHql = "select count(*) from Order ";
		List<Order> list = this.orderService.queryForPage(hql,countHql);
		Long total = orderService.queryCount(countHql);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	/**
	 * 添加订单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:order:doAdd")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Message doAdd(@RequestParam("order") String orderStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Order order = JSONObject.parseObject(orderStr,
				Order.class);
		System.out.println("getOrderCode:" + order.getOrderCode());
		Message message = new Message();
		order.setCreateUser(currentUser.getName());
		order.setCreateDate(new Date());
		try {
			orderService.doAdd(order);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
	
	/**
	 * 更改订单
	 * 
	 * @param orderStr
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:order:doAdd")
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Message doUpdate(@RequestParam("order") String orderStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Order order = JSONObject.parseObject(orderStr,
				Order.class);
		System.out.println("getOrderCode:" + order.getOrderCode());
		Message message = new Message();
		order.setCreateUser(currentUser.getName());
		order.setCreateDate(new Date());
		try {
			orderService.doUpdate(order);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
	
	/**
	 * 删除订单
	 * 
	 * @param salary
	 * @param results
	 * @param redirectAttributes
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:order:doAdd")
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteOrder(@RequestParam("order") String orderStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Order order = JSONObject.parseObject(orderStr,
				Order.class);
		System.out.println("getOrderCode:" + order.getOrderCode());
		Message message = new Message();
		order.setCreateUser(currentUser.getName());
		order.setCreateDate(new Date());
		try {
			orderService.doDelete(order);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
}
