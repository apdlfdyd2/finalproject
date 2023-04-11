<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/myPageUI.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/buttonEff.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/myPageRankHover.css"
	rel="stylesheet" />
<div class="wrap" style="max-width: 1000px; margin: 0 auto;">

	<!-- ================================================== -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- ================================================== -->

	<div class="pinkContainer">
		<div>
			<div class="grade">
				<figure>
					<img src="${path}/rankimg/boltstone.png" height="40px" width="45px"
						id="gradeimg">
				</figure>
			</div>
			<div class="green name">${sessionScope.sessionName}님 회원정보</div>

		</div>

		<!-- ================================================== -->
		<!-- 멤버 출력(ResultMap) -->
		<div class="modify"></div>
	</div>
	<c:forEach var="e" items="${mbsvo.member }">
		<div class="summaryContainer">
			<div class="item">
				<div class="rank">${mbsvo.mbsname }</div>
				<div>등급</div>
			</div>
			<div class="item">
				<div class="number">${e.mid }</div>
				<div>아이디</div>
			</div>
			<div class="item">
				<div class="number">${e.mname }</div>
				<div>MBTI</div>
			</div>
		</div>
		<!-- ================================================== -->
		<div class="listContainer">
			<div class="item">
				<div class="icon"></div>
				<div class="text">성별</div>
				<div class="right">${e.gender }</div>
			</div>
			<div class="item">
				<div class="icon"></div>
				<div class="text">(만) 나이</div>
				<div class="right">${e.mage }</div>
			</div>
			<div class="item">
				<div class="icon"></div>
				<div class="text">전화번호</div>
				<div class="right">${e.mphone }</div>
			</div>
			<div class="item">
				<div class="icon"></div>
				<div class="text">이메일 주소</div>
				<div class="right">${e.memail }</div>
			</div>
			<div class="item">
				<div class="icon"></div>
				<div class="text">주소</div>
				<div class="right">${e.maddr }</div>
			</div>
			<div class="item">
				<div class="icon"></div>
				<div class="text">가입일자</div>
				<div class="right">${e.mdate }</div>
			</div>
		</div>
	</c:forEach>
	<!-- ================================================== -->
	<div class="infoContainer">
		<a href="upmemForm" class="item">
			<div>
				<i class="fa-regular fa-chess-queen"></i>
			</div>
			<button type="button">정보수정</button>
		</a> <a href="delmem?mnum=${sessionScope.sessionNum}" class="item">
			<div>
				<i class="fa-solid fa-skull " style="color: #C60B02"></i>
			</div>
			<button type="button" id="delBtn">회원탈퇴</button>
		</a> <a
			href="../customernotice/noticeSearch?searchType=&searchValue=&cPage=1"
			class="item">
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
		//데이터를 주고받을 파일 주소 입력
		url : "../tourCountJson2?mnum=${sessionScope.sessionNum}",
		//작업이 성공적으로 발생했을 경우
		success : function(data) {
			$('#tourCountChart2').html(""); //비우기
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
				bindto : '#tourCountChart2', //차트 표시될 부분(id)
				data : {
					columns : [ [ gradename, percentage ] ],
					type : 'gauge',
				},
				gauge : {
				//        label: {
				//            format: function(value, ratio) {
				//                return value;
				//            },
				//            show: false // to turn off the min/max labels.
				//        },
				//    min: 0, // 0 is default, //can handle negative min e.g. vacuum / voltage / current flow / rate of change
				//    max: 100, // 100 is default
				//    units: ' %',
				//    width: 39 // for adjusting arc thickness
				},
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