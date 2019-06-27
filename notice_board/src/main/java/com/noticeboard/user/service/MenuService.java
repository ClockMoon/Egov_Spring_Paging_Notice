package com.noticeboard.user.service;

import java.util.HashMap;
import java.util.List;

public interface MenuService {

	List<MenuVO> selectMenuList(MenuVO menuVO) throws Exception;

	HashMap<String, Object> insertMenu(MenuVO menuVO);

}
