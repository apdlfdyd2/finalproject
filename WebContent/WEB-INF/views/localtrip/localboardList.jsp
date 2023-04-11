<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<script>
	$.ajaxSetup({
		cache : false
	});

	$.ajax({
	url: "../reviewRest/getavg?recode="+${vo.lno},
	success: function (json) {
		console.log("����: " + json);
		if(json !== null){
			$('#starAvg').html(json +"��");
		} else if(json === null) {
			$('#starAvg').html("���� �򰡰� �����!");
		}
		
		}
	});
</script>

<!-- carousel : �̺�Ʈ/��ȹ.. -->

<!-- carousel : slider_area_end -->
<!-- recommen -->

	

<div class="popular_places_area">
<!-- ��õ���� Start -->
<div class="col-xl-6 col-lg-6" style=" padding:10px; margin: 0 auto; height: auto;">
<div class="header-area " >
		<div id="sticky-header" class="main-header-area">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
											<li><a href="#">������ <i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=seoul">����</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=gapyeong">����</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=uijeongbu">������</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=busan">�λ�</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=incheon">��õ</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=1&searchValue=jeju">����</a></li>
												</ul>
											</li>
											<li><a href="#">�׸��� <i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="${ctrpath}/local/localboardList?searchType=2&searchValue=ȣ��">ȣ��</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=2&searchValue=���">���</a></li>
													<li><a href="${ctrpath}/local/localboardList?searchType=2&searchValue=ķ��">ķ��</a></li>
												</ul>
											</li>
											<li><a href="#">MBTI�� I<i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="${ctrpath}/recommend/home">INFJ</a></li>
													<li><a href="${ctrpath}/recommend/home">INFP</a></li>
													<li><a href="${ctrpath}/recommend/home">INTJ</a></li>
													<li><a href="${ctrpath}/recommend/home">INTP</a></li>
													<li><a href="${ctrpath}/recommend/home">ISFJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ISFP</a></li>
													<li><a href="${ctrpath}/recommend/home">ISTJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ISTP</a></li>
													

												</ul>
											</li>
											<li><a href="#">MBTI�� E<i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="${ctrpath}/recommend/home">ENFJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ENFP</a></li>
													<li><a href="${ctrpath}/recommend/home">ENTJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ENTP</a></li>
													<li><a href="${ctrpath}/recommend/home">ESFJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ESFP</a></li>
													<li><a href="${ctrpath}/recommend/home">ESTJ</a></li>
													<li><a href="${ctrpath}/recommend/home">ESTP</a></li>

												</ul>
											</li>
									</ul>
								</nav>
			</div>
		</div>
	</div>
	
	</div>
	<!-- ��õ���� End -->
	<div class="container">
		<div class="row">

			<c:forEach var="e" items="${list}">
				<div class="col-lg-4 col-md-6">
					<div class="single_place">
						<div class="thumb">
							<img src="${path}/imgfile/${e.limg}" height="300" width="200">
							<a href="#" class="prise">$<fmt:formatNumber value="${e.lprice}" pattern="###,###" /></a>
						</div>
						<div class="place_info">
							<a href="localdetail?num=${e.lno}"><h3>${e.ltitle}</h3></a>
							<p>${e.lcontent}</p>
							<div class="rating_days d-flex justify-content-between">
								<span class="d-flex justify-content-center align-items-center">
									<!-- ����(���) id="starAvg" --> <i
									class="fa fa-star"></i>
									<a href="#">${e.starAvg}/5</a>
								</span>
								<div class="days">
									<!-- ����(����) id="reviewCnt" --> <a
									href="#">(${e.renoCnt} Review)</a>
								</div>
								<!--  
								<div class="days">
									<i class="fa fa-clock-o"></i> <a href="#">5 Days</a>
								</div>
								-->
							</div>
						</div>
					</div>
				</div>
			</c:forEach>



		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="more_place_btn text-center">
					<a class="boxed-btn4" href="#">More Places</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- recommen -->

<!-- reviewDetail : recent_trip_area  -->
<div class="recent_trip_area">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="section_title text-center mb_70">
					<h3>Recent Trips</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="single_trip">
					<div class="thumb">
						<img src="${path}/img/trip/1.png" alt="">
					</div>
					<div class="info">
						<div class="date">
							<span>Oct 12, 2019</span>
						</div>
						<a href="#">
							<h3>Journeys Are Best Measured In New Friends</h3>
						</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_trip">
					<div class="thumb">
						<img src="${path}/img/trip/2.png" alt="">
					</div>
					<div class="info">
						<div class="date">
							<span>Oct 12, 2019</span>
						</div>
						<a href="#">
							<h3>Journeys Are Best Measured In New Friends</h3>
						</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_trip">
					<div class="thumb">
						<img src="${path}/img/trip/3.png" alt="">
					</div>
					<div class="info">
						<div class="date">
							<span>Oct 12, 2019</span>
						</div>
						<a href="#">
							<h3>Journeys Are Best Measured In New Friends</h3>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- reviewDetail : recent_trip_area  -->