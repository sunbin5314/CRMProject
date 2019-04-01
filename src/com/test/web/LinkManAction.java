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
	//跳转到添加联系人页面
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "linkman/add";
	}
	//查询所有客户显示到ajax
	@RequestMapping("/allCustomerJson")
	public @ResponseBody List<CustomerModel> allCustomerJson(){
		List<CustomerModel> list = linkmanService.allCustomerJson();
		return list;
	}
	
	//添加联系人
	@RequestMapping("/addLink")
	public String addLink(LinkManModel linkManModel, MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		String lkmid = UUID.randomUUID().toString();
		linkManModel.setLkmid(lkmid);
		
		//获取文件名称
		String filename = file.getOriginalFilename();
		filename = UUID.randomUUID().toString()+filename;
		//在服务器中创建文件夹,获取tomcat里面的upload路径
		String path = request.getSession().getServletContext().getRealPath("/upload");
		File servicefiFile = new File(path+"/"+filename);
		//如果文件夹不存在则创建
		if (!servicefiFile.exists()) {
			servicefiFile.mkdirs();
		}
		file.transferTo(servicefiFile);
		linkmanService.addLink(linkManModel);
		return "customer/success";
	}
	//展示所有联系人列表
	@RequestMapping("/tolist")
	public String tolist(Model model){
		List<LinkManModel> list = linkmanService.tolist();
		model.addAttribute("list", list);
		return "linkman/list";
	}
	//查询要修改的用户
	@RequestMapping("/toupdate")
	public String toupdate(LinkManModel linkManModel,Model model){
		LinkManModel man = linkmanService.toupdate(linkManModel);
		//System.out.println(man);
		model.addAttribute("linkman", man);
		return "linkman/edit";
	}
	//修改联系人信息
	@RequestMapping("/updateMan")
	public String updateMan(LinkManModel linkManModel){
		linkmanService.updateMan(linkManModel);
		return "redirect:/linkman/tolist.action";
	}
	//删除联系人
	@RequestMapping("/deleteMan")
	public String deleteMan(LinkManModel linkManModel){
		linkmanService.deleteMan(linkManModel);
		return "redirect:/linkman/tolist.action";
	}
	//条件查询带分页
	@RequestMapping("/pageMan")
	public String pageMan(PageBean<LinkManModel> pageBean, LinkManModel linkManModel,Model model){
		PageBean page = linkmanService.pageMan(pageBean, linkManModel);
		model.addAttribute("page", page);
		model.addAttribute("linkman", linkManModel);
		return "linkman/listPage";
	}
}
