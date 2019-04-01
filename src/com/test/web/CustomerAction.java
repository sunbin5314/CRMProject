package com.test.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.test.domain.CustomerModel;
import com.test.domain.LeveModel;
import com.test.service.CustomerService;
import com.test.utils.PageBean;

@Controller
@RequestMapping("/customer")
public class CustomerAction {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/toAddPage")
	public String toAddPage(){
		return "customer/add";
	}
	//�������пͻ�����json����
	@RequestMapping("/allLevelJson")
	public String allLevelJson(HttpServletResponse response) throws IOException{
		//ʹ��fastjson
		//��ѯ���м���.����list����
		List<LeveModel> list = customerService.findAllLevel();
		//�ѷ���list����ת����json
		String json = JSON.toJSONString(list);
		//response����
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}
	//�ڶ��ַ���json�ķ���
	/*@RequestMapping("/test")
	public @ResponseBody List<LeveModel> getTest(){
		//��ѯ���м��𷵻�list����
		List<LeveModel> list = customerService.findAllLevel();
		return list;
	}
	*/
	//��ӿͻ�
	@RequestMapping("/addCustomer")
	public String addCusomer(MultipartFile file, CustomerModel customerModel, HttpServletRequest request) throws IllegalStateException, IOException{
		//ͨ��request�õ���ȡ�ύ�����idֵ
//		String lid = request.getParameter("lid");
//		LeveModel leveModel = new LeveModel();
//		leveModel.setLid(lid);
//		customerModel.setLeveModel(leveModel);
		//ͨ�����󴫵ݵ�mapper
		String cid = UUID.randomUUID().toString();
		customerModel.setCid(cid);
		//�ļ��ϴ�MultipartFile file
		//��ȡ�ϴ��ļ�����
		String filename = file.getOriginalFilename();
		filename = UUID.randomUUID().toString()+filename;
		//�ڷ������д����ļ���,��ȡtomcat�����upload·��
		//ʹ��ServletContext getrealpath()
		//������ʹ��
		//ServletContext context = request.getServletContext();
		String path = request.getSession().getServletContext().getRealPath("/upload");
		File servicefile = new File(path+"/"+filename);
		//����ļ��в������򴴽�
		if (!servicefile.exists()) {
			servicefile.mkdirs();
		}
		//4.�����ļ�
		file.transferTo(servicefile);
		customerService.addCustomer(customerModel);
		
		
		return "customer/success";
	}
	//�ͻ��б�����ҳ
	@RequestMapping("/list")
	public String list(Model model){
		List<CustomerModel> list = customerService.findAll();
		model.addAttribute("list", list);
		return "customer/list";
	}
	//��ת���޸�ҳ��
	@RequestMapping("/toUpdatePage")
	public String toUpdatePage(CustomerModel customerModel,Model model){
		//����id��ѯ
		CustomerModel cus = customerService.findOne(customerModel);
		model.addAttribute("customer", cus);
		return "customer/edit";
	}
	//�޸�
	@RequestMapping("/update")
	public String update(CustomerModel customerModel){
		customerService.update(customerModel);
		return "redirect:/customer/list.action";
	}
	//ɾ��
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String cid = request.getParameter("cid");
		customerService.delete(cid);
		return "redirect:/customer/list.action";
	}
	//������ѯ����ҳ
	@RequestMapping("/cusMorePage")
	public String cusMorePage(PageBean<CustomerModel> pageBean, CustomerModel customerModel, Model model){
		PageBean page = customerService.cusMorePage(pageBean,customerModel);
		model.addAttribute("page", page);
		//System.out.println(page.getList());
		model.addAttribute("customer", customerModel);
		return "customer/listPage";
	}
	//ͳ��ÿ���ͻ���������
		@RequestMapping("/countLevel")
		public String countLevel(Model model){
			List list = customerService.countLevel();
			model.addAttribute("list", list);
			return "customer/countlist";
		}
}
