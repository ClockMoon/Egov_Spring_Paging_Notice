var nowUrl = window.location.href.substring(0, window.location.href.length - 1);
var localUrl = "http://" + window.location.host;

function clickTitle(noticeId) {
	var url = localUrl + "/detailView.do?noticeId=" + noticeId;
	window.location.href = url;
}

function clickCreateNotice() {
	var url = localUrl + "/getCreateView.do";
	window.location.href = url;
}

function comeBackMain() {
	window.location.href = localUrl + "/getNoticeList.do";
}

function goEditNoticeView(noticeId) {
	window.location.href = localUrl + "/editNoticeView.do?noticeId=" + noticeId;
}

function getUrlParameter(parameter) {
	var results = new RegExp('[\?&amp;]' + parameter + '=([^&amp;#]*)')
			.exec(window.location.href);
	return results[1] || 0;
}

function preventDefaultEvent(event) {
	event.preventDefault();
}

function actionEditButton(noticeId) {
	document.editForm.action = "editNotice.do?noticeId=" + noticeId;
}

function actionDeleteButton(noticeId) {
	document.editForm.action = "deleteNotice.do?noticeId=" + noticeId;
}

function openModalPopWindow(
		popupID
		, popupTitle
		, popWidth
		, popHeight
		, isDraggable
		, isResizable
		, isCloseOnEscape
	)
{
var pWidth = (popWidth == null || popWidth == 0)? 950 : popWidth;
var pHeight = (popHeight == null || popHeight == 0)? 650 : popHeight;
var pDraggable = (isDraggable == null)? true : isDraggable;
var pResizable = (isCloseOnEscape == null)? false: isResizable;
var pCloseOnEscape = (isCloseOnEscape == null)? false: isCloseOnEscape;

if(popupID == null || popupID == "")
{
	alertMsg("popupID 정보를 설정하세요.(ScreenError)");
	return;
}
else if( popupTitle == null || popupTitle == "")
{
	alertMsg("popupTitle 정보를 설정하세요.(ScreenError)");
	return;
}
else
{
	$('#' + popupID).dialog({
		modal :true,
				autoOpen: false,
				title: popupTitle,
				width : pWidth,
				height: pHeight,
				draggable: pDraggable,
				resizable: pResizable,
				closeOnEscape: pCloseOnEscape

	}).dialog( "open" );
}
}

function closeModalPopWindow(popupID) {
	$('#' + popupID).dialog("close");
}