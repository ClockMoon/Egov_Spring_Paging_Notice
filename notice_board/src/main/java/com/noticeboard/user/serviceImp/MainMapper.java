package com.noticeboard.user.serviceImp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.noticeboard.user.service.NoticeVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("mainMapper")
public interface MainMapper {
	
	List<EgovMap> selectNoticeList();
	
	boolean uploadNotice(NoticeVO noticeVO);

	EgovMap selectDetailNoice(String noticeId);

	String getNoticePassword(String noticeId);

	void editNotice(@Param("targetNoticeId")String noticeId, @Param("updateNotice")NoticeVO noticeVO);

	void deleteNotice(String noticeId);

}