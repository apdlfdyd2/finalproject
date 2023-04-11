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
	<!-- 차트 -->
	<!-- Load c3.css -->
	<link href="${path }/css/c3.css" rel="stylesheet">
	<!-- Load d3.js and c3.js -->
	<script src="${path }/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="${path }/js/c3.min.js"></script>
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
			<div class="green name">${sessionScope.sessionName}님 그래프</div>

		</div>
		<!-- ================================================== -->
		<div class="modify"></div>
	</div>
	<div class="summaryContainer">
		<div class="container mt-3" align="center">
			<button class="chartBtn" type="button" id="default">월별 여행 비율</button>
		</div>
		<div class="container mt-3" align="center">
			<button class="chartBtn" type="button" id="visitSpot">방문 여행지</button>
		</div>
		<div class="container mt-3" align="center">
			<button class="chartBtn" type="button" id="periodMax">최대 여행
				기간</button>
		</div>
		<div class="container mt-3" align="center">
			<button class="chartBtn" type="button" id="costType">주 결제 방식</button>
		</div>
		<div class="container mt-3" align="center">
			<button class="chartBtn" type="button" id="costTotal">누적 여행
				비용</button>
		</div>		
	</div>
	<!-- ================================================== -->
	<div class="shippingStatusContainer">
		<div class="title" id="chartTitle"></div>
		<div class="status">
			<div class="item">
				<div>
					<div id="tourCountChart"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- ================================================== -->
</div>
<!-- ================================================== -->

<script>
	$(function() {
		// 현재 선택된 버튼 객체
		let currentBtn = null;

		$('.chartBtn').click(function() {
			// 이전에 선택된 버튼 객체의 스타일 초기화
			if (currentBtn) {
				currentBtn.css({
					'background-color' : '',
					'color' : '',
					'font-size' : ''
				});
			}

			// 현재 선택된 버튼 객체의 스타일 변경
			$(this).css({
				'background-color' : 'aliceblue',
				'color' : 'black',
				'font-size' : '17px'
			});

			// 현재 선택된 버튼 객체 저장
			currentBtn = $(this);

			let btnID = currentBtn.attr('id');
			let url;
			let chartType; //1:도넛 / 2:막대 / 3:꺽은선
			//alert(id);
			if (btnID == 'default') {
				//월 별 여행 횟수 => BookRestController에서 핸들링
				chartType = 1;
				url = "../tourMonthCount?mnum=${sessionScope.sessionNum}";
			} else if (btnID == 'visitSpot') {
				//방문 여행지 => "visitSpot"
				chartType = 1;
				url = "../visitSpotCount?mnum=${sessionScope.sessionNum}";
			} else if (btnID == 'periodMax') {
				//최대 여행 기간 => 
				chartType = 2;
				url = "../periodMaxChart?mnum=${sessionScope.sessionNum}";
			} else if (btnID == 'costType') {
				//주 결제 방식 => costType
				chartType = 2;
				url = "../costTypeChart?mnum=${sessionScope.sessionNum}";
			} else if (btnID == 'costTotal') {
				//누적 여행 비용 => 
				chartType = 3;
				url = "../costTotalChart?mnum=${sessionScope.sessionNum}";
			} 
			
			$.ajaxSetup({
				cache : false
			//캐시삭제
			});

			$.ajax({
				//데이터를 주고받을 파일 주소 입력
				url : url,
				//작업이 성공적으로 발생했을 경우
				success : function(jsondata) {
					$('#tourCountChart').html(""); //비우기
					console.log(jsondata);
					//====================================
					$('#chartTitle').html(jsondata[0].sub);
					if (chartType == 1) { //도넛차트
						var chart = c3.generate({
							bindto : '#tourCountChart', //차트 표시될 부분(id)
							data : { //success해서 받아온 jsondata데이터 핸들링
								json : [ jsondata[1] ], //1번지 => key_달,val_cnt
								keys : {
									value : Object.keys(jsondata[1]),
								},
								type : 'donut'
							},
							donut : {
								title : jsondata[0].sub, //0번지
							},
						});
					} else if (chartType == 2) { //막대 차트
						var chart = c3.generate({
							bindto : '#tourCountChart', //차트 표시될 부분(id)
							data : { //success해서 받아온 jsondata데이터 핸들링
								json : [ jsondata[1] ], //1번지 => key_달,val_cnt
								keys : {
									value : Object.keys(jsondata[1]).sort(),
								},
						        type: 'bar'
						    },
						    bar: {
						        width: {
						            ratio: 0.5 // this makes bar width 50% of length between ticks
						        }
						    }
						});
					} else if (chartType == 3) { //꺽은선 차트
						// x축 데이터 날짜
						let datax = JSON.parse(jsondata[1].datelist.replace(/'/g, "\""));
						// y축 데이터 누적 값
						let datay = JSON.parse(jsondata[2].sumlist.replace(/'/g, "\""));
						
						// 배열 형태로 정리
						let columns = [];
						columns.push(datax);
						columns.push(datay);
						//TEST----------
						//alert(datax);
						//alert(datay);
						//alert(columns);
						//--------------
						var chart = c3.generate({
							bindto : '#tourCountChart', //차트 표시될 부분(id)
							data: {
						        x: 'x',
						        columns: columns,
						        type: 'line'
						    },
						    axis: {
						    	 x: {
						             type: 'timeseries',
						             tick: {
						                 format: '%y/%m/%d'
						             }
						         }
						    }
						});
					}

					//====================================
				},
				//에러가 났을 경우 실행시킬 코드
				error : function(e) {
					console.log("error:" + e);
				}
			});
		});
		$('#default').click();
	});
</script>