<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<style>
a:link {
	text-decoration: none;
}

/* paging */
table tfoot ol.paging {
	margin-left: 30%;
	list-style: none;
}

table tfoot ol.paging li {
	float: left;
	margin-right: 8px;
}

table tfoot ol.paging li a {
	display: block;
	padding: 3px 7px;
	border: 1px solid #00B3DC;
	color: #2f313e;
	font-weight: bold;
}

table tfoot ol.paging li a:hover {
	background: #00B3DC;
	color: white;
	font-weight: bold;
}

.disable {
	padding: 3px 7px;
	border: 1px solid silver;
	color: silver;
}

.now {
	padding: 3px 7px;
	border: 1px solid #ff4aa5;
	background: #ff4aa5;
	color: white;
	font-weight: bold;
}
</style>

<article>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Ltitle</th>
					<th>Lcontent</th>
					<th>Limg</th>
					<th>Lprice</th>
				</tr>
			</thead>
			<tbody>
				<%-- for start --%>
				<c:forEach var="e" items="${list }">
					<tr>
						<td><a href="localdetail?num=e.lno">${e.ltitle }</a></td>
						<td>${e.lcontent }</td>
						<td><img src="${path }/imgfile/${e.limg }"></td>
						<td><a href="#" class="prise">${e.lprice }</a></td>
					</tr>
				</c:forEach>
				<%-- for end --%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><%@ include file="../page/pageModule.jsp"%>
					</td>
				</tr>
				<%-- 
    <tr>
<th colspan="5" style="text-align: center; ">
      <ul class="pagination" style="margin:0 auto; width: 35%">
		  <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
		  <li class="page-item active" ><a class="page-link" href="#">1</a></li>
		  <li class="page-item"><a class="page-link" href="#">2</a></li>
		  <li class="page-item"><a class="page-link" href="#">3</a></li>
		  <li class="page-item"><a class="page-link" href="#">4</a></li>
		  <li class="page-item"><a class="page-link" href="#">5</a></li>
		  <li class="page-item"><a class="page-link" href="#">Next</a></li>
      </ul>
 </th>
      </tr>
      --%>
				<%--
    end
       --%>

				<tr>
					<td colspan="5">
						<form class="d-flex">
							<div class="row g-3 align-middle text-center">
								<div class="col-auto">
									<select class="form-select" name="searchType" id="searchType"
										aria-label="Default select example">
										<option selected value="">검색</option>
										<option value="1">아이디</option>
										<option value="2">이름</option>
									</select>
								</div>
								<div class="col-auto">
									<label for="searchValue" class="visually-hidden">searchValue</label>
									<input type="text" class="form-control" id="searchValue"
										name="searchValue" placeholder="searchValue">
								</div>
								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-3">Search</button>
								</div>
							</div>
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right;">
						<!-- 
      jQuery로 글작성 폼으로 이동시키기
      id를 부여하여 선택자로 selector를 사용해서 이동시키기
      footer.jsp에서 작성.
       -->
						<button type="button" class="btn btn-outline-secondary" id="wbtn2">글작성</button>
					</td>
				</tr>

			</tfoot>
		</table>
	</div>
</article>