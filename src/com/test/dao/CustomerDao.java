package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.domain.CustomerModel;
import com.test.domain.LeveModel;

public interface CustomerDao {

	List<LeveModel> findAllLevel();

	void addCustomer(CustomerModel customerModel);

	List<CustomerModel> findAll();

	CustomerModel findOne(CustomerModel customerModel);

	void update(CustomerModel customerModel);

	void delete(String cid);

	int findCusCondition(CustomerModel customerModel);

	List findLikeMorePage(Map map);

	List countLevel();

}
