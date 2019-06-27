<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/com/notice/cmmn/commonLib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/com/util/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- 타일즈를 벗어나면 다시 import 해줘야 하나? -->
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="/css/com/main.css">
<script src="/js/common.js"></script>
<title>관리자</title>

<script>

	function getSecondMenuList(upperMenuCode, menuLevel) {
		var parameter = {
			upperMenuCode : upperMenuCode,
			menuLevel : menuLevel
		}

		$.ajax({
			url : "${pageContext.request.contextPath}/selectMenuList.do",
			type : "post",
			dataType : "html",
			data : parameter,
			success : function(html) {
				$("#secondMenuList").empty(html);
				$("#secondMenuList").append(html);
			}
		})
	}

	function menuRegistView(url, menuName) {

		var param = {
			upperMenuCode : $("#upperMenuCd").val(),
			menuLevel : $("#menuLevel").val()
		}

		$.ajax({
			url : "${pageContext.request.contextPath}/layer/" + url,
			type : "post",
			data : param,
			dataType : "html",
			success : function(html) {
				$('#layerView').empty();
				$(html).appendTo('#layerView');
				openModalPopWindow("layerView", menuName, 550, 520, true,
						false, true);
			}
		});
	}
</script>

</head>

<body>
	<form id="form" name="form">
		<input type="hidden" id="upperMenuCd" value="" /> <input
			type="hidden" id="menuLevel" value="" />
	</form>

	<div id="layerView"></div>

	<header id="header"> 관리자 화면 </header>
	<div id="menuSettingContainer">
		<div id="firstMenuList">
			<div>
				<span><a
					href="javascript:menuRegistView('firstMenuRegist.do', '1차 메뉴 등록');">메뉴
						생성</a></span>
			</div>
			<c:choose>
				<c:when test="${fn:length(menuList) > 0}">
					<c:forEach var="menuList" items="${menuList}" varStatus="status">
						<div onclick="getSecondMenuList('${menuList.menuCode}',2)">
							<div class="txt-center">${menuList.menuName}</div>
							<div class="txt-center">${menuList.useYesorno eq 'Y' ? '사용' : '사용안함'}
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

		<div id="secondMenuList"></div>

	</div>
</body>
</html>