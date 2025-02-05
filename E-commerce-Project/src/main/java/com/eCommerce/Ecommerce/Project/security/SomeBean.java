//package com.eCommerce.Ecommerce.Project.security;
//
//import com.fasterxml.jackson.annotation.JsonFilter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
////@JsonIgnoreProperties("fiel2") // i ben dhe kjo ignore (kan te njejtin funksion te dyja)
//
//@JsonFilter(value = "SomeBeanFilter")
//public class SomeBean {
//	//@JsonIgnore // i ben ignore ksaj fushe qe mos te shfaqet ne api
//	private String fiel1;
//	private String fiel2;
//	private String fiel3;
//	public SomeBean(String fiel1, String fiel2, String fiel3) {
//		super();
//		this.fiel1 = fiel1;
//		this.fiel2 = fiel2;
//		this.fiel3 = fiel3;
//	}
//	@Override
//	public String toString() {
//		return "SomeBean [fiel1=" + fiel1 + ", fiel2=" + fiel2 + ", fiel3=" + fiel3 + "]";
//	}
//	public String getFiel1() {
//		return fiel1;
//	}
//	public void setFiel1(String fiel1) {
//		this.fiel1 = fiel1;
//	}
//	public String getFiel2() {
//		return fiel2;
//	}
//	public void setFiel2(String fiel2) {
//		this.fiel2 = fiel2;
//	}
//	public String getFiel3() {
//		return fiel3;
//	}
//	public void setFiel3(String fiel3) {
//		this.fiel3 = fiel3;
//	}
//	
//	
//
//}
