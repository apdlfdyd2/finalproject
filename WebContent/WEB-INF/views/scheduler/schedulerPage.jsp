<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--2023. 2. 3./Kosmo--%>
<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 200;
	font-style: normal;
}

body {
	font-family: 'Pretendard-Regular';
}

.input-box {
	padding: 20px;
}

.input-box input {
	width: 200px;
	height: 30px;
}

.input-box #plus {
	display: inline-block;
	width: 100px;
	height: 35px;
	text-align: center;
	text-decoration: none;
	color: #000;
	background: lavender;
	border-radius: 10px;
}

.form-select {
	width: 150px;
	margin: 0 auto;
}

.container {
	display: flex;
	gap: 30px;
	max-width: 1230px;
	min-height: 300px;
	margin: 0 auto;
	margin-bottom: 100px;
}

.column {
	flex-basis: 20%;
	background: gainsboro;
	height: 70vh;
	padding: 5px;
	border-radius: 10px;
}

.column2 {
	flex-basis: 50%;
	background: gainsboro;
	height: 70vh;
	padding: 10px;
	border-radius: 10px;
}

.column3 {
	flex-basis: 60%;
	background: gainsboro;
	height: 70vh;
	padding: 5px;
	border-radius: 10px;
}

#sortablediv {
	background: white;
	border-radius: 10px;
	min-height: 550px;
	padding: 5px;
}

h1 {
	text-align: center;
	font-size: 22px;
}

.list-group-item {
	text-align: center;
	background: #fff;
	margin: 20px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

.ui-state-default {
	text-align: center;
	background: #fff;
	margin: 8px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

td {
	text-align: center;
	background: #fff;
	margin: 5px;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

/* ==============제목==================*/
.nine h1 {
	text-align: center;
	font-size: 50px;
	text-transform: uppercase;
	color: #222;
	letter-spacing: 1px;
	font-family: "Playfair Display", serif;
	font-weight: 400;
}

.nine h1 span {
	margin-top: 5px;
	font-size: 15px;
	color: #444;
	word-spacing: 1px;
	font-weight: normal;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-family: "Raleway", sans-serif;
	font-weight: 500;
	display: grid;
	grid-template-columns: 1fr max-content 1fr;
	grid-template-rows: 27px 0;
	grid-gap: 20px;
	align-items: center;
}

.nine h1 span:after, .nine h1 span:before {
	content: " ";
	display: block;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	height: 5px;
	background-color: #f8f8f8;
}

/* ============버튼====================*/
.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-weight: 500;
	background: whitesmoke;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

button {
	margin: 20px;
}

/**/
.btn-16 {
	border: none;
	color: #000;
}

.btn-16:after {
	position: absolute;
	content: "";
	width: 0;
	height: 100%;
	top: 0;
	left: 0;
	direction: rtl;
	z-index: -1;
	box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9, 7px 7px
		20px 0px #0002, 4px 4px 5px 0px #0001;
	transition: all 0.3s ease;
}

.btn-16:hover {
	color: #000;
}

.btn-16:hover:after {
	left: auto;
	right: 0;
	width: 100%;
}

.btn-16:active {
	top: 2px;
}
/* ===================table====================*/
table {
	border: 1px #a39485 solid;
	font-size: .9em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	width: 100%;
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
}

/* ===================input====================*/
#input-list-btn {
	width: 300px;
	height: 36px;
	font-size: 15px;
	border: 0;
	border-radius: 15px;
	outline: none;
	margin-left: 5px;
	padding: 0px 40px 0px 20px;
	background-color: rgba(230, 233, 234, 0.94);
	box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9, 7px 7px
		20px 0px #0002, 4px 4px 5px 0px #0001;
}
/* ===================input====================*/
.btnspace {
	margin: 0 auto;
	float: right;
}
</style>
<!-- css/js -->
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js" integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous"></script>
<script>
	$(function() {
		// ================숙소 ajax======================
		// ==============================================
		$("#accom")
				.click(
						function() {
							$.ajaxSetup({
								cache : false
							});

							$
									.ajax({
										url : "../schedulerRest/showList",
										success : function(json) {
											$('#target').html("");
											var e = JSON.stringify(json,
													[ 'ltitle' ]);
											//console.log(json[0]['ltitle']);

											$
													.each(
															json,
															function(k, v) {

																//console.log(k + ":" + v);
																let htmlTag = '<tr>';
																$
																		.each(
																				v,
																				function(
																						i,
																						j) {
																					if (j !== 0
																							& j !== null) {
																						//console.log(i + ":" + j);
																						htmlTag += '<td class="roomlist" id="' + j + '">'
																								+ j
																								+ "</td>";
																					}
																					//<label class="deleteBox">[삭제]</label>
																				});
																htmlTag += "</tr>";
																$('#target')
																		.append(
																				htmlTag);
															});
										}
									});
						});

		//--------------------------------------------

		$(document)
				.on(
						"click",
						".roomlist",
						function() {
							var roomvalue = document
									.getElementsByClassName("roomlist")[1];
							console.log(roomvalue);
							var roomval = document
									.getElementsByClassName("roomlist")[4].id
							console.log('roomval: ' + roomval);
							$(".sort_list")
									.append(
											'<li class="ui-state-default" draggable="true" id="' + roomval + '">'
													+ roomval
													+ '<label class="deleteBox">[삭제]</label></li>')
						});

		// ================맛집 ajax======================
		// ==============================================
		$("#rest")
				.click(
						function() {
							$.ajaxSetup({
								cache : false
							});

							$
									.ajax({
										url : "../schedulerRest/restList",
										success : function(json) {
											$('#target').html("");
											$
													.each(
															json,
															function(k, v) {
																let htmlTag = '<tr class="styled-table">';
																$
																		.each(
																				v,
																				function(
																						i,
																						j) {
																					if (j !== 0
																							& j !== null) {
																						console
																								.log(i
																										+ ":"
																										+ j);
																						htmlTag += '<td class="restlist" id="' + j + '">'
																								+ j
																								+ "</td>";
																					}
																					//<label class="deleteBox">[삭제]</label>
																				});
																htmlTag += "</tr>";
																$('#target')
																		.append(
																				htmlTag);
															});
										}
									});
						});

		$(document)
				.on(
						"click",
						".restlist",
						function() {
							var restvalue = $('.restlist').val();
							var restval = document
									.getElementsByClassName("restlist")[1].id
							console.log(restval);
							$(".sort_list")
									.append(
											'<li class="ui-state-default" draggable="true" id="' + restval + '">'
													+ restval
													+ '<label class="deleteBox">[삭제]</label></li>')
						});

		// ===================출발=======================
		// ==============================================
		$("#departure").click(function() {
			$("#depart").toggle();
		});

		// ===================귀가=======================
		// ==============================================
		$("#gohome").click(function() {
			$("#home").toggle();
		});
	});
</script>



<div id='showsortable'></div>
<div class="nine">
	<h1 class="animate__animated animate__fadeIn">
		Scheduler <span>Just Drag And Drop your way</span>
	</h1>
</div>


<div class="container">
	<div class="column">
		<h1>Options</h1>
		<%-- ----------------select---------------- --%>
		<div>
			<select class="form-select">
				<option selected>여행 지역</option>
				<option value="1">서울</option>
				<option value="2">인천</option>
				<option value="3">경기</option>
				<option value="4">충청</option>
				<option value="5">전라</option>
				<option value="6">경상</option>
				<option value="7">강원</option>
				<option value="8">제주</option>
			</select>
		</div>
		<%-- ----------------select---------------- --%>

		<button class="custom-btn btn-16" id="departure">출발</button>
		<button class="custom-btn btn-16" id="accom">숙소</button>
		<button class="custom-btn btn-16" id="rest">맛집</button>
		<button class="custom-btn btn-16" id="tour" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@fat">일정 추가</button>
		<button class="custom-btn btn-16" id="gohome">귀가</button>


		<%--------------------모달----------------------%>
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">&#128147;일정 추가하기&#128147;</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="input-box">
							<input type="text" name="input-list" id="input-list-btn"> <a href="javascript:;" id="plus" class="custom-btn btn-16">추가</a>
						</div>

					</div>
				</div>
			</div>
		</div>
		<%--------------------모달----------------------%>
	</div>


	<div class="column2">
		<h1>Options</h1>
		<table>
			<tbody id="target">
			</tbody>
		</table>
	</div>


	<div class="column3">

		<h1>Schedule</h1>

		<div id="sortablediv">
			<ul id="sortable-list" class="sort_list">
				<li class="ui-state-default" draggable="true" id="depart" value="depart" style="display: none;">출발<label class="deleteBox"> [삭제]</label></li>

				<li class="ui-state-default" draggable="true" id="home" value="home" style="display: none;">귀가<label class="deleteBox"> [삭제]</label></li>
			</ul>


		</div>

		<input type="hidden" value="${sessionScope.sessionID}" name="scmem" id="scmem"> <input type="hidden" value="" name="sclist">
		<div class="btnspace">
			<button type="button" id="savebtn" class="custom-btn btn-16" onclick="savesche()" data-toggle="modal" data-target="#modalAbandonedCart" id="btn-test">저장하기</button>
			<a href="../scheduler/scheduleList?scmem=${sessionScope.sessionID}"><button type="button" class="custom-btn btn-16">일정보기</button></a>
		</div>
		<!-- Button trigger modal-->


		<!-- Modal: modalAbandonedCart-->
		<!-- https://mdbootstrap.com/docs/b4/jquery/modals/additional/ -->
		<div class="modal fade right" id="modalAbandonedCart" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
			<div class="modal-dialog modal-side modal-bottom-right modal-notify modal-info" role="document">
				<!--Content-->
				<div class="modal-content">
					<!--Header-->
					<div class="modal-header">
						<p class="heading">Scheduler</p>

						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true" class="white-text">&times;</span>
						</button>
					</div>

					<!--Body-->
					<div class="modal-body">

						<div class="row">
							<div class="col-3">
								<p></p>
								<p class="text-center"></p>
							</div>

							<div class="col-9">
								<p>&#127799;일정이 저장되었습니다.&#127799;</p>
								<p>
									<span id='sortedList'></span>
								</p>
								<a id="kakaotalk-sharing-btn" href="javascript:;"> <img src="https://developers.kakao.com/assets/img/about/logos/kakaotalksharing/kakaotalk_sharing_btn_medium.png" alt="카카오톡 공유 보내기 버튼" />
								</a>
							</div>
						</div>
					</div>

					<!--Footer-->
					<div class="modal-footer justify-content-center">
						<a type="button" class="btn btn-outline-info waves-effect" data-dismiss="modal">확인</a>
					</div>
				</div>
				<!--/.Content-->
			</div>
		</div>
		<!-- Modal: modalAbandonedCart-->
	</div>
</div>

<button></button>


<script>
	//============================ sortable ============================
	$(".sort_list").sortable({
		//placeholder : "itemBoxHighlight", /* 이동할 위치 css 적용  */
		//used to define the cursor that is being shown while sorting the elements
		cursor : "move",

		//이벤트 발생 시 변경되는 내용 적용
		update : function(event, ui) {
			var test = this.id;
			var test2 = this;
			console.log('test:' + test);
			console.log('test2:' + test2);
			console.log('type of test:' + typeof test);

			// var listArray = $(this).sortable('serialize');
			// console.log(listArray);
			// $("#showsortable").text(listArray);

			var listArray = $(this).sortable('toArray').toString();
			console.log(listArray);
		}
	}).disableSelection();

	//============================ sortable ============================

	//============================ plus 버튼 눌렀을 때 ============================
	$("#plus")
			.on(
					'click',
					function() {
						//form칸에 입력받은 값 받아오기
						var inputTxt = $("#input-list-btn").val();
						console.log(inputTxt);
						//입력받은 값을 <li>로 추가해주기
						if (inputTxt === "") {
							alert("값을 입력하세요!");
						} else {
							$(".sort_list")
									.append(
											'<li class="ui-state-default" draggable="true" id="'+inputTxt+'" value="'+inputTxt+'">'
													+ inputTxt
													+ '<label class="deleteBox">[삭제]</label></li>')
									.trigger("create");
							$("#input-list-btn").val('');
						}

					});
	//============================ plus 버튼 눌렀을 때 ============================

	//============================ saveSche 버튼 눌렀을 때 ============================
	function savesche() {
		const savesche = $('#sortable-list').sortable("toArray");
		console.log(savesche);
		$("#sortedList").text(savesche);
		$('input[name=sclist]').attr('value', savesche.toString());
	}
	//============================ saveSche 버튼 눌렀을 때 ============================

	//============================ insert ============================
	$("#savebtn")
			.on(
					'click',
					function() {
						var scmem = $('#scmem').val();
						var sclist = $('#sortable-list').sortable("toArray")
								.toString();
						var saveAll = {
							'scmem' : scmem,
							'sclist' : sclist,
						};
						console.log("-------------------------------------");
						console.log(saveAll);
						alert(saveAll.scmem + ":" + saveAll.sclist);

						console.log(JSON.stringify(saveAll));

						$.ajax({
							url : "../schedulerRest/scheduleInsert?sclist="
									+ saveAll.sclist + "&scmem="
									+ saveAll.scmem,
							//type : "POST",
							//data : saveAll,
							success : function(data) {
								console.log('DB연동 성공!');
							}
						})
					});
	//============================ insert ============================

	//============================ deleteBox 버튼 눌렀을 때 ============================

	$(".deleteBox").on('click', function() {
		//unwrap() : 선택한 요소의 부모 요소 삭제
		//parent().remove()
		$(this).parent().remove();
	});
	//============================ deleteBox 버튼 눌렀을 때 ============================

	// ============================================================================
	Kakao.init('97518b6a1893b484e09b62cd6f8444be'); // 사용하려는 앱의 JavaScript 키 입력
	Kakao.Share
			.createDefaultButton({
				container : '#kakaotalk-sharing-btn',
				objectType : 'feed',
				content : {
					title : '공주님 놀러가자! 여행 스케줄 공유',
					description : '#여행#나만의스케줄#공주님',
					imageUrl : 'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
					link : {
						// [내 애플리케이션] > [플랫폼] 에서 등록한 사이트 도메인과 일치해야 함
						mobileWebUrl : 'http://localhost/dTeam_semi_tour/scheduler/schePath',
						webUrl : 'http://localhost/dTeam_semi_tour/scheduler/schePath',
					},
				},
				social : {
					likeCount : 286,
					commentCount : 45,
					sharedCount : 845,
				},
				buttons : [ {
					title : '웹으로 보기',
					link : {
						mobileWebUrl : 'https://developers.kakao.com',
						webUrl : 'https://developers.kakao.com',
					},
				}, {
					title : '앱으로 보기',
					link : {
						mobileWebUrl : 'https://developers.kakao.com',
						webUrl : 'https://developers.kakao.com',
					},
				}, ],
			});
</script>
