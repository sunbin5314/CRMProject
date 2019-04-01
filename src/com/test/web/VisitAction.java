package com.test.web;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.test.domain.CustomerModel;
import com.test.domain.User;
import com.test.domain.VisitModel;
import com.test.service.VisitService;

@Controller
@RequestMapping("/visit")
public class VisitAction {
	@Autowired
	private VisitService visitService;
	@RequestMapping("/toAdd")
	public String toAdd(Model model){
		allCustomerJson(model);
	return "visit/add";
	}
	//返回所有用户的json
	@RequestMapping("/allUserJson")
	public String allUserJson(HttpServletResponse response) throws IOException{
		//查询所有用户
		List<User> ulist = visitService.findAllUser();
		//把list集合转换成json
		String ujson = JSON.toJSONString(ulist);
		//返回json数据
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(ujson);
		return null;
	}
	@RequestMapping("/allCustomerJson")
	public String allCustomerJson(Model model){
		List<CustomerModel> cList = visitService.findAll();
//		for (CustomerModel customerModel : cList) {
//			System.out.println(customerModel);
//		}
		model.addAttribute("customerList", cList);
		return "visit/add"; 
	}
	@RequestMapping("/addVisit")
	public String addVisit(VisitModel visitModel){
		String visitid = UUID.randomUUID().toString();
		visitModel.setVisitid(visitid);
		visitService.addVisit(visitModel);
		return "customer/success";
	}
	//展示所有拜访记录
	@RequestMapping("/list")
	public String list(Model model){
		List<VisitModel> list = visitService.findAllVisit();
		model.addAttribute("list", list);
		return "visit/list";
	}
	//跳转到修改页面
	@RequestMapping("/toupdate")
	public String toupdate(VisitModel visitModel, Model model){
		VisitModel visit = visitService.findOne(visitModel);
		model.addAttribute("visit", visit);
		return "visit/edit";
	}
	//修改拜访记录
	@RequestMapping("/updateVisit")
	public String updateVisit(VisitModel visitModel){
		visitService.updateVisit(visitModel);
		return "redirect:/visit/list.action";
	}
	
	//删除拜访记录
	@RequestMapping("/deleteVisit")
	public String deleteVisit(VisitModel visitModel){
		visitService.deleteVisit(visitModel);
		return "redirect:/visit/list.action";
	}
}
