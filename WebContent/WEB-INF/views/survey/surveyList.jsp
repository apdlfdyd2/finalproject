<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<style>
#frame {
	max-width: 1500px;
	min-height: 300px;
	margin: 0 auto;
}
</style>

<article>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div id="frame">
		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>항목</th>
					<th>투표수</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list }">
					<tr>
						<th>${e.num }</th>
						<th><a href="surveyDetail?num=${e.num }">${e.sub }</a></th>
						<th>${e.code }</th>
						<th>${e.surveytotal }</th>
						<th>${e.sdate }</th>
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
						<form class="d-flex" method="post" action="surveyList">
							<select class="form-control btn-mini" name="searchType" id="searchType"
								style="margin-left: 120px;">
								<option value="">검색</option>
								<option value="1">제목</option>
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
        				
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</article>
