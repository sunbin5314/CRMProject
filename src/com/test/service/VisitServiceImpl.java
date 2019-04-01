package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.dao.UserDao;
import com.test.dao.VisitDao;
import com.test.domain.CustomerModel;
import com.test.domain.User;
import com.test.domain.VisitModel;

@Controller
public class VisitServiceImpl implements VisitService {
	@Autowired
	private VisitDao visitDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerService customerService ;
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
	@Override
	public List<CustomerModel> findAll() {
		return customerService.findAll();
	}
	@Override
	public void addVisit(VisitModel visitModel) {
		visitDao.addVisit(visitModel);
	}
	@Override
	public List<VisitModel> findAllVisit() {
		
		return visitDao.findAllVisit();
	}
	@Override
	public VisitModel findOne(VisitModel visitModel) {
		return visitDao.findOne(visitModel);
	}
	@Override
	public void updateVisit(VisitModel visitModel) {
		visitDao.updateVisit(visitModel);
	}
	@Override
	public void deleteVisit(VisitModel visitModel) {
		visitDao.deleteVisit(visitModel);
	}

	
}
