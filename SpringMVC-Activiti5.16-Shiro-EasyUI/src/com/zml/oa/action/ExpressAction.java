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
import com.zml.oa.entity.ExpressInfo;
import com.zml.oa.entity.Message;
import com.zml.oa.entity.User;
import com.zml.oa.pagination.Pagination;
import com.zml.oa.pagination.PaginationThreadUtils;
import com.zml.oa.service.IExpressInfoService;
import com.zml.oa.util.UserUtil;

/**
 * 快递信息
 * 
 * @author ccs
 * 
 */

@Controller
@RequestMapping("/expressAction")
public class ExpressAction {
	private static Logger logger = Logger.getLogger(ExpressAction.class);

	@Autowired
	IExpressInfoService expressService;

	/**
	 * 查询快递信息集合
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("user:express:*")
	@RequestMapping("/toList_page")
	public String toList(Model model) throws Exception {
//		User user = UserUtil.getUserFromSession();

		return "express/list_express";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:express:*")
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "express/add_customer";
	}

	@RequiresPermissions("user:express:*")
	@RequestMapping("/bindTable")
	@ResponseBody
	public Map<String, Object> bindTable(
			@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam(value= "searchKey",required=false ) String searchKey)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
		pagination.setCurrentPage(pageNum);
		pagination.setPageNum(pageSize);
		PaginationThreadUtils.set(pagination);
		String hql = "select t from ExpressInfo t  where 1=1";
		String countHql = "select count(*) from ExpressInfo  where 1=1 ";
		
		if (StringUtils.isNoneBlank(searchKey)) {
			hql += " and t.receiverCompany like '%"+searchKey+"%' ";
			countHql += " and t.receiverCompany like '%"+searchKey+"%' ";
		}
		
		hql += "order by t.expressId desc";
		List<ExpressInfo> list = this.expressService.queryForPage(hql,countHql);
		Long total = expressService.queryCount(countHql);
		map.put("rows", list);
		map.put("total", total);
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
	@RequiresPermissions("user:express:doAdd")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Message doAdd(@RequestParam("express") String expressStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		ExpressInfo express = JSONObject.parseObject(expressStr,
				ExpressInfo.class);
		System.out.println("getExpressCode:" + express.getExpressCode());
		Message message = new Message();
		express.setCreateUser(currentUser.getName());
		express.setCreateDate(new Date());
		try {
			expressService.doAdd(express);
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
	@RequiresPermissions("user:express:doAdd")
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Message doUpdate(@RequestParam("express") String expressStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		ExpressInfo express = JSONObject.parseObject(expressStr,
				ExpressInfo.class);
		System.out.println("getExpressCode:" + express.getExpressCode());
		Message message = new Message();
		express.setCreateUser(currentUser.getName());
		express.setCreateDate(new Date());
		try {
			expressService.doUpdateExpressInfo(express);
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
	@RequiresPermissions("user:express:doAdd")
	@RequestMapping(value = "/deleteExpressInfo", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteExpressInfo(@RequestParam("express") String expressStr)
			throws Exception {
		User currentUser = UserUtil.getUserFromSession();
		ExpressInfo express = JSONObject.parseObject(expressStr,
				ExpressInfo.class);
		System.out.println("getExpressCode:" + express.getExpressCode());
		Message message = new Message();
		express.setCreateUser(currentUser.getName());
		express.setCreateDate(new Date());
		try {
			expressService.deleteExpressInfo(express);
			message.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			message.setStatus(false);
		}

		return message;
	}
}
