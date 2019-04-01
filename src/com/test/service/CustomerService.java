package com.test.service;

import java.util.List;

import com.test.domain.CustomerModel;
import com.test.domain.LeveModel;
import com.test.utils.PageBean;

public interface CustomerService {

	List<LeveModel> findAllLevel();

	void addCustomer(CustomerModel customerModel);

	List<CustomerModel> findAll();

	CustomerModel findOne(CustomerModel customerModel);

	void update(CustomerModel customerModel);

	void delete(String cid);

	PageBean cusMorePage(PageBean<CustomerModel> pageBean,
			CustomerModel customerModel);

	List countLevel();


}
