package com.weixin.bean;

import java.util.Date;

public class News {
	private int news_id;
	private String title;
	private String detail;
	private String image0;
	private String image1;
	private String image2;
	private Date createTime;
	private int type;
	private int tuijian;
	private int redian;
	private int taiyuan;
	private int shehui;
	private int dingyue;
	private int publisher_id;
	
	//============publisher表
	private String publisher_title;
	private String image;
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage0() {
		return image0;
	}
	public void setImage0(String image0) {
		this.image0 = image0;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTuijian() {
		return tuijian;
	}
	public void setTuijian(int tuijian) {
		this.tuijian = tuijian;
	}
	public int getRedian() {
		return redian;
	}
	public void setRedian(int redian) {
		this.redian = redian;
	}
	public int getTaiyuan() {
		return taiyuan;
	}
	public void setTaiyuan(int taiyuan) {
		this.taiyuan = taiyuan;
	}
	public int getShehui() {
		return shehui;
	}
	public void setShehui(int shehui) {
		this.shehui = shehui;
	}
	public int getDingyue() {
		return dingyue;
	}
	
	public void setDingyue(int dingyue) {
		this.dingyue = dingyue;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_title() {
		return publisher_title;
	}
	public void setPublisher_title(String publisher_title) {
		this.publisher_title = publisher_title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", title=" + title + ", detail=" + detail + ", image0=" + image0
				+ ", image1=" + image1 + ", image2=" + image2 + ", createTime=" + createTime + ", type=" + type
				+ ", tuijian=" + tuijian + ", redian=" + redian + ", taiyuan=" + taiyuan + ", shehui=" + shehui
				+ ", dingyue=" + dingyue + ", publisher_id=" + publisher_id + ", publisher_title=" + publisher_title
				+ ", image=" + image + "]";
	}
	
	
	
}
