<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#frame {
	max-width: 1500px;
	min-height: 300px;
	margin: 0 auto;
}
</style>
<article>
	<header>
		<h1>공지</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div id="frame">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr>
						<td>${e.nnum }</td>
						<td>${e.nsub }</td>
						<td>${e.nwriter }</td>
						<!-- <td>1000</td> -->
						<td>${e.ndate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
					<%@include file="../page/pageModule.jsp" %>
					</td>
				</tr>
				<tr>
					<th colspan="4">
						<form class="d-flex" method="post" action="listNo">
							<select class="form-control btn-mini" name="searchType" id="searchType"
								style="margin-left: 120px;">
								<option value="">검색</option>
								<option value="1">제목</option>
								<option value="2">이름</option>
							</select> <input class="form-control me-2" type="text"
								style="width: 300px" name="searchValue" id="searchValue">
							<button class="btn btn-outline-secondary" type="submit">Search</button>
						</form>
					</th>
				</tr>
				<tr>
					<td colspan="4" style="text-align: right;">
					<c:if test="${searchType == 1 or searchType == 2}">
						${totalRecord}개의  게시물에서 <b>${searchValue}</b> 가 검색 되었습니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
        				<a href="${pageContext.request.contextPath}/upload/upform">
						<button type="button" class="btn btn-outline-secondary" id="wbtn">글작성</button>
						</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</article>