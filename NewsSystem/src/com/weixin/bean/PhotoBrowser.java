package com.weixin.bean;

public class PhotoBrowser {
	private  int id;
	private String title;
	private String image;
	private int news_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	@Override
	public String toString() {
		return "PhotoBrowser [id=" + id + ", title=" + title + ", image=" + image + ", news_id=" + news_id + "]";
	}
	
	
}
