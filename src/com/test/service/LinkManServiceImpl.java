package com.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.dao.LinkManDao;
import com.test.domain.CustomerModel;
import com.test.domain.LinkManModel;
import com.test.utils.PageBean;

@Controller
public class LinkManServiceImpl implements LinkmanService {
	@Autowired
	private LinkManDao linkManDao;

	@Override
	public List<CustomerModel> allCustomerJson() {
		return linkManDao.allCustomerJson();
	}
	//添加
	@Override
	public void addLink(LinkManModel linkManModel) {
		linkManDao.addLink(linkManModel);
	}
	//查找多有联系人
	@Override
	public List<LinkManModel> tolist() {
		return linkManDao.tolist();
	}
	@Override
	public LinkManModel toupdate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LinkManModel toupdate(LinkManModel linkManModel) {
		return linkManDao.toupdate(linkManModel);
	}
	@Override
	public void updateMan(LinkManModel linkManModel) {
		linkManDao.updateMan(linkManModel);
	}
	@Override
	public void deleteMan(LinkManModel linkManModel) {
		linkManDao.deleteMan(linkManModel);
	}
	@Override
	public PageBean pageMan(PageBean<LinkManModel> pageBean,
			LinkManModel linkManModel) {
		if (pageBean.getCurrentPage()==null) {
			pageBean.setCurrentPage(1);
		}
		//每页显示的信息数
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		//总数据量
		int totalCount = linkManDao.findLinkCondition(linkManModel);
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage = 0;
		if (totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		//开始位置
		int begin = (pageBean.getCurrentPage() - 1)*pageSize;
		pageBean.setBegin(begin);
		//每页显示的数据
		//把参数放到map集合
		//创建map集合
		Map map = new HashMap();
		map.put("pageBean", pageBean);
		map.put("linkman", linkManModel);
		List<LinkManModel> list = linkManDao.linkManMorePage(map);
		pageBean.setList(list);
		return pageBean;
	}
	
}
