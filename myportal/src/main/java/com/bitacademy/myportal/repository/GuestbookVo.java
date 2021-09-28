package com.bitacademy.myportal.repository;

import java.util.Date;

public class GuestbookVo {
	private Long no;	//	Primary Key
	private String name;
	private String password;
	private String content;	//	방명록
	private Date regDate;
	
	public GuestbookVo() {	//	POSO의 경우, 기본생성자가 반드시 있어야 한다.
		super();
	}
	
	//	삭제 정보 생성자
	public GuestbookVo(Long no, String password) {
		this.no = no;
		this.password = password;
		
	}
	
	//	작성 정보 생성자
	public GuestbookVo(String name, String password, String content) {
		this.name = name;
		this.password = password;
		this.content = content;
	}
	
	//	전체 생성자
	public GuestbookVo(Long no, String name, String password, String content, Date regDate) {
		this(name, password, content);
		this.regDate = regDate;
		this.no = no;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
}
