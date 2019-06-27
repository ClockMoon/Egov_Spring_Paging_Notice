package com.noticeboard.user.service;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	private String noticeTitle;
	private String noticeDescription;
	private String noticeType;
	private MultipartFile noticeImageUrl;
	private String displayState;
	private String registId;
	private String registDate;
	private String noticePassword;
	private String modifyDate;
	private String noticeImageUrlPath;
	
	public String getNoticeImageUrlPath() {
		return noticeImageUrlPath;
	}
	public void setNoticeImageUrlPath(String noticeImageUrlPath) {
		this.noticeImageUrlPath = noticeImageUrlPath;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeDescription() {
		return noticeDescription;
	}
	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public MultipartFile getNoticeImageUrl() {
		return noticeImageUrl;
	} 	
	public void setNoticeImageUrl(MultipartFile noticeImageUrl) {
		this.noticeImageUrl = noticeImageUrl;
	}
	public String getDisplayState() {
		return displayState;
	}
	public void setDisplayState(String displayState) {
		this.displayState = displayState;
	}
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getNoticePassword() {
		return noticePassword;
	}
	public void setNoticePassword(String noticePassword) {
		this.noticePassword = noticePassword;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
}
