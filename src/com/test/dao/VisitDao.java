package com.test.dao;

import java.util.List;

import com.test.domain.User;
import com.test.domain.VisitModel;

public interface VisitDao {

	List<User> findAllUser();

	void addVisit(VisitModel visitModel);

	List<VisitModel> findAllVisit();

	VisitModel findOne(VisitModel visitModel);

	void updateVisit(VisitModel visitModel);

	void deleteVisit(VisitModel visitModel);

}
