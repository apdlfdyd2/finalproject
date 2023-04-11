<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="../resources/css/c3.css" rel="stylesheet">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap')
	;

#frame {
	max-width: 1000px;
	min-height: 300px;
	margin: 0 auto;
}

th {
	background-color: mistyrose;
	text-align: center;
	size: 15px;
}

#button {
	left: auto;
}

table {
	font-family: 'Noto Serif KR', serif;
	border-collapse: collapse;
	border-radius: 10px;
	border-style: hidden;
}

/* =============제목============== */
.eight h1 {
	text-align: center;
	text-transform: uppercase;
	font-size: 26px;
	letter-spacing: 1px;
	display: grid;
	grid-template-columns: 1fr auto 1fr;
	grid-template-rows: 16px 0;
	grid-gap: 22px;
}

.eight h1:after, .eight h1:before {
	content: " ";
	display: block;
	border-bottom: 2px solid #ccc;
	background-color: #f8f8f8;
}

h1 {
	position: relative;
	padding: 0;
	margin: 0;
	font-family: "Raleway", sans-serif;
	font-weight: 300;
	font-size: 40px;
	color: #080808;
	-webkit-transition: all 0.4s ease 0s;
	-o-transition: all 0.4s ease 0s;
	transition: all 0.4s ease 0s;
}

h1 span {
	display: block;
	font-size: 0.5em;
	line-height: 1.3;
}

h1 em {
	font-style: normal;
	font-weight: 600;
}

.two h1 {
	text-transform: capitalize;
}

.two h1:before {
	position: absolute;
	left: 0;
	bottom: 0;
	width: 60px;
	height: 2px;
	content: "";
	background-color: #c50000;
}

.two h1 span {
	font-size: 13px;
	font-weight: 500;
	text-transform: uppercase;
	letter-spacing: 4px;
	line-height: 3em;
	padding-left: 0.25em;
	color: rgba(0, 0, 0, 0.4);
	padding-bottom: 10px;
}

.alt-two h1 {
	text-align: center;
}

.alt-two h1:before {
	left: 50%;
	margin-left: -30px;
}

/* =============제목============== */
/* =============button============== */
.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-family: 'Lato', sans-serif;
	font-weight: 500;
	background: transparent;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

.btn-6 {
	background: rgb(247, 150, 192);
	background: radial-gradient(circle, rgba(247, 150, 192, 1) 0%,
		rgba(118, 174, 241, 1) 100%);
	line-height: 42px;
	padding: 0;
	border: none;
}

.btn-6 span {
	position: relative;
	display: block;
	width: 100%;
	height: 100%;
}

.btn-6:before, .btn-6:after {
	position: absolute;
	content: "";
	height: 0%;
	width: 1px;
	box-shadow: -1px -1px 20px 0px rgba(255, 255, 255, 1), -4px -4px 5px 0px
		rgba(255, 255, 255, 1), 7px 7px 20px 0px rgba(0, 0, 0, .4), 4px 4px
		5px 0px rgba(0, 0, 0, .3);
}

.btn-6:before {
	right: 0;
	top: 0;
	transition: all 500ms ease;
}

.btn-6:after {
	left: 0;
	bottom: 0;
	transition: all 500ms ease;
}

.btn-6:hover {
	background: transparent;
	color: #76aef1;
	box-shadow: none;
}

.btn-6:hover:before {
	transition: all 500ms ease;
	height: 100%;
}

.btn-6:hover:after {
	transition: all 500ms ease;
	height: 100%;
}

.btn-6 span:before, .btn-6 span:after {
	position: absolute;
	content: "";
	box-shadow: -1px -1px 20px 0px rgba(255, 255, 255, 1), -4px -4px 5px 0px
		rgba(255, 255, 255, 1), 7px 7px 20px 0px rgba(0, 0, 0, .4), 4px 4px
		5px 0px rgba(0, 0, 0, .3);
}

.btn-6 span:before {
	left: 0;
	top: 0;
	width: 0%;
	height: .5px;
	transition: all 500ms ease;
}

.btn-6 span:after {
	right: 0;
	bottom: 0;
	width: 0%;
	height: .5px;
	transition: all 500ms ease;
}

.btn-6 span:hover:before {
	width: 100%;
}

.btn-6 span:hover:after {
	width: 100%;
}
</style>
<script src="../resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="../resources/js/c3.min.js"></script>
<link href="../resources/css/star.css" rel="stylesheet" />


<script>
	$.ajaxSetup({
		cache : false
	});

	$.ajax({
	url: "../reviewRest/getavg?recode="+${vo.lno},
	success: function (json) {
		console.log("별점: " + json);
		if(json !== null){
			$('#starAvg').html(json +"점");
		} else if(json === null) {
			$('#starAvg').html("아직 평가가 없어요!");
		}
		
		}
	});
</script>

</head>
<body>

	<div class="two alt-two">
		<h1>
			Travelo <span>TRAVELO LIST DETAIL DETAIL</span>
		</h1>
	</div>
	<br>

	<div id="frame">
		<table class="table table-bordered border-primary">
			<tr>
				<th>글 번호</th>
				<td>${vo.lno}</td>
			</tr>

			<tr>
				<th>제목</th>
				<td>${vo.ltitle}</td>
			</tr>

			<tr>
				<th>별점</th>
				<td id="starAvg"></td>
			</tr>

			<tr>
				<th>사진</th>
				<td><img
					src="${pageContext.request.contextPath}/resources/imgfile/${vo.limg}"></td>
			</tr>

			<tr>
				<th>지역</th>
				<td><div id="map" style="width: 800px; height: 300px;"></div></td>
			</tr>

			<tr>
				<th>내용</th>
				<td>${vo.lcontent}</td>
			</tr>
		</table>


		<div id="button">
			<c:choose>
				<c:when test="${sessionScope.sessionHID != null }">
					<a href="localmodifyForm?num=${vo.lno}"><button type="button"
							class="btn btn-outline-danger">수정</button></a>

					<a href="localdelete?num=${vo.lno}"><button type="button"
							class="btn btn-outline-secondary">삭제</button></a>

				</c:when>
				<c:when test="${sessionScope.sessionID != null }">
					<a href="../book/bookForm?lid=${vo.lno}"><button type="button"
							class="btn btn-outline-warning">예약하기</button></a>
					<a href="../interest/addCart?lid=${vo.lno}"><button
							type="button" class="btn btn-outline-warning">찜하기</button></a>
					<a href="../interest/addCart?lid=${vo.lno}"><button
							type="button" class="btn btn-outline-danger">△ 좋아요</button></a>
					<a href="../interest/addCart?lid=${vo.lno}"><button
							type="button" class="btn btn-outline-danger">▽ 싫어요</button></a>
				</c:when>
			</c:choose>
		</div>

		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e0548ec1c0d1a5e8a925a270d49e2192&libraries=LIBRARY"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    		mapOption = { 
       		center: new kakao.maps.LatLng(37.4664799, 126.6526885), // 지도의 중심좌표
        	level: 3 // 지도의 확대 레벨
    		};

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커가 표시될 위치입니다 
			var markerPosition = new kakao.maps.LatLng(37.4664799, 126.6526885); 

		// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
   			position: markerPosition
			});

		// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);

		// 마커가 드래그 가능하도록 설정합니다 
			marker.setDraggable(true); 
		</script>

		<%-- ----------------------------------------------------------------- --%>
		<%-- ---------------------------댓글/리뷰 영역----------------------------- --%>

		<br>
		<%-- ---------------------------리뷰 리스트------------------------------- --%>
		<%-- ---------------------------별점 차트 보기------------------------------- --%>
		<div class="eight">
			<h1>Review</h1>
		</div>

		<div id="chart"></div>
		<script>
		console.log(${vo.lno});
		$.ajaxSetup({
			cache : false
		});

		$.ajax({
			url : "../reviewRest/reviewstarChart?num=" + ${vo.lno},
			success : function(json) {
		
				var chart = c3.generate({
					bindto : '#chart',
					data : {
						json : [ json ],
						keys : {
							value : Object.keys(json),
						},
						type : 'donut'
					},
					donut : {
						title : '별점 평균',
					},
				});
				//----------------------
				},
			error : function(e) {
				console.log("error:" + e);
				}
			});
		</script>
		<%-- ---------------------------별점 차트 보기------------------------------- --%>

		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글 번호</th>
						<th>글 제목</th>
						<th>작성자</th>
						<th>내용</th>
						<th>작성날짜</th>
						<th>별점</th>
					</tr>
				</thead>

				<tbody>
					<%-- 반복시작 --%>
					<c:forEach var="e" items="${listReview}">
						<tr>
							<td class="align-middle text-center">${e.reno}</td>
							<td class="text-center">${e.retitle}</td>
							<td class="text-center">${e.rewriter}</td>
							<td class="align-middle">${e.recontent}</td>
							<td class="align-middle">${e.redate}</td>
							<td class="align-middle">${e.star}점</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<%-- ------------------------------modal------------------------------ --%>
		<c:choose>
			<c:when test="${sessionScope.sessionID==null }">

			</c:when>

			<c:when test="${sessionScope.sessionID!=null }">
				<button type="button" class="custom-btn btn-6"
					data-bs-toggle="modal" data-bs-target="#exampleModal"
					data-bs-whatever="@fat">Review</button>




				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="exampleModalLabel">&#128147;리뷰
									등록하기&#128147;</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form action="addReview" method="post">
									<input type="hidden" name="recode" value="${vo.lno}">
									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">제목:</label>
										<input type="text" class="form-control" id="recipient-name"
											name="retitle" id="retitle" required="required"
											placeholder="제목을 입력하세요.">
									</div>

									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">작성자:
											${sessionScope.sessionName } 님</label> <input type="hidden"
											value="${sessionScope.sessionID }" name="rewriter"
											id="rewriter">
									</div>

									<%-- --------------별점 관리------------------ --%>
									<div class="mb-3" id="myform">
										<fieldset>
											<input type="radio" name="star" value=5 id="rate1"> <label
												for="rate1">★</label> <input type="radio" name="star"
												value=4 id="rate2"> <label for="rate2">★</label> <input
												type="radio" name="star" value=3 id="rate3"> <label
												for="rate3">★</label> <input type="radio" name="star"
												value=2 id="rate4"> <label for="rate4">★</label> <input
												type="radio" name="star" value=1 id="rate5"> <label
												for="rate5">★</label>
										</fieldset>
									</div>
									<%-- --------------별점 관리------------------ --%>

									<div class="mb-3">
										<label for="message-text" class="col-form-label">내용:</label>
										<textarea class="form-control" id="message-text"
											placeholder="내용을 입력하세요." name="recontent" id="recontent"
											rows="10" cols="50" required="required"></textarea>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">닫기</button>
										<button type="submit" class="btn btn-primary">등록하기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
		<%-- ------------------------------modal------------------------------ --%>

		<%-- 
		<h3 align="center">댓글 작성하기</h3>
		<form action="addReview" method="post">
			<input type="hidden" name="recode" value="${vo.lno}">

			<div class="input-group mb-3">
				<span class="input-group-text">제목</span> <input type="text"
					class="form-control" name="retitle" id="retitle">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">작성자</span> <input type="text"
					class="form-control" name="rewriter" id="rewriter">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">내용</span>
				<textarea class="form-control" id="message-text"
					placeholder="내용을 입력하세요." name="recontent" id="recontent" rows="10"
					cols="50"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">등록하기</button>
		</form>
	</div>
	--%>
	</div>
	<br>

</body>
</html>