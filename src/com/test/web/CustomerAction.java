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
	//返回所有客户级别json数据
	@RequestMapping("/allLevelJson")
	public String allLevelJson(HttpServletResponse response) throws IOException{
		//使用fastjson
		//查询所有级别.返回list集合
		List<LeveModel> list = customerService.findAllLevel();
		//把返回list数据转换成json
		String json = JSON.toJSONString(list);
		//response返回
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}
	//第二种返回json的方法
	/*@RequestMapping("/test")
	public @ResponseBody List<LeveModel> getTest(){
		//查询所有级别返回list集合
		List<LeveModel> list = customerService.findAllLevel();
		return list;
	}
	*/
	//添加客户
	@RequestMapping("/addCustomer")
	public String addCusomer(MultipartFile file, CustomerModel customerModel, HttpServletRequest request) throws IllegalStateException, IOException{
		//通过request得到获取提交级别的id值
//		String lid = request.getParameter("lid");
//		LeveModel leveModel = new LeveModel();
//		leveModel.setLid(lid);
//		customerModel.setLeveModel(leveModel);
		//通过对象传递到mapper
		String cid = UUID.randomUUID().toString();
		customerModel.setCid(cid);
		//文件上传MultipartFile file
		//获取上传文件名称
		String filename = file.getOriginalFilename();
		filename = UUID.randomUUID().toString()+filename;
		//在服务器中创建文件夹,获取tomcat里面的upload路径
		//使用ServletContext getrealpath()
		//不建议使用
		//ServletContext context = request.getServletContext();
		String path = request.getSession().getServletContext().getRealPath("/upload");
		File servicefile = new File(path+"/"+filename);
		//如果文件夹不存在则创建
		if (!servicefile.exists()) {
			servicefile.mkdirs();
		}
		//4.复制文件
		file.transferTo(servicefile);
		customerService.addCustomer(customerModel);
		
		
		return "customer/success";
	}
	//客户列表不带分页
	@RequestMapping("/list")
	public String list(Model model){
		List<CustomerModel> list = customerService.findAll();
		model.addAttribute("list", list);
		return "customer/list";
	}
	//跳转到修改页面
	@RequestMapping("/toUpdatePage")
	public String toUpdatePage(CustomerModel customerModel,Model model){
		//根据id查询
		CustomerModel cus = customerService.findOne(customerModel);
		model.addAttribute("customer", cus);
		return "customer/edit";
	}
	//修改
	@RequestMapping("/update")
	public String update(CustomerModel customerModel){
		customerService.update(customerModel);
		return "redirect:/customer/list.action";
	}
	//删除
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String cid = request.getParameter("cid");
		customerService.delete(cid);
		return "redirect:/customer/list.action";
	}
	//条件查询带分页
	@RequestMapping("/cusMorePage")
	public String cusMorePage(PageBean<CustomerModel> pageBean, CustomerModel customerModel, Model model){
		PageBean page = customerService.cusMorePage(pageBean,customerModel);
		model.addAttribute("page", page);
		//System.out.println(page.getList());
		model.addAttribute("customer", customerModel);
		return "customer/listPage";
	}
	//统计每个客户级别数量
		@RequestMapping("/countLevel")
		public String countLevel(Model model){
			List list = customerService.countLevel();
			model.addAttribute("list", list);
			return "customer/countlist";
		}
}
