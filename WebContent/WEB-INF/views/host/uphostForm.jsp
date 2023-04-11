<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>Host 회원수정</h3>
	<form action="hostupdate" method="post" id="updateInfo">
		<!--
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
	-->
		<input type="hidden" id="hid" name="hid" value="${sessionScope.sessionHID}">
		
		<div class="form-group">
			<label for="hname">이름</label> <input type="text" class="form-control"
				id="hname" placeholder="이름 입력" name="hname" maxlength="20"
				required="required" pattern=".{2,20}">
		</div>
		<div class="form-group">
			<label for="hpwd">PWD</label> <input type="password"
				class="form-control" id="hpwd" placeholder="******" name="hpwd"
				maxlength="20" required="required" pattern=".{2,20}">
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
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<input type="submit" class="btn btn-primary" value="등록">
			&nbsp; 
			<a href="${ctrpath}/login/idpwdSearch">
			<button type="button" class="btn btn-primary" id="hidpwdBtn">아이디/비번찾기</button>
			</a>
		</div>
	</form>
</div>