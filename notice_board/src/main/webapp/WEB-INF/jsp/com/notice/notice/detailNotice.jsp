<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="detailContainer">
	<div id="detailHeader">
		<span class="middleSizeTitle">${detailNotice.noticeTitle}</span>
		<p />
		<span class="middleSizeText">작성자 : ${detailNotice.registId}</span>
		<hr class="largeLine" />
		<div id="detailDateContainer">
			<span class="middleSizeText">최근 수정일 :
				${detailNotice.modifyDate }</span>
			<p />
			<span class="middleSizeText">분류 : ${detailNotice.noticeType}</span>
		</div>
	</div>
	<div id="detailImage">
		<img src="${detailNotice.noticeImageUrl}">
	</div>

	<div id="detailDescription">
		<span class="smallSizeText">${detailNotice.noticeDescription}</span>
	</div>

	<div id="editButtonContainer">
		<div class="editButton" onclick="goEditNoticeView(${detailNotice.noticeId});")>
			<span class="middleSizeText">수정</span>
		</div>
	</div>
</div>