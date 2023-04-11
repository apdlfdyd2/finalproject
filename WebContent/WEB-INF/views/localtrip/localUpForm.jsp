<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container">
	<h3>국내여행등록</h3>
	<form action="localUpProcess" method="post"
		enctype="multipart/form-data" id="localupform">



		<div class="form-group">
			<label for="larea">Area</label> <input type="text"
				class="form-control" id="larea" placeholder="지역 입력" name="larea">
		</div>



		<div class="form-group">
			<label for="ltitle">Title</label> <input type="text"
				class="form-control" id="ltitle" placeholder="숙소명 입력"
				name="ltitle">
		</div>



		<div class="form-group">
			<label for="lcontent">Content</label> <input type="text"
				class="form-control" id="lcontent" placeholder="내용 입력"
				name="lcontent">
		</div>

		<div class="input-group mb-3">
			<label class="input-group-text" for="mfile">*이미지업로드</label> <input
				type="file" name="mfile" id="mfile" class="form-control">
		</div>
		<div class="col-sm-10">
			<img id="imgx" src="${ctrpath}/resources/img/logo.png">
		</div>

		<input type="hidden" id="htcode" name="htcode" value="${sessionScope.sessionHNum}"> 

		<div class="form-group">
			<label for="lprice">Price</label> <input type="number"
				class="form-control" id="lprice" placeholder="가격 입력"
				name="lprice" required="required">
		</div>

		<div class="form-group">
			<label for="lkeyword">Keyword</label> <input type="text"
				class="form-control" id="lkeyword" placeholder="keyword 입력 => #구분"
				name="lkeyword">
		</div>

		<div class="form-group">
			<label>Item(최대 10개)</label>
			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<th>No</th>
						<th>iname</th>
						<th>iprice</th>
						<th>iimg</th>
						<th>*이미지업로드</th>
						<th>istock</th>
					</tr>
				</thead>
				<tbody id="item">
					<tr>
						<td>1</td>
						<td><input type="text" name="iname" class="form-control"></td>
						<td><input type="text" name="iprice" class="form-control"></td>
						<td><img id="iimg" src="${ctrpath}/resources/img/logo.png"
							style="width: 137.986px; height: 40.990px;" class="iimg"></td>
						<td><input type="file" name="ifile" class="ifile"></td>
						<td><input type="number" name="istock" value="1" min="1"
							step="1" class="form-control"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<button type="button" id="addBtn" class="btn btn-outline-danger">추가</button>
							<button type="button" id="deleteBtn"
								class="btn btn-outline-secondary">삭제</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>

		<!--		
		<div class="form-group">
			<label for="tsort">tsort</label> <input type="number" class="form-control"
				id="tsort" placeholder="tsort 입력" name="tsort"
				required="required">
		</div>
-->

		<input type="hidden" id="tsort" name="tsort" value="1">


		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">등록</button>


		</div>
	</form>

</div>
<script>
	function readURL(element) {
		//input type = "file"의 주소를 가져옴.
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#imgx').attr('src', e.target.result); //setter
		}
		reader.readAsDataURL(element.files[0]);
	}
	function readItem(i) {
		//input type = "file"의 주소를 가져옴.
		var reader = new FileReader();
		reader.onload = function(e) {
			$('.iimg').eq(i).attr('src', e.target.result); //setter
		}
		reader.readAsDataURL($('.ifile').eq(i).prop('files')[0]);
	}
	//jQuery 문법: main 프로그램, 시발점?
	$(function() {
		//jQuery 선택자
		//대상 선택자에서 변화를 감지하는 이벤트: change()
		//변화가 생겼을 때 function() ~ 이 동작된다.
		$('#mfile').change(function() {
			if ($(this).val().length != 0) {
				//함수 호출
				readURL(this);
			} else {
				console.log("이미지 없습니다.");
			}
		});
		$('.ifile').change(function() {
			if ($(this).val().length != 0) {
				let c = this;

				$('.ifile').each(function(i, element) {
					if (this == c) {
						//함수 호출
						readItem(i)
					}
				})
			} else {
				console.log("이미지 없습니다.");
			}
		});
	});

	$('#addBtn')
			.click(
					function() {
						if ($('#item').children().length < 10) {
							let html = '<tr><td>'
									+ ($('#item').children().length + 1)
									+ '</td>';
							html += '<td><input type="text" name="iname" class="form-control"></td>';
							html += '<td><input type="text" name="iprice" class="form-control"></td>';
							html += '<td><img src="${ctrpath}/resources/img/logo.png" style="width: 137.986px; height: 40.990px;" class="iimg"></td>';
							html += '<td><input type="file" name="ifile'
									+ ($('#item').children().length + 1)
									+ '" class="ifile"></td>';
							html += '<td><input type="number" name="istock" value="1" min="1" step="1" class="form-control"></td></tr>';

							$('#item').append(html);
						}

						$('.ifile').change(function() {
							if ($(this).val().length != 0) {
								let c = this;

								$('.ifile').each(function(i, element) {
									if (this == c) {
										//함수 호출
										readItem(i)
									}
								})
							} else {
								console.log("이미지 없습니다.");
							}
						});
					})
	$('#deleteBtn').click(
			function() {
				if ($('#item').children().length > 1) {
					$('#item').children('tr').eq(
							$('#item').children('tr').length - 1).remove();
				}
			})
</script>