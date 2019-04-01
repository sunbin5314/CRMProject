package com.test.domain;

public class CustomerModel {
	private String cid;
	private String cname;
	private String csource;
	private String cphone;
	private String caddress;
	private LeveModel leveModel;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsource() {
		return csource;
	}
	public void setCsource(String csource) {
		this.csource = csource;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public LeveModel getLeveModel() {
		return leveModel;
	}
	public void setLeveModel(LeveModel leveModel) {
		this.leveModel = leveModel;
	}
	
}
