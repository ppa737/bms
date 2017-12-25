package com.zml.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zml.oa.entity.ExpressInfo;
import com.zml.oa.service.IExpressInfoService;

@Service
public class ExpressInfoServiceImpl  extends BaseServiceImpl<ExpressInfo> implements IExpressInfoService{

	@Override
	public void doAdd(ExpressInfo expressInfo)  throws Exception{
		this.add(expressInfo);
		
	}

	@Override
	public void doUpdateExpressInfo(ExpressInfo expressInfo)  throws Exception{
		this.update(expressInfo);
		
	}

	@Override
	public void deleteExpressInfo(ExpressInfo expressInfo)  throws Exception{
		this.delete(expressInfo);
		
	}

	@Override
	public List<ExpressInfo> findList(ExpressInfo expressInfo)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpressInfo> queryForPage(String hql, int pageNumber,
			int pageSize)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpressInfo> queryForPage(ExpressInfo expressInfo,
			int pageNumber, int pageSize) throws Exception{
		List<ExpressInfo> list = this.findByPage("ExpressInfo", new String[]{}, new String[]{});
		return list;
	}

	@Override
	public Long queryCount(String countHql) throws Exception {
		
		Long count = this.count(countHql);
		return count ;
	}

	@Override
	public List<ExpressInfo> queryForPage(String hql,String countHql) throws Exception {
		return this.findByPage(hql,countHql);
	}

}
