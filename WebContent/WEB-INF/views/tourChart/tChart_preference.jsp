<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

	<!-- Load c3.css -->
	<link href="${path}/css/c3.css" rel="stylesheet">

	<!-- Load d3.js and c3.js -->
	<script src="${path}/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="${path}/js/c3.min.js"></script>

<body>
	<header>
		<h1>설문조사 현황 조회</h1>
		<h2>관리자가 관리 해줘!</h2>
	</header>
	
	<input type="number" id="num">
	<button id="chk">조회</button>
	
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
	<div id="chart"></div>

	</div>
</body>
<script>

$(function(){
	$('#chk').click(function(){
		
		let param = $('#num').val();
		
		$.ajaxSetup({
			cache : false
		});
		$.ajax({
			url : "../tourChartJson?num="+param,
			success : function(jsondata){
				$('#chart').html(""); //비우기
				console.log(jsondata);
				//====================================
				var chart = c3.generate({
					bindto : '#chart',
					data : {
						json : [jsondata[1]], //1번지
						keys : {
							value : Object.keys(jsondata[1]),
						},
						type : 'donut'
					},
					donut : {
						title : jsondata[0].sub, //0번지
					},
				});
				//====================================
			},
			error : function(e) {
				console.log("error:" + e);
				$('#chart').html("데이터가 없으요~");
			}	
		});

	});
});



</script>
