package com.zml.oa.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zml.oa.entity.Customer;
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
		User user = UserUtil.getUserFromSession();
		List<Customer> list = this.custmoerService.toList(user.getId());
//		for(Vacation v : list){
//			if(BaseVO.APPROVAL_SUCCESS.equals(v.getStatus())){
//				Vacation customer = (Vacation)this.historyService.createHistoricVariableInstanceQuery()
//					.processInstanceId(v.getProcessInstanceId()).variableName("entity");
//				
//			}
//		}
		Pagination pagination = PaginationThreadUtils.get();
		model.addAttribute("page", pagination.getPageStr());
		model.addAttribute("customerList", list);
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
}
