package com.noticeboard.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.noticeboard.user.service.MenuService;
import com.noticeboard.user.service.MenuVO;

@Controller
public class AdminController {
	
	@Resource(name = "jsonView")
	View ajaxJsonView;
	
	@Resource(name="menuService")
	MenuService menuService;
	
	@RequestMapping("/admin/manage.do")
	public String main(@ModelAttribute MenuVO menuVO, Model model) throws Exception {
		//권한 검증
		
		menuVO.setMenuLevel(1);
		menuVO.setAdmin(true);
		List<MenuVO> menuList = menuService.selectMenuList(menuVO);
		
		model.addAttribute("menuList",menuList);
		
		
		return "main/manage";
	}
	
	@RequestMapping(value = "/selectMenuList.do")
	public String selectMenuList(@ModelAttribute MenuVO menuVO, Model model) throws Exception {
		menuVO.setAdmin(true); //어드민으로 결정 vs 새로운 mapper 생성
		List<MenuVO> menuList = menuService.selectMenuList(menuVO);

		model.addAttribute("menuList", menuList);

		return "admin/menuLevelTwo";
	}
	
	@RequestMapping(value = "/layer/firstMenuRegist.do")
	public String menuFirstRegist() {
		return "admin/firstMenuRegist";
	}
	
	@RequestMapping(value = "/insertFirstMenu.do")
	public View insertFirstMenu(@ModelAttribute MenuVO menuVO, Model model) {

		HashMap<String, Object> resultMap = menuService.insertMenu(menuVO);

		model.addAttribute("resultMap", resultMap);

		return ajaxJsonView;
	}
}
