<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 2023. 1. 20. / Kosmo --%>
<!-- file-name -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>member.jsp</title>
<style type="text/css">
.night {
	background-color: black;
	color: white;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body class="night">
	<div>
		<table class="table table-bordered"
			style="width: 1000px; color: white;">
			<thead>
				<tr>
					<th>Mnum</th>
					<th>Mid</th>
					<th>Mpwd</th>
					<th>Mname</th>
					<th>Mjumin</th>
				</tr>
			</thead>
			<tbody id="list">
				<%-- for start --%>

				<%-- for end --%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<nav aria-label="Page navigation example">
							<ul id="page" class="pagination justify-content-center">

							</ul>
						</nav>
					</td>
				</tr>
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
		<script type="text/javascript">
			let pagePerBlock = null;
			let nowPage = null;
			let totalPage = null;
			let startPage = null;
			let endPage = null;
			
			$(function() {
				$.ajax({
					url:'../ajax/listMember',
					success: function(json) {
						let obj = JSON.parse(json);
						
						for(const e of obj) {
							$('#list').append('<tr><td>'+e.mid+'</td><td>'+e.mjumin+'</td><td>'+e.mname+'</td><td>'+e.mnum+'</td><td>'+e.mpwd+'</td></tr>');
						}
					}
				})
				$.ajax({
					url: '../ajax/memberPage',
					success: function(json) {
						let obj = JSON.parse(json)[0];
						
						pagePerBlock = obj.pagePerBlock;
						nowPage = obj.nowPage;
						totalPage = obj.totalPage;
						startPage = obj.startPage;
						endPage = obj.endPage;
						
						$('#page').append('<li id="previous" class="page-item"><button class="page-link" onclick="index('+(startPage-1)+')">Previous</button> </a></li>');
						for(i=startPage; i<=endPage; i++) {
							$('#page').append('<li class="page-item"><button id="index'+i+'" class="page-link" onclick="index('+i+')">'+i+'</button></li>')
						}
						$('#page').append('<li id="next" class="page-item"><button class="page-link" onclick="index('+(endPage+1)+')">Next</button></li>');
						
						if(endPage <= pagePerBlock) {
							$('#previous').addClass('disabled');
						} else {
							$('#previous').addClass('active');
						}
						if(endPage >= totalPage) {
							$('#next').addClass('disabled');
						} else {
							$('#next').addClass('active');
						}
					}
				})
			})
			
			function index(i) {
				$.ajax({
					url:'../ajax/listMember?nowPage='+i,
					success: function(json) {
						let obj = JSON.parse(json);
						
						$('#list').empty();
						for(const e of obj) {
							$('#list').append('<tr><td>'+e.mid+'</td><td>'+e.mjumin+'</td><td>'+e.mname+'</td><td>'+e.mnum+'</td><td>'+e.mpwd+'</td></tr>');
						}
					}
				})
				$.ajax({
					url: '../ajax/memberPage?nowPage='+i,
					success: function(json) {
						let obj = JSON.parse(json)[0];
						
						pagePerBlock = obj.pagePerBlock;
						nowPage = obj.nowPage;
						totalPage = obj.totalPage;
						startPage = obj.startPage;
						endPage = obj.endPage;
						
						$('#page').empty();
						$('#page').append('<li id="previous" class="page-item"><button class="page-link active" onclick="index('+(startPage-1)+')">Previous</button> </a></li>');
						for(i=startPage; i<=endPage; i++) {
							$('#page').append('<li class="page-item"><button id="index'+i+'" class="page-link" onclick="index('+i+')">'+i+'</button></li>')
						}
						$('#page').append('<li id="next" class="page-item"><button class="page-link" onclick="index('+(endPage+1)+')">Next</button></li>');
						
						if(endPage <= pagePerBlock) {
							$('#previous').addClass('disabled');
						} else {
							$('#previous').addClass('active');
						}
						if(endPage >= totalPage) {
							$('#next').addClass('disabled');
						} else {
							$('#next').addClass('active');
						}
					}
				})
			}
		</script>
	</div>
</body>
</html>