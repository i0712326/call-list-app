package com.lalco.call.app.entity;

import java.io.Serializable;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listNo;
	private String no;
	private String mainContact;
	private String scndContact;
	private String firstNameEn;
	private String lastNameEn;
	private String firstNameLa;
	private String lastNameLa;
	private String address1;
	private String address2;
	private String gender;
	private String maker;
	private String model;
	private String year;
	private float estimate;
	private String rank;
	public String getListNo() {
		return listNo;
	}
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMainContact() {
		return mainContact;
	}
	public void setMainContact(String mainContract) {
		this.mainContact = mainContract;
	}
	public String getScndContact() {
		return scndContact;
	}
	public void setScndContract(String secnContract) {
		this.scndContact = secnContract;
	}
	public String getFirstNameEn() {
		return firstNameEn;
	}
	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}
	public String getLastNameEn() {
		return lastNameEn;
	}
	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}
	public String getFirstNameLa() {
		return firstNameLa;
	}
	public void setFirstNameLa(String firstNameLa) {
		this.firstNameLa = firstNameLa;
	}
	public String getLastNameLa() {
		return lastNameLa;
	}
	public void setLastNameLa(String lastNameLa) {
		this.lastNameLa = lastNameLa;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String adrress2) {
		this.address2 = adrress2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public float getEstimate() {
		return estimate;
	}
	public void setEstimate(float estimate) {
		this.estimate = estimate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
