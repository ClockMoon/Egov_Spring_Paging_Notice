package com.noticeboard.user.serviceImp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noticeboard.user.service.NoticeVO;
import com.noticeboard.user.service.UploadService;

import egovframework.rte.fdl.property.EgovPropertyService;

@Service("uploadService")
public class UploadServiceImp implements UploadService {
	
	@Resource(name = "mainMapper")
	MainMapper mainMapper;
	
//	@Resource(name="propertyService")
//	EgovPropertyService propertyService ;
	
	private static final Logger logger = LoggerFactory.getLogger(UploadService.class); // 따로 빼줄 수 없나?
	private static final String UPLOAD_PATH = "D:\\Moon\\EgovExercise\\workspace\\notice_board\\src\\main\\webapp\\images\\com";
	private static final String SERVER_PATH = "D:\\Moon\\EgovExercise\\workspace\\notice_board\\src\\main\\webapp\\";
	
	public String saveImage(MultipartFile noticeImageUrl) {
		return UPLOAD_PATH.substring(SERVER_PATH.length())+"\\"+ saveFile(noticeImageUrl);
	}

	private String saveFile(MultipartFile noticeImageUrl) {
		UUID uuid = UUID.randomUUID();
		String saveName = uuid + "_" + noticeImageUrl.getOriginalFilename();
		logger.info("saveName: {}", saveName);
		File saveFile = new File(UPLOAD_PATH, saveName);
		try {
			noticeImageUrl.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return saveName;
	}
	
	private void printLogger(MultipartFile noticeImageUrl){
		logger.info("업로드 호출");
		logger.info("파일 이름: {}", noticeImageUrl.getOriginalFilename());
		logger.info("파일 크기: {}", noticeImageUrl.getSize());
	}

	@Override
	public Map<String, Object> saveNoticeData(NoticeVO noticeVO) {
		Map<String, Object> resultRequest = new HashMap<String,Object>();
		try{
			boolean result = mainMapper.uploadNotice(noticeVO);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
