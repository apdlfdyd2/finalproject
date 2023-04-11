<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>IDSearchProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
<h3>ID찾기</h3>
	<form action="loginProcess" method="post" id="loginInfo">
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
		<div class="form-group">
			<label for="name">이름</label> <input type="text" class="form-control"
				id="name" placeholder="이름 입력" name="name" maxlength="10"
				required="required">
		</div>
		<!-- 전화번호 받는 형식 적용 -->
		<div class="form-group">
			<label for="id">전화번호</label> <input type="text" class="form-control"
				id="phone" placeholder="전화번호 입력" name="phone" maxlength="11"
				required="required">
		</div>
		<div class="form-group">
			<label for="pwd">본인확인 질문</label>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">등록</button>
			&nbsp;
		</div>
	</form>

</div>

<script>
/*
$(function() {
	$('#idpwdBtn').click(function() {
		location="/login/idpwdSearch";
	});
});
*/
</script>