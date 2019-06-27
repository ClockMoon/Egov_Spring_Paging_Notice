<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice_Board</title>
</head>
<script type="text/javascript">
	$.ajax({
		url : "ajaxSelectNoticeList.do?currentPageNumber=1",
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
	
</script>
<body>

	<contents>
	<div id="contents-container"></div>
	</contents>
	<customButton>
	<div id="create-button">
		<span onclick="clickCreateNotice()">생 성 하 기</span>
	</div>
	</customButton>
</body>
</html>