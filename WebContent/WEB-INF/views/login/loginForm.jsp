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
	<div class="login" style="margin-bottom: 300px;">
		<h3>로그인</h3>
		<form action="loginProcess" method="post" id="loginInfo">
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="login_sns">
				<div class="login_id" style="width: 300px;">
					<h4>ID</h4>
					<input type="text" name="mid" id="mid" required="required"
						placeholder="ID">
				</div>
			</div>
			<div class="login_sns">
				<div class="login_pw" style="width: 300px;">
					<h4>Password</h4>
					<input type="password" id="mpwd" placeholder="******" name="mpwd">
				</div>
			</div>

			<!--  
			<div>
				<div class="forgot_pw">
					<a href="${ctrpath}/login/idpwdSearch">Forgot Password?</a>
				</div>
			</div>
			-->

			<div id="target"></div>
			
			<div align="center">
				<div class="submit">
					<input type="button" value="submit" id="loginchk">
				</div>
				<br>
			</div>
			<div align="center">
				<a class="kakao" href="https://kauth.kakao.com/oauth/authorize?client_id=5807f5504b2c080d19f04bd0614e4de4&redirect_uri=http://localhost/dTeam_semi_tour/login/kakaoLogin&response_type=code&scope=talk_message,profile_nickname,account_email&prompt=login">
					<!-- REST_API키 및 REDIRECT_URI는 본인걸로 수정하세요 --> <img
					src="${path}/imgfile/kakao/kakaoLogin.png">
				</a>
			</div>
		</form>
	</div>
</div>
<script>
	$(function() {
		$('#loginchk').click(function() {
			let mid = $('#mid').val();
			let mpwd = $('#mpwd').val();
			//console.log(mid)
			//console.log(mpwd)
					$.ajax({
						url :"../loginChk?mid="+mid+"&mpwd="+mpwd,
						success : function(data) {
							console.log(data);
							if (data == 0) {
								if(mid==""){
									$('#target').css('background-color', 'red')
									.css('color', 'white').html(
											'아이디를 입력하세요.');
								}
								else if(mpwd==""){
									$('#target').css('background-color', 'red')
									.css('color', 'white').html(
											'비밀번호를 입력하세요.');
								}
								else{
									$.ajax({
										url :"../idcheck?mid="+mid,
										success : function(data) {
										if(data == 1){
											$('#target').css('background-color', 'red')
											.css('color', 'white').html(
													'비밀번호가 틀렸습니다.');
										}else{
											$('#target').css('background-color', 'red')
											.css('color', 'white').html(
													'존재하지 않는 아이디입니다.');
										}
										}
									});
								}
								} 
							else if(data == 1) {
								$('#loginInfo').submit();
							}
						}
					});
				});
	});	
</script>