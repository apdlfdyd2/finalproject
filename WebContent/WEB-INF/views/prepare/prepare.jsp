<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<meta charset="EUC-KR">

<style>
#prepare {
	max-width: 900px;
	min-height: 400px;
	margin: 40px auto;
}
</style>

<script>
	//뒤로가기
</script>

<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container mt-3" align="center">
	<a href="${ctrpath}/main"> <img src="${path}/img/prepare.png" id="prepare">
	</a>
</div>

<br>
