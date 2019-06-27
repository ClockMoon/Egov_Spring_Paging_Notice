<script>
	var nowUrl = window.location.href.substring(0,
			window.location.href.length - 1);
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
		window.location.href = localUrl + "/editNoticeView.do?noticeId=" +noticeId;
	}

	function getUrlParameter(parameter) {
		var results = new RegExp('[\?&amp;]' + parameter + '=([^&amp;#]*)')
				.exec(window.location.href);
		return results[1] || 0;
	}
	
	function preventDefaultEvent(event){
		event.preventDefault();
	}
	
	function actionEditButton(noticeId){
		document.editForm.action="editNotice.do?noticeId="+noticeId;
	}
	
	function actionDeleteButton(noticeId){
		document.editForm.action="deleteNotice.do?noticeId="+noticeId;
	}
</script>