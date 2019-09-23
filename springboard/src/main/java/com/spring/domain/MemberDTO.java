package com.spring.domain;

public class MemberDTO {
	private int no;
	private String email;
	private String pwd;
	private String name;
	private String auth;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", email=" + email + ", pwd=" + pwd + ", name=" + name + ", auth=" + auth + "]";
	}
	
}
