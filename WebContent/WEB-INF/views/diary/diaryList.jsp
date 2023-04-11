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

@font-face {
	font-family: 'TTTtangsbudaejjigaeB';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/TTTtangsbudaejjigaeB.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}

#frame {
	max-width: 1000px;
	min-height: 300px;
	margin: 0 auto;
}

body {
	font-family: 'Pretendard-Regular';
}

.container {
	justify-content: center;
}

#showimg {
	width: 150px;
	height: 90px;
	border-radius: 15px;
}

h2 {
	font-family: 'TTTtangsbudaejjigaeB';
	font-size: 22px;
	margin-bottom: -60px;
	font-weight: bold;
	color: #3c3c3c;
	font-weight: bold;
}

.btngroup {
	float: right;
	padding-right: 30px;
	margin-bottom: 50px;
}

table {
	width: 90%;
	table-layout: fixed;
	border-radius: 16px;
	border-spacing: 1;
	border-collapse: collapse;
	background: white;
	overflow: hidden;
	text-align: center;
}

thead {
	height: 60px;
	background: #FFED86;
	font-size: 16px;
}

.num {
	width: 100px;
}
</style>

<div id="frame">
	<div class="container">

		<table class="table table-borderless">
			<thead>
				<tr>
					<th scope="col" class="num">넘버</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">사진</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr>
						<td>${e.dno }</td>
						<td><a href="diaryDetail?num=${e.dno}">${e.dtitle }</a></td>
						<td>${e.dwriter }</td>
						<td><img src="${path}/imgfile/${e.dimg }" id="showimg"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="btngroup">
		<a href="../diary/diaryForm"><button type="button" class="btn btn-secondary">글 작성</button></a>
	</div>
</div>

<br>
<br>
<br>