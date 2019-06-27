package com.noticeboard.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noticeboard.user.service.MainService;
import com.noticeboard.user.service.NoticeVO;
import com.noticeboard.user.service.UploadService;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class MainController {

	@Resource(name = "mainService")
	private MainService mainService;

	@Resource(name = "uploadService")
	private UploadService uploadService;

	@RequestMapping(value = "/getNoticeList.do")
	public String renderMain() {
		return "main/getNoticeList.tiles";
	}

	@RequestMapping(value = "/getCreateView.do")
	public String renderCreateView() {
		return "main/getCreateView.tiles";
	}

	@RequestMapping(value = "/detailView.do")
	public String renderDetailView() {
		return "main/getDetailView.tiles";
	}

	@RequestMapping(value = "/editNoticeView.do")
	public String rendereditNoticeView(@RequestParam("noticeId") String noticeId, Model model) throws Exception {
		EgovMap editNotice = mainService.selectDetailNotice(noticeId);
		model.addAttribute("editNotice", editNotice);
		return "main/getEditNoticeView.tiles";
	}

	@RequestMapping(value = "/createNotice.do")
	public String createNotice(@ModelAttribute NoticeVO noticeVO) {
		String url = uploadService.saveImage(noticeVO.getNoticeImageUrl());
		noticeVO.setNoticeImageUrlPath(url);
		Map<String, Object> requestData = uploadService.saveNoticeData(noticeVO);
		return "cmmn/uploadSuccess";
	}

	@RequestMapping(value = "/editNotice.do")
	public String editNotice(@RequestParam("noticeId") String noticeId, @ModelAttribute NoticeVO noticeVO)
			throws Exception {
		mainService.editNotice(noticeId, noticeVO);
		return "main/getDetailView.tiles";
	}

	@RequestMapping(value = "/deleteNotice.do")
	public String deleteNotice(@RequestParam("noticeId") String noticeId, @ModelAttribute NoticeVO noticeVO)
			throws Exception {
		mainService.deleteNotice(noticeId, noticeVO);
		return "main/getNoticeList.tiles";
	}

	@RequestMapping(value = "/ajaxSelectDetailView.do")
	public String ajaxSelectDetailView(@RequestParam("noticeId") String noticeId, Model model) throws Exception {
		EgovMap detailNotice = mainService.selectDetailNotice(noticeId);
		model.addAttribute("detailNotice", detailNotice);
		return "notice/detailNotice";
	}

//	@RequestMapping(value = "/ajaxSelectNoticeList.do")
//	public String selectNoticeList(Model model) throws Exception {
//		List<EgovMap> noticeList = mainService.selectNoticeList();
//		model.addAttribute("result", "SUCCESS");
//		model.addAttribute("noticeList", noticeList);
//		return "notice/noticeList";
//	}
}
