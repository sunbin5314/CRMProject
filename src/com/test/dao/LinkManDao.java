package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.domain.CustomerModel;
import com.test.domain.LinkManModel;

public interface LinkManDao {

	List<CustomerModel> allCustomerJson();

	void addLink(LinkManModel linkManModel);

	List<LinkManModel> tolist();

	LinkManModel toupdate(LinkManModel linkManModel);

	void updateMan(LinkManModel linkManModel);

	void deleteMan(LinkManModel linkManModel);

	int findLinkCondition(LinkManModel linkManModel);

	List<LinkManModel> linkManMorePage(Map map);

}
