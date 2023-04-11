<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<h3>해외여행</h3>
<!-- carousel : 이벤트/기획.. -->
<div class="slider_area">
	<div class="slider_active owl-carousel">
		<div
			class="single_slider  d-flex align-items-center slider_bg_1 overlay">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-12 col-md-12">
						<div class="slider_text text-center">
							<h3>해외여행</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div
			class="single_slider  d-flex align-items-center slider_bg_2 overlay">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-12 col-md-12">
						<div class="slider_text text-center">
							<h3>어떻게꾸밀까</h3>
							<p>이벤트같은거 넣나?</p>
							<a href="#" class="boxed-btn3">바로가기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div
			class="single_slider  d-flex align-items-center slider_bg_3 overlay">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-12 col-md-12">
						<div class="slider_text text-center">
							<h3>Enjoyment</h3>
							<p></p>
							<a href="#" class="boxed-btn3">바로가기 버튼</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- carousel : slider_area_end -->

<!-- recommen -->
<div class="popular_places_area">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="section_title text-center mb_70">
					<h3>해외여행</h3>
					<p>해외여행 / 컨텐츠 어떻게 할까용</p>
				</div>
			</div>
		</div>
		<div>
		<h1>리스트출력하자</h1>
		<a href="${ctrpath}/oversea/overseaUpForm"><button>등록하기</button></a>
		&nbsp;
		<a href="${ctrpath}/oversea/overseaboardList"><button>리스트</button></a>
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