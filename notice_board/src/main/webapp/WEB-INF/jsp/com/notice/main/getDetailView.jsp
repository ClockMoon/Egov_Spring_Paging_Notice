<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	$.ajax({
		url : "ajaxSelectDetailView.do",
		type : "post",
		dataType : "html",
		data : {
			noticeId : getUrlParameter("noticeId")
		},
		success : function(html) {
			$("#detail-container").append(html);
		}
	})
</script>
<body>

	<detail>
	<div id="detail-container"></div>
	</detail>

</body>
</html>