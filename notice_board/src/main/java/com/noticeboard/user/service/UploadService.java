package com.noticeboard.user.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	String saveImage(MultipartFile noticeImageUrl);

	Map<String, Object> saveNoticeData(NoticeVO noticeVO);
	
}
