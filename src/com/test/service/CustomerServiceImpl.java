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
	//��ѯ���пͻ���Ϣ
	@Override
	public List<CustomerModel> findAll() {
		
		return customerDao.findAll();
	}
	//����cid��ѯ
	@Override
	public CustomerModel findOne(CustomerModel customerModel) {
		return customerDao.findOne(customerModel);
	}
	//�޸�
	@Override
	public void update(CustomerModel customerModel) {
		customerDao.update(customerModel);
	}
	//����cidɾ������
	@Override
	public void delete(String cid) {
		customerDao.delete(cid);
	}
	//������ѯ����ҳ
	@Override
	public PageBean cusMorePage(PageBean<CustomerModel> pageBean,
			CustomerModel customerModel) {
		if(pageBean.getCurrentPage()==null){
			pageBean.setCurrentPage(1);
		}
		//ÿҳ��ʾ����Ϣ����
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��������(��ѯ�õ�)
		int totalCount = customerDao.findCusCondition(customerModel);
		pageBean.setTotalCount(totalCount);
		//��ҳ��
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		//��ʼλ��
		int begin = (pageBean.getCurrentPage() - 1)*pageSize;
		pageBean.setBegin(begin);
		//�Ѳ����ŵ�map������
		//����map
		Map map = new HashMap();
		map.put("pageBean", pageBean);
		map.put("customer", customerModel);
		//ÿҳ��ʾ������
		List list = customerDao.findLikeMorePage(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List countLevel() {
		return customerDao.countLevel();
	}
}
