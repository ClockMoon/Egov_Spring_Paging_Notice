<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="editContainer">
	<div class="middleSizeTitle">
		<span>${editNotice.noticeTitle }</span>
	</div>
	<form name="editForm" method="post" enctype="multipart/form-data">
		<div class="middleSizeText editInput">
			<span>글 내용</span>
		</div>
		<input type="text" value="${editNotice.noticeDescription }"
			placeholder="Description" class="smallSizeText"
			name="noticeDescription" />
		<div class="middleSizeText editInput">
			<span>글 타입</span>
		</div>
		<input type="text" value="${editNotice.noticeType }"
			placeholder="Type" class="smallSizeText"
			name="noticeType" />
		<div class="middleSizeText editInput">
			<span>파일 첨부</span> <label class="file-label"> 파일 첨부 <input
				type="file"
				name="noticeImageUrl">
			</label>
		</div>

		<div class="middleSizeText editInput">
			<span>비밀번호 입력</span>
		</div>
		<input type="password" placeholder="Password" name="noticePassword" required />
		<div id="editButtonContainer">
			<button class="editButton uploadButton" onclick="actionEditButton(${editNotice.noticeId})">수정</button>
			<button class="editButton uploadButton" onclick="actionDeleteButton(${editNotice.noticeId})">삭제</button>
		</div>
	</form>
</div>

