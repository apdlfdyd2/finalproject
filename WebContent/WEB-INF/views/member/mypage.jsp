<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/myPageUI.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/buttonEff.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/myPageRankHover.css" rel="stylesheet" />
<div class="wrap" style="max-width: 1000px; margin: 0 auto;">

	<!-- ================================================== -->
	<!-- 차트 -->
	<!-- Load c3.css -->
	<link href="${path }/css/c3.css" rel="stylesheet">
	<!-- Load d3.js and c3.js -->
	<script src="${path }/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="${path }/js/c3.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- ================================================== -->

	<div class="pinkContainer">
		<div>
			<div class="grade">
				<figure>
					<img src="${path}/rankimg/boltstone.png" height="40px" width="45px" id="gradeimg">
				</figure>
			</div>
			<div class="green name">${sessionScope.sessionName}님 마이페이지</div>

		</div>

		<!-- ================================================== -->
		<!-- 멤버+멤버쉽 : name 출력(세션/ResultMap) -->
		<div class="modify"></div>
	</div>
	<c:forEach var="e" items="${mbsvo.member }">
		<div class="summaryContainer">
			<div class="item">
				<div class="rank">${mbsvo.mbsname }</div>
				<div>등급</div>
			</div>
			<div class="item">
				<div class="number">${rcnt }</div>
				<div>리뷰</div>
			</div>
			<div class="item">
				<div class="number">
					<fmt:formatNumber value="${e.mpoint }" pattern="###,###" />
					point
				</div>
				<div>포인트</div>
			</div>
		</div>
		<!-- ================================================== -->
		<div class="shippingStatusContainer">
			<div class="title">등급</div>
			<div class="status">
				<div class="item">
					<div>
						<div id="membershipGauge"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- ================================================== -->
		<div class="shippingStatusContainer">
			<div class="title">찜목록</div>
			<div class="status">
				<div class="item">
					<div>
						<div class="green number">6</div>
						<div class="text">좋아요</div>
					</div>
					<div class="icon">></div>
				</div>
				<div class="item">
					<div>
						<div class="number">0</div>
						<div class="text">준비중</div>
					</div>
					<div class="icon">></div>
				</div>
				<div class="item">
					<div>
						<div class="green number">1</div>
						<div class="text">결제완료</div>
					</div>
					<div class="icon">></div>
				</div>
				<div class="item">
					<div>
						<div class="green number">3</div>
						<div class="text">구매확정</div>
					</div>
					<div class="icon">></div>
				</div>
			</div>

		</div>
		<!-- ================================================== -->
		<div class="listContainer">
			<a href="useHistoryList?mnum=${sessionScope.sessionNum}&chk=1" class="item">
				<div class="icon"></div>
				<div class="text">
					이용내역<span class="circle"></span>
				</div>
				<div class="right">></div>
			</a> <a href="myReviewList?mid=${sessionScope.sessionID}" class="item">
				<div class="icon"></div>
				<div class="text">리뷰내역</div>
				<div class="right">></div>
			</a> <a href="#" class="item">
				<div class="icon"></div>
				<div class="text">문의내역</div>
				<div class="right">></div>
			</a> <a href="${ctrpath}/interest/listCart" class="item">
				<div class="icon"></div>
				<div class="text">찜한여행</div>
				<div class="right">></div>
			</a> <a href="${ctrpath}/survey/surveyList" class="item">
				<div class="icon"></div>
				<div class="text">설문조사</div>
				<div class="right">></div>
			</a>
		</div>
		<!-- ================================================== -->
		<div class="listContainer">
			<a href="mypageDetail?mnum=${sessionScope.sessionNum}" class="item">
				<div class="icon"></div>
				<div class="text">회원정보</div>
				<div class="right">></div>
			</a> <a href="mypageChart?mnum=${sessionScope.sessionNum}" class="item">
				<div class="icon"></div>
				<div class="text">나의 그래프</div>
				<div class="right">></div>
			</a> 
			<a href="../scheduler/scheduleList?scmem=${sessionScope.sessionID}" class="item">
				<div class="icon"></div>
				<div class="text">나의 스케줄러</div>
				<div class="right">></div>
			</a>
		</div>
	</c:forEach>
	<!-- ================================================== -->
	<div class="infoContainer">

		<a class="item">
			<div>
				<i class="fa-regular fa-chess-queen"></i>
			</div>
			<button onclick="history.back()">이전 페이지</button>
		</a> <a href="delmem?mnum=${sessionScope.sessionNum}" class="item">
			<div>
				<i class="fa-solid fa-skull " style="color: #C60B02"></i>
			</div>
			<button type="button" id="delBtn">회원탈퇴</button>
		</a> <a href="../customernotice/noticeSearch?searchType=&searchValue=&cPage=1" class="item">
			<div>
				<i class="fa-solid fa-chess-queen"></i>
			</div>
			<button type="button">공지사항</button>
		</a> <a href="#" class="item">
			<div>
				<i class="fa-solid fa-chess-queen"></i>
			</div>
			<button type="button">Q & A</button>
		</a>
	</div>
</div>
<!-- ================================================== -->

<script>
	$.ajaxSetup({
		cache : false
	//캐시삭제
	});
	$.ajax({
		//데이터를 주고받을 파일 주소 입력 => MemberRestController에서 핸들링
		url : "../membershipGauge?mnum=${sessionScope.sessionNum}",
		//작업이 성공적으로 발생했을 경우
		success : function(data) {
			$('#membershipGauge').html(""); //비우기
			let grade = data[0].grade; //등급
			let percentage = data[1].percentage; //비율
			let gradename = data[2].gradename; //등급이름
			let gradeimg;
			let colorPattern = [ '#FFEAB6', '#FFCE55' ];

			//#96ffa1 / #60B044 Green
			//#96ceff / #0022ff Blue
			//#ff9696 /#FF0000 Red
			//#909091 / #000000 Black
			if (grade == 10) {
				//에메랄드
				gradeimg = 'tostone.png';
				colorPattern = [ '#96ffa1', '#60B044' ];
			} else if (grade == 20) {
				//사파이어
				gradeimg = 'sapphire.png';
				colorPattern = [ '#96ceff', '#0022ff' ];
			} else if (grade == 30) {
				//루비
				gradeimg = 'crystals.png';
				colorPattern = [ '#ff9696', '#FF0000' ];
			} else if (grade == 40) {
				//다이아
				gradeimg = 'diamond.png';
				colorPattern = [ '#909091', '#000000' ];
			}
			//====================================
			//이미지 변경
			$('#gradeimg').attr('src', '${path}/rankimg/' + gradeimg);
			//====================================
			//차트
			var chart = c3.generate({
				bindto : '#membershipGauge', //차트 표시될 부분(id)
				data : {
					columns : [ [ gradename, 0 ] ],
					type : 'gauge',
				},
				gauge : {},
				color : {
					pattern : colorPattern,
					threshold : {
						values : [ 50, 100 ]
					}
				},
				size : {
					height : 180
				}
			});
			setTimeout(function() {
				chart.load({
					columns : [ [ gradename, percentage ] ]
				});
			}, 200);
			//====================================
		},
		//에러가 났을 경우 실행시킬 코드
		error : function(e) {
			console.log("error:" + e);
		}
	});
	$(function() {
		$('#delBtn').click(function() {
			alert('탈퇴 되었습니다!');
		});
	});
</script>