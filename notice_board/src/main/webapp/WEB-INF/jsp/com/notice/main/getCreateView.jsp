<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id="create-form-container">
	<form action="/createNotice.do" id="create-form" method="post" enctype="multipart/form-data">
		<div class="form-itmes">
			<input type="text" placeholder="Title" required name="noticeTitle"
				id="form-title">
		</div>
		<div class="form-itmes">
			<input type="text" placeholder="Description" required
				name="noticeDescription" id="form-description">
		</div>
		<div class="form-itmes">
			<input type="text" placeholder="Author" required name="registId"
				id="form-author">
		</div>
		<div class="form-itmes">
			<input type="password" placeholder="Password" required
				name="noticePassword" id="form-password">
		</div>
		<div class="form-itmes">
		<label for="form-image" class="file-label">
			 ImageUpload <input type="file" name="noticeImageUrl" id="form-image">
		 </label>
		
		</div>
		<div class="form-itmes">
			<input type="submit" value="Create" id="form-submit">
		</div>
	</form>
</div>
</html>