<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/com/notice/cmmn/commonLib.jsp"%>
<script src="/js/common.js"></script>
<script>
function insertFirstMenuAction() {

	var useYesorno = $("input[type=radio][name=useYesorno]:checked").val();
	var displayYesno = $("input[type=radio][name=displayYesorno]:checked").val();

	var menu = {
			menuName 	: $("#menuName").val(),
			menuUrl : $("#menuUrl").val(),
			useYesorno 	: useYesorno,
			displayYesorno 	: displayYesno,
			sortSequences : $("#sortSeq").val(),
			menuLevel	: 1
	}
	
	console.log(menu);

	$.ajax({
		url			: "${pageContext.request.contextPath}/insertFirstMenu.do",
		type		: "post",
		data		: menu,
		//data		: $("#menuRegistForm").serialize(), // form을 객체로 전송
		beforeSend	: function() {
			$(".loading").show();
		},
		success		: function(data) {
			const SUCCESS = 1;
			if (data.resultMap.result === SUCCESS) {
				alert("정상적으로 등록되었습니다.");
				closeModalPopWindow("layerView");
				parent.menulist();
			} else {
				alert("오류가 발생하였습니다.관리자에게 문의 바랍니다.");
			}
		}
	});
}
</script>
<div id="LAYER_Frame">
	<h1>1차 메뉴 등록</h1>
	<div id="ContentsArea">
		<div class="con-area">
			<fieldset>
				<legend>LAYER_메뉴등록</legend>
				<hr>
				<div class="menuRegistContainer">
					<form id="menuRegistForm">
						<div>
							<div class="menuElementRegist" id="menuIdRegist">
								<div>
									<span>메뉴명</span>
								</div>
								<div>
									<input type="text" id="menuName" name="menuName" class="input_txt"
										style="width: 180px;" placeholder="메뉴 명" title="메뉴명"
										maxlength="10" />
								</div>
							</div>
							
							<div class="menuElementRegist" id="menuUrlRegist">
								<div>
									<span>메뉴 URL</span>
								</div>
								<div>
									<input type="text" name="menuUrl" id="menuUrl"
										style="width: 180px; ime-mode: disabled;" placeholder="메뉴 URL"
										title="메뉴 URL" maxlength="50" />
								</div>
							</div>
							
							<div class="menuElementRegist" id="menuUseRegist">
								<div>
									<span>사용 여부</span>
								</div>
								<div>
									<input type="radio" id="useYesorno" name="useYesorno" class="input_radio" title="YES" checked="checked" value="Y" />  사용
										<input type="radio" id="useYesorno" name="useYesorno" class="input_radio" title="NO" value="N" />사용 안함 
								</div>
							</div>
							
							<div class="menuElementRegist" id="menuDisplayRegist">
								<div>
									<span>전시 여부 </span>
								</div>
								<div>
									<input type="radio" id="displayYesorno" name="displayYesorno" class="input_radio"
										title="YES" checked="checked" value="Y" /> 사용 <input
										type="radio" id="displayYesorno" name="displayYesorno" class="input_radio"
										title="NO" value="N" /> 사용안함
								</div>
							</div>
							
							<div class="menuElementRegist" id="menuSortRegist">
								<div>
									<span>정렬순서</span>
								</div>
								<div>
									<input type="text" id="sortSeq" name="sortSeq"
										class="input_txt" style="width: 180px;" placeholder="정렬순서"
										title="정렬순서" maxlength="10" />
								</div>
							</div>
							
						</div>
					</form>
				</div>
			</fieldset>
		</div>
		<!--버튼_start-->
		<div class="txt-center pdt_25">
			<a class="btn-wine-14" href="javascript:void(0);"
				onclick="javascript:insertFirstMenuAction();">저장</a> <a
				class="btn-gray-14" href="javascript:void(0);"
				onclick="javascript:closeModalPopWindow('layerView');">닫기</a>
		</div>
		<!--버튼_end-->
		<hr />
	</div>
</div>