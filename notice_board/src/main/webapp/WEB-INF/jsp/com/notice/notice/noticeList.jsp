<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/com/notice/cmmn/commonLib.jsp"%>

<script type="text/javascript">
	var param = {
			useYesorno : "Y",
			menuName : "마이페이지"
		}
	
		$.ajax({
			url : "ajaxSelectMenuList.do",
			type : "post",
			dataType : "html",
			data : param,
			success : function(html) {
				console.log(html);
				$(".menuContainer").append(html);
			}
		})
	function pageHandler(targetPage) {
		var currentPageNumber = targetPage;
		$.ajax({
			url : "ajaxSelectNoticeList.do?currentPageNumber="+currentPageNumber,
			type : "post",
			dataType : "html",
			success : function(html) {
				
				$("#contents-container").html(html);
			},
			beforeSend : function() {
				
			},
			complete : function() {

			}
		})
	}

</script>

<nav>
	<div class="menuContainer"></div>
</nav>

<c:if test="${result eq 'SUCCESS' }">
	<c:forEach items="${noticeList}" var="noticeList">
		<div class="noticeListContainer">
			<div class="thumbnail-image">
				<img src="${noticeList.noticeImageUrl}" width="100" height="100">
			</div>
			<div class="noticeListTextContainer">
				<div class="notice-title"
					onclick="clickTitle(${noticeList.noticeId});">
					<span>${noticeList.noticeTitle}</span>
				</div>
				<div class="notice-Type">
					<span>${noticeList.noticeType}</span>
				</div>
				<div class="notice-info">
					<span>${noticeList.registId}/${noticeList.registDate}</span>
				</div>
			</div>
		</div>
	</c:forEach>


	<page class="hugeSizeText" id="pageContainer">
	<div>
		<c:if test="${page.previousArrow }">
			<a class="pageitems" style="text-decoration: none;"
				href="javascript:pageHandler(${page.getStartPageInBlock()-1});">&laquo;</a>
		</c:if>
		<c:forEach begin="${page.getStartPageInBlock()}"
			end="${page.getEndPageInBlock() }" var="page">
			<a class="pageitems" style="text-decoration: none;"
				href="javascript:pageHandler(${page});">${page}</a>
		</c:forEach>
		<c:if test="${page.nextArrow }">
			<a class="pageitems" style="text-decoration: none;"
				href="javascript:pageHandler(${page.getEndPageInBlock()+1 });">&raquo;</a>
		</c:if>
	</div>
	</page>

</c:if>