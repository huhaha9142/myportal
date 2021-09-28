package com.bitacademy.myportal.repository;

import java.util.Date;

public class BoardVo {
	private Long no;	//	PK
	private String title;
	private String content;
	private Long hit;	//	조회수
	private Date regDate;
	private Long userNo;	//	User테이블의 PK (Foreign Key)
	private String userName;
	
	public BoardVo() {
		
	}
	
	public BoardVo(String title, String content, Long userNo) {
		this.title = title;
		this.content = content;
		this.userNo = userNo;
		
	}
	
	//	전체 생성자
	public BoardVo(Long no, String title, Long hit, Date regDate, Long userNo, String userName) {
		this.no = no;
		this.title = title;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}
	
	//	전체 생성자
	public BoardVo(Long no, String title, String content, Long hit, 
			Date regDate, Long userNo, String userName) {
		this(no, title, hit, regDate, userNo, userName);
		this.content = content;
		
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
				+ regDate + ", userNo=" + userNo + ", userName=" + userName + "]";
	}
	
	
	
}
