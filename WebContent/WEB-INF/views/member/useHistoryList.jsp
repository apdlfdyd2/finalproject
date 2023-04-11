<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<style>
.center {
	text-align: center;
}

th {
	background-color: aliceblue;
}

h3 {
	color: #6495ed;
}

table {
	border-collapse: collapse;
	width: 70%;
}
</style>

<!-- ================================================== -->

<div>
	<h3 align="center">${sessionScope.sessionName}님의 예약 내역</h3>
	<table border="1" align="center" class="center">
		<tr>
			<th>번호</th>
			<th>예약 일시</th>
			<th>여행 일시</th>
			<th>여행 지역</th>
			<th>이용 숙소</th>
			<th>사 진</th>
			<th>결제 방법</th>
			<th>결제 금액</th>
			<th>변경</th>
		</tr>
		<c:forEach var="e" items="${blist }">
			<c:set var="index" value="${index + 1}" />
			<tr>
				<td>${index}</td>
				<td>${e.bdate }</td>
				<td>${e.sdate }~${e.edate }</td>
				<td>${e.local.larea }</td>
				<td>${e.local.ltitle }</td>
				<td><img src="${path}/imgfile/${e.local.limg }" height="100"
					width="200"></td>
				<td>${e.charge.chtype }</td>
				<td><fmt:formatNumber value="${e.charge.chpay }" pattern="###,###" /></td>
				<td><a href="${ctrpath}/book/bookUpdateForm?bid=${e.bid }"><button
							type="button" class="btn btn-primary item upBtn"
							value="${e.bid }">예약 수정</button></a> <a
					href="${ctrpath}/book/delBook?bid=${e.bid }&mid=${sessionScope.sessionNum}"><button
							type="button" class="btn btn-primary item delBtn"
							value="${e.bid }">예약 취소</button></a> 
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<br>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		// tab operation
		$('.btn').click(function() {
			let btn = this; //.btn
			$('.upBtn').each(function(i, element) {
				if (this == btn) {
					alert('bid : ' + this.value);
					$.ajax({
						type : 'GET', //get방식으로 통신
						url : "../bookUpdateJson?chk=upBtn&bid=" + this.value,
						dataType : "json",
						error : function() { //통신 실패시
							alert('통신실패!');
						},
						success : function(data) { //통신 성공시 탭 내용담기 읽어들인 값으로 채운다.
							var uplimit = data[0].uplimit; // 0 or 1 => 수정가능여부
							var limitMsg = data[1].limitMsg;
							alert(limitMsg);
						}
					});
				}
			});
			$('.delBtn').each(function(i, element) {
				if (this == btn) {
					alert('bid : ' + this.value);
					$.ajax({
						type : 'GET', //get방식으로 통신
						url : "../bookUpdateJson?chk=delBtn&bid=" + this.value,
						dataType : "json",
						error : function() { //통신 실패시
							alert('통신실패!');
						},
						success : function(data) { //통신 성공시 탭 내용담기 읽어들인 값으로 채운다.
							let uplimit = data[0].uplimit; // 0 or 1 => 수정가능여부
							let limitMsg = data[1].limitMsg;
							alert(limitMsg);
						}
					});
				}
			});

		});
	});
</script>