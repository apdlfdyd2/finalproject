<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />

<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 120;
	font-style: normal;
}

html {
	display: grid;
	min-height: 100%;
}

body {
	display: grid;
	overflow: hidden;
	font-family: 'Pretendard-Regular';
	text-transform: uppercase;
	text-align: center;
}

#frame {
	max-width: 1000px;
	min-height: 300px;
	margin: 0 auto;
}


#container {
	position: relative;
	margin: auto;
	overflow: hidden;
	width: 700px;
	height: 50px;
}

#showimg {
	border-radius: 15px;
	margin-bottom: 20px;
}
</style>
<div id="frame">
	<img src="${path }/img/tour_logo1.png" id="showimg">
	<div>${sessionScope.sessionName}님이 쓰신 여행 일기가 삭제되었습니다!</div>

	<a href="../diary/diaryList?dwriter=${sessionScope.sessionID}"><button class="btn btn-primary">돌아가기</button></a>
</div>






