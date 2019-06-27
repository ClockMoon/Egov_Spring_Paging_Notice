package com.noticeboard.user.serviceImp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("pageMapper")
public interface PageMapper {
	
	public List<EgovMap> getNoticeList(@Param("currentPageNumber") int currentPageNumber);

	public int getTotalNoticeCount();

}
