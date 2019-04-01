package com.test.domain;

public class VisitModel {
	private String visitid;
	private String visitaddress;
	private String visitContent;
	//private String isdelete;
	//所属用户
	private User user;
	//对面表示一,使用对象
	//拜访属于客户
	private CustomerModel customerModel;
	
//	public String getIsdelete() {
//		return isdelete;
//	}
//	public void setIsdelete(String isdelete) {
//		this.isdelete = isdelete;
//	}
	public String getVisitid() {
		return visitid;
	}
	public void setVisitid(String visitid) {
		this.visitid = visitid;
	}
	public String getVisitaddress() {
		return visitaddress;
	}
	public void setVisitaddress(String visitaddress) {
		this.visitaddress = visitaddress;
	}
	public String getVisitContent() {
		return visitContent;
	}
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CustomerModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	@Override
	public String toString() {
		return "VisitModel [visitid=" + visitid + ", visitaddress="
				+ visitaddress + ", visitContent=" + visitContent + ", user="
				+ user + ", customerModel=" + customerModel + "]";
	}
	
}
