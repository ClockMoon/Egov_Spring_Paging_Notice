<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/com/notice/cmmn/commonLib.jsp"%>
 <div id="secondMenuList">
	<c:choose>
		<c:when test="${fn:length(menuList) > 0}">
			<c:forEach var="menuList" items="${menuList }">
				<div>
					<div>${menuList.menuName}</div>
					<div>${menuList.useYesorno eq 'Y' ? '사용' : '사용안함'}
					</div>
					<div>${menuList.displayYesorno eq 'Y' ? '전시' : '전시안함'}</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div>
				<div>데이터가 없습니다.</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
