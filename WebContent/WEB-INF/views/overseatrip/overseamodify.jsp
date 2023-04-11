<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>overseamodify.jsp</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container">
	<h3>국내여행등록</h3>
	<form action="overseamodify" method="post" enctype="multipart/form-data"
		id="overseamodifyform">


		<div class="form-group">
			<label for="oarea">oarea</label> <input type="text"
				class="form-control" id="oarea" placeholder="${vo.oarea}"
				name="oarea">
		</div>



		<div class="form-group">
			<label for="ottitle">ottitle</label> <input type="text"
				class="form-control" id="ottitle" placeholder="${vo.ottitle}"
				name="ottitle">
		</div>



		<div class="form-group">
			<label for="ocontent">ocontent</label> <input type="text"
				class="form-control" id="ocontent" placeholder="${vo.ocontent}"
				name="ocontent">
		</div>



		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">*이미지업로드</label>
			<div class="col-sm-10">
				<input type="file" name="mfile" id="mfile">
			</div>
			<div class="col-sm-10">
				<img id="imgx" src="${ctrpath}/resources/img/${vo.oimg}">
			</div>
		</div>
		<input type="hidden" id="ono" name="ono" value="${vo.ono}">

		<!--  
		<div class="form-group">
			<label for="htcode">htcode</label> <input type="number" class="form-control"
				id="htcode" placeholder="htcode 입력" name="htcode" maxlength="15"
				required="required">
		</div>
	-->


		<div class="form-group">
			<label for="oprice">oprice</label> <input type="number"
				class="form-control" id="oprice" placeholder="${vo.oprice}"
				name="oprice" required="required">
		</div>


		<!--		
		<div class="form-group">
			<label for="tsort">tsort</label> <input type="number" class="form-control"
				id="tsort" placeholder="tsort 입력" name="tsort"
				required="required">
		</div>
-->




		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">수정</button>


		</div>
	</form>

</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	//javascript는 클라이언트 측 언어
	//HTML, CSS를 동적으로 제어하는 목적으로 주로 사용
	//html5부터 제공하는 filereader()함수를 사용해 이미지 미리보기 구현
	//함수는 메서드와 비슷

	/*
	 * 메서드: pulic void readURL(String input){}
	 * 변수: String reader => var reader
	 */

	function readURL(input) {
		//input type = "file"의 주소를 가져옴. 
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#imgx').attr('src', e.target.result); //setter
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	//jQuery 문법: main 프로그램, 시발점?
	$(function() {
		//jQuery 선택자
		//대상 선택자에서 변화를 감지하는 이벤트: chagne()
		//변화가 생겼을 때 function() ~ 이 동작된다.
		$('#mfile').change(function() {

			if ($(this).val().length > 0) {
				//함수 호출
				readURL(this);
			} else {
				console.log("이미지 없습니다.");
			}

		});

	});
</script>

