package com.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.dao.CustomerDao;
import com.test.domain.CustomerModel;
import com.test.domain.LeveModel;
import com.test.utils.PageBean;
@Controller
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<LeveModel> findAllLevel() {
		return customerDao.findAllLevel();
		
	}

	@Override
	public void addCustomer(CustomerModel customerModel) {
		customerDao.addCustomer(customerModel);
		
	}
	//查询所有客户信息
	@Override
	public List<CustomerModel> findAll() {
		
		return customerDao.findAll();
	}
	//根据cid查询
	@Override
	public CustomerModel findOne(CustomerModel customerModel) {
		return customerDao.findOne(customerModel);
	}
	//修改
	@Override
	public void update(CustomerModel customerModel) {
		customerDao.update(customerModel);
	}
	//根据cid删除数据
	@Override
	public void delete(String cid) {
		customerDao.delete(cid);
	}
	//条件查询带分页
	@Override
	public PageBean cusMorePage(PageBean<CustomerModel> pageBean,
			CustomerModel customerModel) {
		if(pageBean.getCurrentPage()==null){
			pageBean.setCurrentPage(1);
		}
		//每页显示的信息条数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//总数据量(查询得到)
		int totalCount = customerDao.findCusCondition(customerModel);
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		//起始位置
		int begin = (pageBean.getCurrentPage() - 1)*pageSize;
		pageBean.setBegin(begin);
		//把参数放到map集合中
		//创建map
		Map map = new HashMap();
		map.put("pageBean", pageBean);
		map.put("customer", customerModel);
		//每页显示的数据
		List list = customerDao.findLikeMorePage(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List countLevel() {
		return customerDao.countLevel();
	}
}
