package org.iiiedu.eeit131.model;

public class CompanyBean {
	String companyId;
	String companyName;
	String phone;
	public CompanyBean(String companyId, String companyName, String phone) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.phone = phone;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CompanyBean [companyId=" + companyId + ", companyName=" + companyName + ", phone=" + phone + "]";
	}
	
}
