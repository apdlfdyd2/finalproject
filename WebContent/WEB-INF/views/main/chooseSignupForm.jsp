<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/loginDetailForm.css" />

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="wrap">
	<div class="login" style="margin-bottom: 100px;">
		<a href="${ctrpath}/member/signUpForm"><h3>Member Signup</h3></a>
		<br>
		<br>
		<br>
		<br>
		<div class="login_sns">
			<div class="login_id">
				<a href="${ctrpath}/member/signUpForm"><img src="${path}/img/icon/princess.png"></a>
			</div>
		</div>
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div class="login" style="margin-bottom: 100px;">
		<a href="${ctrpath}/host/hostSignup"><h3>Host Signup</h3></a>
		<br>
		<br>
		<br>
		<br>
		<div class="login_sns">
			<div class="login_id">
				<a href="${ctrpath}/host/hostSignup"><img src="${path}/img/icon/knight.png"></a>
			</div>
		</div>
	</div>
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