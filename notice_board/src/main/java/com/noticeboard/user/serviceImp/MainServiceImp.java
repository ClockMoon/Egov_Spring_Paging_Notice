package com.noticeboard.user.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.noticeboard.user.service.MainService;
import com.noticeboard.user.service.NoticeVO;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("mainService")
public class MainServiceImp implements MainService {

	@Resource(name = "mainMapper")
	private MainMapper mainMapper;

	public List<EgovMap> selectNoticeList() throws Exception {
		List<EgovMap> noticeList = new ArrayList<EgovMap>();
		try {
			noticeList = mainMapper.selectNoticeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public EgovMap selectDetailNotice(String noticeId) throws Exception {
		EgovMap resultNotice = null;
		try {
			resultNotice = mainMapper.selectDetailNoice(noticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultNotice;
	}

	@Override
	public void editNotice(String noticeId, NoticeVO noticeVO) throws Exception {
		try {
			checkPasswordVaildation(noticeId, noticeVO);
			mainMapper.editNotice(noticeId, noticeVO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@Override
	public void deleteNotice(String noticeId, NoticeVO noticeVO) throws Exception {
		try {
			checkPasswordVaildation(noticeId, noticeVO);
			mainMapper.deleteNotice(noticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void checkPasswordVaildation(String noticeId, NoticeVO noticeVO) throws Exception {
		String targetPassword = mainMapper.getNoticePassword(noticeId);
		if (checkEqualsPassword(noticeVO.getNoticePassword(), targetPassword)) {
			throw new Exception();
		}
	}

	private boolean checkEqualsPassword(String noticeVOPassword, String targetPassword) {
		return !targetPassword.equals(noticeVOPassword);
	}

}
