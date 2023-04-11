<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>Host 회원가입</h3>
	<form action="hsignUpProcess" method="post" id="signUpInfo">
		<div class="form-group">
			<label for="hname">이름</label> <input type="text" class="form-control"
				id="hname" placeholder="이름 입력" name="hname" maxlength="10"
				required="required" pattern=".{2,10}">
		</div>
		<div class="form-group">
			<label for="hid">ID</label> <input type="text" class="form-control"
				id="hid" placeholder="아이디 입력" name="hid" maxlength="10"
				required="required" pattern=".{2,10}">
			
			<button type="button" class="btn btn-primary" id="hidchk">중복확인</button>
			<div id="target"></div>

		</div>
		<div class="form-group">
			<label for="hpwd">PWD</label> <input type="password"
				class="form-control" id="hpwd" placeholder="******" name="hpwd"
				maxlength="10" required="required" pattern=".{2,10}">
		</div>
		<!-- 핸드폰번호 받는 형식으로 받기 -->
		<div class="form-group">
			<label for="hphone">연락처</label> <input type="text"
				class="form-control" id="hphone" placeholder="연락처 입력" name="hphone"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="haddr">주소</label> <input type="text" class="form-control"
				id="haddr" placeholder="주소 입력" name="haddr" required="required">
		</div>
		<div class="form-group">
			<label for="hemail">이메일</label> <input type="text"
				class="form-control" id="hemail" placeholder="이메일 입력" name="hemail"
				required="required">
		</div>
		<div class="form-group">
			<label for="hduns">사업자번호</label> <input type="text"
				class="form-control" id="hduns" placeholder="사업자번호 입력" name="hduns">
		</div>
		<div class="form-group">
			<label for="haccount">결제 방식</label> <input type="text"
				class="form-control" id="haccount" placeholder="결제방식" name="haccount"
				required="required">
		</div>
<!-- 
		<input type="hidden" id="mgrade" name="mgrade" value="10">
		<input type="hidden" id="mpoint" name="mpoint" value="1000">
		 -->
		<input
			type="hidden" id="hnum" name="hnum" value="1">

	</form>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<div id="target2"></div>
			<button id="subbtn" class="btn btn-primary">등록</button>
			
			&nbsp; <a href="${ctrpath}/login/idpwdSearch">
				<button type="button" class="btn btn-primary" id="idpwdBtn">아이디/비번찾기</button>
			</a>
		</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	/*
	 $(function() {
	 $('#idpwdBtn').click(function() {
	 location="/login/idpwdSearch";
	 });
	 });
	 */

	$(function() {
		$('#hidchk').click(
				function() {
					let param = $('#hid').val();
					$.ajax({
						url : "../hidcheck?hid=" + param,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'사용중인 아이디 입니다.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'사용 가능한 아이디 입니다.');
							}
						}
					});
				});
	});
	 
	$(function() {
			$('#subbtn').click(
					function() {
						let param = $('#hid').val();
						$.ajax({
							url : "../hidcheck?hid=" + param,
							success : function(data) {
								console.log(data);
								if (data == 1) {
									$('#target2').css('background-color', 'red')
											.css('color', 'white').html(
													'사용중인 아이디 다른 아이디를 입력해주세요.');
								}
								else if(param == ""){
									$('#target2').css('background-color', 'red')
									.css('color', 'white').html(
											'필수사항을 입력해주세요.');
								}
								else if(data == 0) {
								$('#signUpInfo').submit()
								
								}
							}
						});
					});
		});
</script>