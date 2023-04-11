<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />

<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="${path}/css/faqDesign.css" />
</head>

<section class="faq-section">
	<div class="container">
		<div class="row">
			<!-- ***** FAQ Start ***** -->
			<div class="col-md-6 offset-md-3">

				<div class="faq-title text-center pb-3">
					<h2>FAQ</h2>
				</div>
			</div>
			<div class="col-md-6 offset-md-3">
				<div class="faq" id="accordion">
					<div class="card">
						<div class="card-header" id="faqHeading-1">
							<div class="mb-0">
								<h5 class="faq-title" data-toggle="collapse"
									data-target="#faqCollapse-1" data-aria-expanded="true"
									data-aria-controls="faqCollapse-1">
									<span class="badge">1</span> 여행상품 예약은 어떻게 하나요 ?
								</h5>
							</div>
						</div>
						<div id="faqCollapse-1" class="collapse"
							aria-labelledby="faqHeading-1" data-parent="#accordion">
							<div class="card-body">
								<p>
									▶여행상품의 예약은 온라인상에서, 전화, 또는 e-mail을 통해 문의 및 예약하실수 있으며,<br>
									365일 24시간 언제든지 예약하실 수 있습니다. <br>(전화상담 가능시간 평일 09:00~18:00
									/ 토,일요일 및 공휴일 휴무)<br> <br> ▶예약후 영업일기준 24시간내에 고객께 전화나
									메일로 여행 출발일로부터 종료일까지 예약의 전반적인 사항을 체크하여 처리해 드립니다.<br> <br>
									▶온라인상 예약은 최소 여행 출발일 10일전에 하셔야 하며, 그외경우 담당자에게 문의후 예약 바랍니다.<br>
									<br> ▶여권과 비자 발급 받는데는 얼마간의 시일이 걸리기 때문에 충분한 수속기간을 두고 여행계획을
									세우시 는게 좋습니다.<br> (최소발급기한- 여권:6일, visa: 나라별로 상이함)<br>
									<br> ▶단체여행(패키지상품)인 경우, 상품출발 최소인원(보통 10명)이 모집되지 않았을 때 출발하지
									않는 상품 도 있습니다. <br>이러한 경우는 담당자가 연락을 드립니다.<br> <br>
									[ 예약시 필요사항 ] <br>- 여행자의 정확한 영문성명(여권과 동일한 영문) <br>-
									주민번호 /여행일정(출발일) - 예약자 연락처(전화, 핸드폰, 메일주소) <br>- 여권/비자 유무,
									유효기간
								</p>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-2">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-2" data-aria-expanded="false"
										data-aria-controls="faqCollapse-2">
										<span class="badge">2</span> 온라인상에서 실시간으로 예약할 수 있나요?
									</h5>
								</div>
							</div>
							<div id="faqCollapse-2" class="collapse"
								aria-labelledby="faqHeading-2" data-parent="#accordion">
								<div class="card-body">
									<p>
										예. 가능합니다.<br> <br> 온라인상에서의 예약은 금일을 기준으로 10일 이후의 날짜의
										예약일경우 좌석이 여유가 있으면 가능합니다.<br> <br> 단, 마감이 안된 단체라도
										10일이내의 예약인경우는 대기예약으로 들어가며, 추후 좌석상황이나 최소출발인원여부에 따라 출발하지 못하실 수도
										있습니다.<br> <br> <br>예약순서는<br> 1. 홈페이지에서
										상품으로 바로 들어가거나, 보다 자세한 조건으로 검색하는 '상세검색' , 생각나는 키워드를 치면 해당 상품이
										나오는 '키워드 검색' 등을 통해 상품을 찾습니다. <br> <br> 2. 원하는 상품명을
										고르신후 해당 날짜를 선택합니다. <br> <br> 3. 날짜를 선택하면 그날짜에 등록되어있는
										선택하신 상품이 조건과 함께 나열됩니다. 그곳에서 '상세일정'을 클릭하여 일정을 확인하거나, 바로 예약버튼을
										클릭합니다. <br> <br> 4. '상세일정'을 클릭하시면 해당상품의 자세한 정보를
										확인하신후 예약버튼을 클릭합니다. <br> <br> 5. 예약자정보와 여행자정보,
										객실사용여부, 결제사항을 체크합니다. <br> <br> 6. 결제사항에서 결제정보를 입력하시면
										예약이 완료됩니다. <br> <br> 7. 완료된 예약과 결제사항은 메일로 전송되며, 담당자를
										통해 확인하시면 됩니다.
									</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-3">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-3" data-aria-expanded="false"
										data-aria-controls="faqCollapse-3">
										<span class="badge">3</span> 예약조회를 하고싶습니다.
									</h5>
								</div>
							</div>
							<div id="faqCollapse-3" class="collapse"
								aria-labelledby="faqHeading-3" data-parent="#accordion">
								<div class="card-body">
									<p>
										예약번호와 함께 주민등록번호 또는 여권번호를 기입하면 고객님의 예약상황을 확인하실 수 있습니다.<br>
										예약조회중 예약자 명으로 조회시 예약자내용으로 입력된 전체 여행자의 내용을 확인하실 수 있으며, 실제
										여행자명으로 조회하시면 여행자 본인과 예약상황만 확인할 수 있습니다. <br> <br>
										예약조회중 여러분의 결제내역도 확인이 가능하며, 여행상품의 잔금의 결제도 가능합니다. 무통장 입금의 확인은
										입금후 2일이 지난후에 가능하며, 무통장 입금을 하셨는데 만약 입금처리가 안되어 있는경우 담당자에게 연락하여
										주시기 바랍니다. <br> <br> 예약취소나 여행자 정보 변경을 원하시면 고객님이 선택하신
										여행사 담당자에게 연락해 주세요.
									</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-4">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-4" data-aria-expanded="false"
										data-aria-controls="faqCollapse-4">
										<span class="badge">4</span> 예약을 취소하고 싶습니다.
									</h5>
								</div>
							</div>
							<div id="faqCollapse-4" class="collapse"
								aria-labelledby="faqHeading-4" data-parent="#accordion">
								<div class="card-body">
									<p>
										인터넷상에서 예약취소나 수정은 불가능합니다.<br>예약취소나 여행자정보 변경을 원하시면 반드시
										담당자에게 연락을 주셔야 합니다.<br> 모든 취소는 근무일(공휴일 및 토, 일요일 제외) 및
										근무시간(18시 30분까지) 내에 취소요청을 해주시기 바랍니다.<br> <br> 또한 여행자의
										여행계약 해제 요청이 있는 경우 여행약관에 의거 소정의 취소료비용이 발생할 수 있습니다.<br> <br>
										[여행약관]<br> 제16조(여행출발 전 계약해제)<br> - 여행출발일 ~30일전까지 취소
										통보시 - 계약금 환급<br> - 여행출발일 29~20일전까지 취소 통보시 - 여행요금의 10% 배상<br>
										- 여행출발일 19~10일전까지 취소 통보시 - 여행요금의 15% 배상<br> - 여행출발일
										9~8일전까지 취소 통보시 - 여행요금의 20% 배상<br> - 여행출발일 7~1일전까지 취소 통보시
										- 여행요금의 30% 배상<br> - 여행출발 당일 취소 통보시 - 여행요금의 50% 배상<br>
										(*공정거래위원회 고시 제2014-4호 소비자분쟁해결기준에 의한 것으로 적용됩니다.)<br> <br>
										[특별약관]<br> 일부 상품은 상품 구성의 특성상 특별약관이 부과됩니다.<br> 여행고객의
										해당 일정표의 취소료 규정을 확인하시기 바랍니다.<br> 일반약관 제 6조(특약)에 의거하여 특별약관은
										운영됩니다.
									</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-5">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-5" data-aria-expanded="false"
										data-aria-controls="faqCollapse-5">
										<span class="badge">5</span> 여행요금의 입금은 어떻게 해야 합니까?
									</h5>
								</div>
							</div>
							<div id="faqCollapse-5" class="collapse"
								aria-labelledby="faqHeading-5" data-parent="#accordion">
								<div class="card-body">
									<p>
										여행요금은 예약후 2일 이내 예약금을 입금하셔야 하며, 여행출발전 1주일 이내 완납을 하셔야 합니다.<br>
										예약금은 보통 여행경비의10%정도 입금하면 되며 입금후 전화나 e-mail주시면 더욱 신속하게 처리됩니다.
									</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-6">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-6" data-aria-expanded="false"
										data-aria-controls="faqCollapse-6">
										<span class="badge">6</span> 상품찜은 어떻게 사용하나요?
									</h5>
								</div>
							</div>
							<div id="faqCollapse-6" class="collapse"
								aria-labelledby="faqHeading-6" data-parent="#accordion">
								<div class="card-body">
									<p>
										여행상품을 고르다가 관심 가는 여행상품이 있으시죠? 그럼 상품찜을 해보세요.<br> <br>
										상품찜은 일정표를 보시다가 상품찜 버튼을 클릭하시면 해당상품이 상품찜이라는 곳에 저장이 됩니다.<br>
										<br> 찜한 상품은 상단의 '상품찜'이라는 곳에서 확인하실 수 있으며, 회원인경우 로그인을 하시면
										직접 목록을 삭제하기 전까지 영구 저장됩니다.<br> <br> 찜한상품의 비교나 삭제, 예약시
										원하시는 상품의 선택박스를 체크후 하단의 해당버튼을 클릭하세요.<br> <br> 모처럼의
										여행.. 요모조모 비교하고 따져보고 알차게 골라보세요.
									</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="faqHeading-7">
								<div class="mb-0">
									<h5 class="faq-title" data-toggle="collapse"
										data-target="#faqCollapse-7" data-aria-expanded="false"
										data-aria-controls="faqCollapse-7">
										<span class="badge">7</span> 카드결제한 금액의 승인을 취소하고 싶은데요?
									</h5>
								</div>
							</div>
							<div id="faqCollapse-7" class="collapse"
								aria-labelledby="faqHeading-7" data-parent="#accordion">
								<div class="card-body">
									<p>
										승인취소를 원하시면 예약담당자에게 바로 통지하여 주셔야 합니다.<br> 승인취소는 결제가 완료된후
										24시간내에는 바로가능하며, 이후 요구되는 취소는 4~5일정도 기간이 소요될 수 있습니다. (해외항공권 제외)
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>