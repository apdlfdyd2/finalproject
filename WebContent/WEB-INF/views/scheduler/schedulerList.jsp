<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/myPageUI.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/buttonEff.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/myPageRankHover.css" rel="stylesheet" />

<style>
.center {
	text-align: center;
}

table {
	border-collapse: collapse;
	width: 70%;
	text-align: center;
}

</style>

<!-- ================================================== -->
<div class="wrap" style="max-width: 1000px; margin: 0 auto;">
	<div class="pinkContainer">
		<div>
			<div class="grade">
				<figure>
					<img src="${path}/rankimg/boltstone.png" height="40px" width="45px" id="gradeimg">
				</figure>
			</div>
			<div class="green name">${sessionScope.sessionName}님의스케줄러 리스트</div>

		</div>
	</div>
	<div class="modify"></div>
	<!-- ================================================== -->
	<div class="shippingStatusContainer">
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>내용</th>
						<th>등록일자</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="e" items="${list }">
						<tr>
							<td>${e.scno}</td>
							<td>${e.sclist }</td>
							<td>${e.scdate }</td>

						</tr>
					</c:forEach>
				</tbody>
				
			</table>

	</div>
</div>

<br>

