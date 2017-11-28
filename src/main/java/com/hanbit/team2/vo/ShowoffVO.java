package com.hanbit.team2.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ShowoffVO {

	private int no;
	private String nickname;
	private String password;
	private String title;
	private String cont;
	private List<String> fileimg;
	private int dateDT;


	public int getdateDT() {
		return dateDT;
	}
	public void setdateDT(int dateDT) {
		this.dateDT = dateDT;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public List<String> getFileimg() {
		return fileimg;
	}
	public void setFileimg(List<String> image) {
		this.fileimg = image;
	}

}
