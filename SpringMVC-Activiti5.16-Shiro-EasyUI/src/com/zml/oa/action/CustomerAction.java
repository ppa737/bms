package com.zml.oa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.zml.oa.entity.Customer;
import com.zml.oa.entity.Message;
import com.zml.oa.entity.User;
import com.zml.oa.pagination.Pagination;
import com.zml.oa.pagination.PaginationThreadUtils;
import com.zml.oa.service.ICustomerService;
import com.zml.oa.util.UserUtil;

/**
 * 客户信息
 * @author ccs
 *
 */

@Controller
@RequestMapping("/customerAction")
public class CustomerAction {
	private static Logger logger = Logger.getLogger(CustomerAction.class);
	
	@Autowired
	ICustomerService custmoerService;
	
	/**
	 * 查询某人的所有请假申请
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:customer:*")
	@RequestMapping("/toList_page")
	public String toList(Model model) throws Exception{
//		User user = UserUtil.getUserFromSession();

		return "customer/list_customer";
	}
	
	
	
	/**
	 * 跳转添加页面
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:customer:toAdd")
	@RequestMapping(value = "/toAdd")
	public String toAdd(){
		return "customer/add_customer";
	}
	
	@RequiresPermissions("user:customer:*")
	@RequestMapping("/bindTable")
	@ResponseBody
	public Map<String, Object> bindTable(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam(value= "searchKey",required=false ) String searchKey,Model model) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		User user = UserUtil.getUserFromSession();
//		for(Vacation v : list){
//			if(BaseVO.APPROVAL_SUCCESS.equals(v.getStatus())){
//				Vacation customer = (Vacation)this.historyService.createHistoricVariableInstanceQuery()
//					.processInstanceId(v.getProcessInstanceId()).variableName("entity");
//				
//			}
//		}
		Pagination pagination = new Pagination();
		pagination.setCurrentPage(pageNum);
		pagination.setPageNum(pageSize);
		PaginationThreadUtils.set(pagination);
		String hql = "select t from Customer t where 1=1 ";
		String countHql = "select count(*) from Customer t where 1=1 ";
		if (StringUtils.isNoneBlank(searchKey)) {
			hql += "and t.custName like '%"+searchKey+"%' ";
			countHql += "and t.custName like '%"+searchKey+"%' ";
		}
		
		if ("partner".equals(user.getGroup().getType())) {
			hql += " and t.createUser ='"+user.getName()+"' ";
			countHql += " and t.createUser ='"+user.getName()+"' ";
		}
		hql+="order by t.custId desc ";
		
		List<Customer> list = this.custmoerService.queryForPage(hql,countHql);
		System.out.println(pagination.getPageNum());
		model.addAttribute("page", pagination.getPageStr());
		model.addAttribute("customerList", list);
		map.put("rows", list);
		map.put("total", pagination.getTotalSum());
		return map;
	}
	
	/**
	 * 添加快递
	 * 
	 * @param salary
	 * @param results
	 * @param redirectAttributes
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:customer:doAdd")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Message doAdd(@RequestParam("customer") String expressStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Customer customer = JSONObject.parseObject(expressStr,
				Customer.class);
		System.out.println("getCustCode:" + customer.getCustCode());
		Message message = new Message();
		customer.setCreateUser(currentUser.getName());
		customer.setCreateDate(new Date());
		try {
			custmoerService.doAdd(customer);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
	
	/**
	 * 更改快递
	 * 
	 * @param salary
	 * @param results
	 * @param redirectAttributes
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:customer:doUpdate")
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Message doUpdate(@RequestParam("customer") String expressStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Customer customer = JSONObject.parseObject(expressStr,
				Customer.class);
		Message message = new Message();
		customer.setModifyUser(currentUser.getName());
		customer.setModifyDate(new Date());
		try {
			custmoerService.doUpdate(customer);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
	
	/**
	 * 删除快递
	 * 
	 * @param salary
	 * @param results
	 * @param redirectAttributes
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:customer:delete")
	@RequestMapping(value = "/deleteExpressInfo", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteExpressInfo(@RequestParam("customer") String customerStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		Customer customer = JSONObject.parseObject(customerStr,
				Customer.class);
		System.out.println("getExpressCode:" + customer.getCustCode());
		Message message = new Message();
		customer.setCreateUser(currentUser.getName());
		customer.setCreateDate(new Date());
		try {
			custmoerService.doDelete(customer);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
}
