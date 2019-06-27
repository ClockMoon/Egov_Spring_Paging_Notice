<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/com/notice/cmmn/commonLib.jsp"%>
<c:if test="${result eq 'SUCCESS' }">
	<c:forEach items="${menuList}" var="levelOneList">
	
		<c:choose>
			<c:when
				test="${(levelOneList.menuLevel eq 1) and (not empty levelOneList.menuUrl)}">
				
					<ul class="mainMenu">
						<li><a href="<c:url value="${levelOneList.menuUrl }"  />" class="smallSizeText">
								<c:out value="${levelOneList.menuName }" />
						</a></li>
					</ul>
			</c:when>
			<c:otherwise>
				<c:if test="${levelOneList.menuLevel eq 1}">
						<ul class="mainMenu">
							<li>
							<a class="smallSizeText"> 
								<c:out
										value="${levelOneList.menuName }" /> <span class="caret"></span>
							</a>
								<ul class="subMenu">
									<c:forEach items="${menuList}" var="levelTwoList">
										<c:if
											test="${(levelOneList.menuCode eq levelTwoList.upperMenuCode) and (levelTwoList.menuLevel eq 2)}">
											<li><a href="<c:url value="${levelTwoList.menuUrl }" /> " class="smallSizeText">
													<c:out value="${levelTwoList.menuName }" />
											</a></li>
										</c:if>
									</c:forEach>
								</ul></li>
						</ul>
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:if>