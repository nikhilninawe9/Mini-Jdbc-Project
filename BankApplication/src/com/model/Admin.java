package com.model;

public class Admin {
	private String adminName;
	private String adminUsername;
	private String adminPassword;

	public Admin() {
		super();
	}

	public Admin(String adminName, String adminUsername, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ "]";
	}

}
