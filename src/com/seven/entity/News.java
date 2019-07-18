package com.seven.entity;
import java.util.Date;

/*
 * 新闻 实体类
 * @author  
 */
public class News{
    private int newsId;
	private int themeId;
	private String newsTitle;
	private String newsAuthor;
	private String newsCreatedate;
	private String newsPicpath;
	private String newsContent;
	private String newsModifydate;
	private String newsSummary;

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public int getThemeId() {
		return themeId;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public void setNewsPicpath(String newsPicpath) {
		this.newsPicpath = newsPicpath;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}


	public void setNewsSummary(String newsSummary) {
		this.newsSummary = newsSummary;
	}

	public int getNewsId() {
		return newsId;
	}

	public String getNewsCreatedate() {
		return newsCreatedate;
	}

	public String getNewsModifydate() {
		return newsModifydate;
	}

	public void setNewsCreatedate(String newsCreatedate) {
		this.newsCreatedate = newsCreatedate;
	}

	public void setNewsModifydate(String newsModifydate) {
		this.newsModifydate = newsModifydate;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}


	public String getNewsPicpath() {
		return newsPicpath;
	}

	public String getNewsContent() {
		return newsContent;
	}


	public String getNewsSummary() {
		return newsSummary;
	}
}
