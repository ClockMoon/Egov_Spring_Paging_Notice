package com.noticeboard.user.serviceImp;

import java.util.List;

import com.noticeboard.user.service.MenuVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("menuMapper")
public interface MenuMapper {

	List<MenuVO> selectMenuList(MenuVO menuVO);

	String selectMaxMenuCd(MenuVO menuVO);

	int insertMenu(MenuVO menuVO);
	
}
