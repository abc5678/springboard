package com.spring.domain;

public class CommentDTO {
	
	private int cno;
	private int no;
	private int bno;
	private String comment;
	private String name;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", no=" + no + ", bno=" + bno + ", comment=" + comment + ", name=" + name
				+ "]";
	}

}
