package com.noticeboard.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticeboard.user.service.MenuService;
import com.noticeboard.user.service.MenuVO;

@Controller
public class MenuController {
	
	@Resource(name="menuService")
	MenuService menuService;
	
	@RequestMapping("/ajaxSelectMenuList.do")
	public String ajaxSelectMenuList (MenuVO menuVO, Model model) throws Exception {
		
		List<MenuVO> menuList = menuService.selectMenuList(menuVO);
		
			menuVO.setMenuLevel(1);
		
	      model.addAttribute("result", "SUCCESS");
	      model.addAttribute("menuList", menuList);
	      return "notice/menuList";
	}
}
