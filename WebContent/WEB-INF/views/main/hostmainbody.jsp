<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<!-- search : where_togo_area_start  -->
<div class="where_togo_area">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-3">
				<div class="form_area">
					<h3>What information do you want to search?</h3>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="search_wrap">
					<form class="search_form" action="#">
						<div class="input_field">
							<input type="text" placeholder="Where to go?">
						</div>
						<div class="input_field">
							<select>
								<option data-display="Travel type">Travel type</option>
								<option value="1">국내여행</option>
								<option value="2">해외여행</option>
							</select>
						</div>
						<div class="search_btn">
							<button class="boxed-btn4 " type="submit">Search</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- search : where_togo_area_end  -->

<!-- hotplace : popular_destination_area_start  -->
<div class="popular_destination_area">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="section_title text-center mb_70">
					<h3>Popular Destination</h3>
					<p>Suffered alteration in some form, by injected humour or good
						day randomised booth anim 8-bit hella wolf moon beard words.</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/1.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							Italy <a href="travel_destination.html"> 07 Places</a>
						</p>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/2.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							Brazil <a href="travel_destination.html"> 03 Places</a>
						</p>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/3.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							America <a href="travel_destination.html"> 10 Places</a>
						</p>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/4.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							Nepal <a href="travel_destination.html"> 02 Places</a>
						</p>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/5.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							Maldives <a href="travel_destination.html"> 02 Places</a>
						</p>

					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="single_destination">
					<div class="thumb">
						<img src="${path}/img/destination/6.png" alt="">
					</div>
					<div class="content">
						<p class="d-flex align-items-center">
							Indonesia <a href="travel_destination.html"> 05 Places</a>
						</p>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- hotplace : popular_destination_area_end  -->

<!-- review : testimonial_area  -->
<div class="testimonial_area">
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				<div class="testmonial_active owl-carousel">
					<div class="single_carousel">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<div class="single_testmonial text-center">
									<div class="author_thumb">
										<img src="${path}/img/testmonial/author.png" alt="">
									</div>
									<p>"Working in conjunction with humanitarian aid agencies,
										we have supported programmes to help alleviate human
										suffering.</p>
									<div class="testmonial_author">
										<h3>- Micky Mouse</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="single_carousel">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<div class="single_testmonial text-center">
									<div class="author_thumb">
										<img src="${path}/img/testmonial/author.png" alt="">
									</div>
									<p>"Working in conjunction with humanitarian aid agencies,
										we have supported programmes to help alleviate human
										suffering.</p>
									<div class="testmonial_author">
										<h3>- Tom Mouse</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="single_carousel">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<div class="single_testmonial text-center">
									<div class="author_thumb">
										<img src="${path}/img/testmonial/author.png" alt="">
									</div>
									<p>"Working in conjunction with humanitarian aid agencies,
										we have supported programmes to help alleviate human
										suffering.</p>
									<div class="testmonial_author">
										<h3>- Jerry Mouse</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- review : testimonial_area  -->