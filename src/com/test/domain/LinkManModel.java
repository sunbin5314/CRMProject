package com.test.domain;
/*
 联系人实体类
 * */
public class LinkManModel {
	private String lkmid;
	private String lkmName;
	private String lkmGender;
	private String lkmPhone;
	private String lkmMobile;
	private String cid;
	//联系人所属客户
	//多里面表示一
	private CustomerModel customerModel;
	public String getLkmid() {
		return lkmid;
	}
	public void setLkmid(String lkmid) {
		this.lkmid = lkmid;
	}
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public String getLkmGender() {
		return lkmGender;
	}
	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}
	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}
	public String getLkmMobile() {
		return lkmMobile;
	}
	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public CustomerModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	@Override
	public String toString() {
		return "LinkManModel [lkmid=" + lkmid + ", lkmName=" + lkmName
				+ ", lkmGender=" + lkmGender + ", lkmPhone=" + lkmPhone
				+ ", lkmMobile=" + lkmMobile + ", cid=" + cid
				+ ", customerModel=" + customerModel + "]";
	}
	
}
