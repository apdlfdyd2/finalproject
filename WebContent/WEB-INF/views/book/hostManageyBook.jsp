<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />



<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap')
	;

#frame {
	max-width: 1500px;
	min-height: 300px;
	margin: 0 auto;
}

.btn {
	margin-right: 30px;
}
</style>

<article>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="" align="center">
		<button class="btn btn-outline-secondary bookBtn" type="button"
			id="waitBook">예약 대기</button>
		<button class="btn btn-outline-secondary bookBtn" type="button"
			id="confirmBook">예약 확정</button>
		<button class="btn btn-outline-secondary bookBtn" type="button"
			id="checkIn">체크 인</button>
		<button class="btn btn-outline-secondary bookBtn" type="button"
			id="checkOut">체크 아웃</button>
	</div>

	<br>

	<div id="frame">
		<table class="table">
			<thead>
				<tr align="center">
					<th>예약번호</th>
					<th>숙소명</th>
					<th>입실</th>
					<th>퇴실</th>
					<th>예약자명</th>
					<th>연락처</th>
					<th>예약상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${locallist }">
					<c:forEach var="i" items="${e.book }">
						<tr align="center">
							<th>${i.bid }</th>
							<th>${e.ltitle }</th>
							<th>${i.sdate }</th>
							<th>${i.edate }</th>
							<th>${e.mname }</th>
							<th>${e.mphone }</th>
							<th>
								<button class="btn btn-outline-secondary" type="button" id="d"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="@fat">${i.bstatus }</button>
							</th>
						</tr>
						<!-- 모달 START -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-5" id="exampleModalLabel">예약 상태
											변경</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">

										<form action="updateBookHost" method="post">
											<input type="hidden" name="bid" value="${i.bid }">
											<div class="mb-3">
												<label for="recipient-name" class="col-form-label">현재
													예약 상태</label> <input type="text" class="form-control"
													id="recipient-name" readonly="readonly"
													value="${i.bstatus }">
											</div>

											<div class="mb-3">
												<label for="recipient-name" class="col-form-label">예약
													상태 변경</label>
												<p>
													<input type="radio" id="bstatus" name="bstatus"
														required="required" value="예약대기">예약대기
												<p>
													<input type="radio" id="bstatus" name="bstatus"
														required="required" value="예약확정">예약확정
												<p>
													<input type="radio" id="bstatus" name="bstatus"
														required="required" value="체크인">체크인
												<p>
													<input type="radio" id="bstatus" name="bstatus"
														required="required" value="체크아웃">체크아웃
												<p>
											</div>

											<div class="modal-footer">
												<button type="submit" class="btn btn-primary">변경하기</button>
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">닫기</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- 모달 END -->
					</c:forEach>
				</c:forEach>
			</tbody>

			<tfoot>

			</tfoot>
		</table>
	</div>
</article>

<script>
	$(function() {
		// 현재 선택된 버튼 객체
		let currentBtn = null;

		// 예약대기 버튼 선택
		$('#waitBook').click(function() {
			location.href = '${ctrpath}/host/hostBookList?bstatus=예약대기';
		});

		// 예약확정 버튼 클릭 이벤트 처리
		$('#confirmBook').click(function() {
			location.href = '${ctrpath}/host/hostBookList?bstatus=예약확정';
		});

		// 체크인 버튼 클릭 이벤트 처리
		$('#checkIn').click(function() {
			location.href = '${ctrpath}/host/hostBookList?bstatus=체크인';
		});

		// 체크아웃 버튼 클릭 이벤트 처리
		$('#checkOut').click(function() {
			location.href = '${ctrpath}/host/hostBookList?bstatus=체크아웃';
		});

	});
</script>