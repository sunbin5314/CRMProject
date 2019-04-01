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
	//���
	@Override
	public void addLink(LinkManModel linkManModel) {
		linkManDao.addLink(linkManModel);
	}
	//���Ҷ�����ϵ��
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
		//ÿҳ��ʾ����Ϣ��
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		//��������
		int totalCount = linkManDao.findLinkCondition(linkManModel);
		pageBean.setTotalCount(totalCount);
		//��ҳ��
		int totalPage = 0;
		if (totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		//��ʼλ��
		int begin = (pageBean.getCurrentPage() - 1)*pageSize;
		pageBean.setBegin(begin);
		//ÿҳ��ʾ������
		//�Ѳ����ŵ�map����
		//����map����
		Map map = new HashMap();
		map.put("pageBean", pageBean);
		map.put("linkman", linkManModel);
		List<LinkManModel> list = linkManDao.linkManMorePage(map);
		pageBean.setList(list);
		return pageBean;
	}
	
}
