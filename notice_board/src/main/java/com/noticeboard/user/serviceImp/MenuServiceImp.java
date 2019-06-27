package com.noticeboard.user.serviceImp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.noticeboard.user.service.MenuService;
import com.noticeboard.user.service.MenuVO;

@Service("menuService")
public class MenuServiceImp implements MenuService {
	
	@Resource(name="menuMapper")
	MenuMapper menuMapper;
	
	@Override
	public List<MenuVO> selectMenuList(MenuVO menuVO) throws Exception {
		List<MenuVO> meunList = null;
		try{
			meunList = menuMapper.selectMenuList(menuVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return meunList;
	}

	@Override
	public HashMap<String, Object> insertMenu(MenuVO menuVO) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String menuCode = menuMapper.selectMaxMenuCd(menuVO);
			menuVO.setMenuCode(menuCode);
			int result = menuMapper.insertMenu(menuVO);
			resultMap.put("result", result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMap;
	}

}
