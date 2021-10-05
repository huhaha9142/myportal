package com.bitacademy.myportal.repository;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserVo {
	private Long no;	//	Primary Key
	@NotEmpty	//	비어 있으면 안된다
	@Length(min=2, max=8)
	private String name;	//	사용자 이름
	@NotEmpty
	@Email		//	형식이 Email인지 검증
	private	String email;	//	사용자 이메일
	@NotEmpty
	@Length(min=4, max=20)
	private String password;	//	로그인 비밀번호
	private String gender;	//	성별
	private Date createAt;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", createAt=" + createAt + "]";
	}
	
	
}
