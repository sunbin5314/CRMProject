package com.test.service;

import java.util.List;

import com.test.domain.CustomerModel;
import com.test.domain.LinkManModel;
import com.test.utils.PageBean;

public interface LinkmanService {

	List<CustomerModel> allCustomerJson();

	void addLink(LinkManModel linkManModel);

	List<LinkManModel> tolist();

	LinkManModel toupdate();

	LinkManModel toupdate(LinkManModel linkManModel);

	void updateMan(LinkManModel linkManModel);

	void deleteMan(LinkManModel linkManModel);

	PageBean pageMan(PageBean<LinkManModel> pageBean, LinkManModel linkManModel);

}
