<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 2. 1. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>회원수정</h3>
	<form action="updateProcess" method="post" id="updateInfo">
		<!--
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
	-->
		<input type="hidden" name="mid" value="${sessionScope.sessionID}">
		<input type="hidden" name="mnum" value="${sessionScope.sessionNum}">
		
		<div class="form-group">
			<label for="mname">이름</label> <input type="text" class="form-control"
				id="mname" placeholder="이름 입력" name="mname" maxlength="10"
				required="required" pattern=".{2,10}">
		</div>
		<div class="form-group">
			<label for="mpwd">PWD</label> <input type="password"
				class="form-control" id="mpwd" placeholder="******" name="mpwd"
				maxlength="10" required="required" pattern=".{2,10}">
		</div>
		<!-- 핸드폰번호 받는 형식으로 받기 -->
		<div class="form-group">
			<label for="mphone">연락처</label> <input type="text"
				class="form-control" id="mphone" placeholder="연락처 입력" name="mphone"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="maddr">주소</label> <input type="text" class="form-control"
				id="maddr" placeholder="주소 입력" name="maddr" required="required">
		</div>
		<div class="form-group">
			<label for="memail">이메일</label> <input type="text"
				class="form-control" id="memail" placeholder="이메일 입력" name="memail"
				required="required">
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" id="upBtn" class="btn btn-primary">등록</button>
			&nbsp; 
			<a href="${ctrpath}/login/idpwdSearch">
			<button type="button" class="btn btn-primary" id="idpwdBtn">아이디/비번찾기</button>
			</a>
		</div>
	</form>
</div>
<script>
	$(function() {
		$('#upBtn').click(function() {
			alert('수정 되었습니다!');
		});
	});
</script>