package com.test.web;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.domain.CustomerModel;
import com.test.domain.LinkManModel;
import com.test.service.LinkmanService;
import com.test.utils.PageBean;
@Controller
@RequestMapping("/linkman")
public class LinkManAction {
	@Autowired
	private LinkmanService linkmanService;
	//��ת�������ϵ��ҳ��
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "linkman/add";
	}
	//��ѯ���пͻ���ʾ��ajax
	@RequestMapping("/allCustomerJson")
	public @ResponseBody List<CustomerModel> allCustomerJson(){
		List<CustomerModel> list = linkmanService.allCustomerJson();
		return list;
	}
	
	//�����ϵ��
	@RequestMapping("/addLink")
	public String addLink(LinkManModel linkManModel, MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		String lkmid = UUID.randomUUID().toString();
		linkManModel.setLkmid(lkmid);
		
		//��ȡ�ļ�����
		String filename = file.getOriginalFilename();
		filename = UUID.randomUUID().toString()+filename;
		//�ڷ������д����ļ���,��ȡtomcat�����upload·��
		String path = request.getSession().getServletContext().getRealPath("/upload");
		File servicefiFile = new File(path+"/"+filename);
		//����ļ��в������򴴽�
		if (!servicefiFile.exists()) {
			servicefiFile.mkdirs();
		}
		file.transferTo(servicefiFile);
		linkmanService.addLink(linkManModel);
		return "customer/success";
	}
	//չʾ������ϵ���б�
	@RequestMapping("/tolist")
	public String tolist(Model model){
		List<LinkManModel> list = linkmanService.tolist();
		model.addAttribute("list", list);
		return "linkman/list";
	}
	//��ѯҪ�޸ĵ��û�
	@RequestMapping("/toupdate")
	public String toupdate(LinkManModel linkManModel,Model model){
		LinkManModel man = linkmanService.toupdate(linkManModel);
		//System.out.println(man);
		model.addAttribute("linkman", man);
		return "linkman/edit";
	}
	//�޸���ϵ����Ϣ
	@RequestMapping("/updateMan")
	public String updateMan(LinkManModel linkManModel){
		linkmanService.updateMan(linkManModel);
		return "redirect:/linkman/tolist.action";
	}
	//ɾ����ϵ��
	@RequestMapping("/deleteMan")
	public String deleteMan(LinkManModel linkManModel){
		linkmanService.deleteMan(linkManModel);
		return "redirect:/linkman/tolist.action";
	}
	//������ѯ����ҳ
	@RequestMapping("/pageMan")
	public String pageMan(PageBean<LinkManModel> pageBean, LinkManModel linkManModel,Model model){
		PageBean page = linkmanService.pageMan(pageBean, linkManModel);
		model.addAttribute("page", page);
		model.addAttribute("linkman", linkManModel);
		return "linkman/listPage";
	}
}
