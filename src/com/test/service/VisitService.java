package com.test.service;

import java.util.List;

import com.test.domain.CustomerModel;
import com.test.domain.User;
import com.test.domain.VisitModel;

public interface VisitService {

	List<User> findAllUser();

	List<CustomerModel> findAll();

	void addVisit(VisitModel visitModel);

	List<VisitModel> findAllVisit();

	VisitModel findOne(VisitModel visitModel);

	void updateVisit(VisitModel visitModel);

	void deleteVisit(VisitModel visitModel);

	

}
