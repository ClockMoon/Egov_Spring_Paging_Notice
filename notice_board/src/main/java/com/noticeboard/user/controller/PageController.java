package com.noticeboard.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noticeboard.user.service.PageVO;
import com.noticeboard.user.serviceImp.PageMapper;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class PageController {

	@Resource(name = "pageMapper")
	private PageMapper pageMapper;

	@Resource(name = "pageVO")
	private PageVO pageVO;

	@RequestMapping(value = "/ajaxSelectNoticeList.do")
	public String getNoticeList(@RequestParam("currentPageNumber") String currentPageNumber, Model model) {
		int totalNoticeCount = pageMapper.getTotalNoticeCount();
		pageVO.setting(Integer.parseInt(currentPageNumber), totalNoticeCount);
		List<EgovMap> noticeList = new ArrayList<>();
		noticeList = pageMapper.getNoticeList(pageVO.getCurrentPageNumber() * pageVO.getNoticeCountInAPage());
		model.addAttribute("result", "SUCCESS");
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("page", pageVO);
		return "notice/noticeList";
	}
}
