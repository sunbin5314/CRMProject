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
	//���������û���json
	@RequestMapping("/allUserJson")
	public String allUserJson(HttpServletResponse response) throws IOException{
		//��ѯ�����û�
		List<User> ulist = visitService.findAllUser();
		//��list����ת����json
		String ujson = JSON.toJSONString(ulist);
		//����json����
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
	//չʾ���аݷü�¼
	@RequestMapping("/list")
	public String list(Model model){
		List<VisitModel> list = visitService.findAllVisit();
		model.addAttribute("list", list);
		return "visit/list";
	}
	//��ת���޸�ҳ��
	@RequestMapping("/toupdate")
	public String toupdate(VisitModel visitModel, Model model){
		VisitModel visit = visitService.findOne(visitModel);
		model.addAttribute("visit", visit);
		return "visit/edit";
	}
	//�޸İݷü�¼
	@RequestMapping("/updateVisit")
	public String updateVisit(VisitModel visitModel){
		visitService.updateVisit(visitModel);
		return "redirect:/visit/list.action";
	}
	
	//ɾ���ݷü�¼
	@RequestMapping("/deleteVisit")
	public String deleteVisit(VisitModel visitModel){
		visitService.deleteVisit(visitModel);
		return "redirect:/visit/list.action";
	}
}
