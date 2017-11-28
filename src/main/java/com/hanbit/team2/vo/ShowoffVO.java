package com.hanbit.team2.vo;

import org.springframework.web.multipart.MultipartFile;

public class ShowoffVO {

	private int no;
	private String nickname;
	private String pw;
	private String title;
	private String cont;
	private MultipartFile fileimg;
	private int date;


	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public MultipartFile getFileimg() {
		return fileimg;
	}
	public void setFileimg(MultipartFile image) {
		this.fileimg = image;
	}

}
