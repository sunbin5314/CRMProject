package com.test.domain;

import java.util.HashSet;
import java.util.Set;

public class LeveModel {
	
	
	private String lid;
	private String lname;
	/*
	 һ����������ж������
	 ˼��:��һ�������ʾ��,ʹ�ü��ϱ�ʾ
	 * */
//	private Set<CustumerModel> set = new HashSet<CustumerModel>();
//	
//	public Set<CustumerModel> getSet() {
//		return set;
//	}
//	public void setSet(Set<CustumerModel> set) {
//		this.set = set;
//	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "LeveModel [lid=" + lid + ", lname=" + lname + "]";
	}
	
}
