<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />

<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 500;
	font-style: normal;
}

@font-face {
	font-family: 'TTTtangsbudaejjigaeB';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/TTTtangsbudaejjigaeB.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}

body {
	font-family: 'Pretendard-Regular';
}

.container {
	width: 750px;
	padding: 30px 35px 35px;
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
	margin-bottom: 50px;
}

.container.disable .editor-panel, .container.disable .btnspace .reset-filter,
	.container.disable .btnspace .save-img {
	pointer-events: none;
}

.container h2 {
	font-family: 'TTTtangsbudaejjigaeB';
	margin-top: -10px;
	font-size: 22px;
	font-weight: bold;
	color: #3c3c3c;
}

.container .wrapper {
	display: flex;
	margin: 20px auto;
	min-height: 80px;
}

.options, .btnspace {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

button {
	margin-right: 10px;
}


#showimg {
	border-radius: 15px;
	width: 290px;
	height: 240px;
	box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.1);
}

.table {
	width: 500px;
	margin: 35px auto;
}
</style>



<div class="container">
	<h2>나만의 여행 다이어리</h2>
	<table class="table">
		<tbody>
			<tr>
				<th>제목</th>
				<td>${vo.dtitle }</td>
			</tr>

			<tr>
				<th>이미지</th>
				<td><img src="${path}/imgfile/${vo.dimg }" id="showimg"></td>
			</tr>

			<tr>
				<th>내용</th>
				<td>${vo.dcontent }</td>
			</tr>

			<tr>
				<th>해시태그</th>
				<td>${vo.dtag }</td>
			</tr>


		</tbody>

	</table>


		<div class="btnspace">
			<a href="../diary/updatePath?num=${vo.dno }"><button class="btn btn-primary">수정하기</button></a>
			<a href="../diary/deleteDiary?num=${vo.dno }"><button class="btn btn-secondary">삭제하기</button></a>
		</div>


</div>
