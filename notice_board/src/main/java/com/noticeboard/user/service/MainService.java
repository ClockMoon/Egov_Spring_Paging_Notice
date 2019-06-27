package com.noticeboard.user.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MainService {

	List<EgovMap> selectNoticeList() throws Exception;

	EgovMap selectDetailNotice(String noticeId) throws Exception;

	void editNotice(String noticeId, NoticeVO noticeVO) throws Exception;

	void deleteNotice(String noticeId, NoticeVO noticeVO) throws Exception;

}
