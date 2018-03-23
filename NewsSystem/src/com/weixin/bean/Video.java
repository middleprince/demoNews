package com.weixin.bean;

public class Video {
	private int video_id;
	private String title;
	private String path;
	private String imagePath;
	private String publisher_id;
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(String publisher_id) {
		this.publisher_id = publisher_id;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", title=" + title + ", path=" + path + ", imagePath=" + imagePath
				+ ", publisher_id=" + publisher_id + "]";
	}
	
}
