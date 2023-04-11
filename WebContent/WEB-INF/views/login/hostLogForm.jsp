<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/loginDetailForm.css" />

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="wrap">
	<div class="login" style="margin-bottom: 300px;">
		<h3>로그인</h3>
		<form action="hloginProcess" method="post" id="loginInfo">
			<!--
            <input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
        -->
			<div class="login_sns">
				<div class="login_id" style="width: 300px;">
					<h4>ID</h4>
					<input type="text" name="hid" id="hid" required="required"
						placeholder="ID">
				</div>
			</div>
			<div class="login_sns">
				<div class="login_pw" style="width: 300px;">
					<h4>Password</h4>
					<input type="password" id="hpwd" placeholder="**" name="hpwd">
				</div>
			</div>

			<div id="target"></div>
			
			<div align="center">
				<div class="submit">
					<input type="button" value="submit" id="hloginchk">
				</div>
				<br>
			</div>

		</form>
	</div>
</div>

<script>
	$(function() {
		$('#hloginchk').click(
				function() {
					let hid = $('#hid').val();
					let hpwd = $('#hpwd').val();
					console.log(hid)
					console.log(hpwd)
					$.ajax({
						url : "../hloginChk?hid=" + hid + "&hpwd=" + hpwd,
						success : function(data) {
							console.log(data);
							if (data == 0) {
								if (hid == "") {
									$('#target').css('background-color', 'red')
											.css('color', 'white').html(
													'아이디를 입력하세요.');
								} else if (hpwd == "") {
									$('#target').css('background-color', 'red')
											.css('color', 'white').html(
													'비밀번호를 입력하세요.');
								} else {
									$.ajax({
										url : "../hidcheck?hid=" + hid,
										success : function(data) {
											if (data == 1) {
												$('#target').css(
														'background-color',
														'red').css('color',
														'white').html(
														'비밀번호가 틀렸습니다.');
											} else {
												$('#target').css(
														'background-color',
														'red').css('color',
														'white').html(
														'존재하지 않는 아이디입니다.');
											}
										}
									});

								}

							} else if (data == 1) {
								$('#loginInfo').submit();

							}
						}
					});
				});
	});
</script>