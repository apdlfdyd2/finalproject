<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>ID/PWD Search</h1>
</header>

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="popular_places_area">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="section_title text-center mb_70">
					<a href="${ctrpath}/main"> <img src="${path}/img/logo.png"
						alt="">
					</a>
					<h3>ID/PWD 찾기 페이지입니다</h3>
					<p>찾으시려는 메뉴를 선택해 주세요</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="single_place">
					<div class="thumb">
						<img src="${path}/img/icon/icon_id.png" alt="">
					</div>
					<div class="place_info">
						<a href="${ctrpath}/login/idSearch"><h3>아이디 찾기</h3></a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_place">
					<div class="thumb">
						<img src="${path}/img/icon/icon_password.png" alt="">
					</div>
					<div class="place_info">
						<a href="${ctrpath}/login/pwdSearch"><h3>비밀번호 찾기</h3></a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_place">
					<div class="thumb">
						<img src="${path}/img/icon/icon_adduser.png" alt="">
					</div>
					<div class="place_info">
						<a href="${ctrpath}/member/signUpForm"><h3>회원가입</h3></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="more_place_btn text-center">
				<a class="boxed-btn4" href="${ctrpath}/main">Home</a>
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