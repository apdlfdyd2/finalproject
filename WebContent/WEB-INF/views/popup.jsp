<%@page import="kr.co.kosmo.mvc.vo.LocalVO"%>
<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta charset="EUC-KR">
<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 120;
	font-style: normal;
}

body {
	font-family: 'Pretendard-Regular';
}

#calendar {
	width: 850px;
}

.memo-fluid {
	margin-top: 20px;
	margin-bottom: 20px;
}

.column {
	border: 1px solid #cecece;
	padding-top: 10px;
	padding-bottom: 10px;
}

.memo-fluid .card {
	margin-left: auto;
	margin-right: auto;
}

.card-placeholder {
	border: 1px dotted rgb(255, 0, 0);
	margin: 0 10px 10px 0;
	height: 20px;
	margin-left: auto;
	margin-right: auto;
	background-color: rgb(231, 136, 107);
}

.card:not (.no-move ) .card-header {
	cursor: pointer;
}

.card-text {
	min-height: 120px;
	width: auto;
	height: auto;
}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fabric.js/5.3.1/fabric.min.js" integrity="sha512-CeIsOAsgJnmevfCi2C7Zsyy6bQKi43utIjdA87Q0ZY84oDqnI0uwfM9+bKiIkI75lUeI00WG/+uJzOmuHlesMA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fabric.js/5.3.1/fabric.js" integrity="sha512-hOJ0mwaJavqi11j0XoBN1PtOJ3ykPdP6lp9n29WVVVVZxgx9LO7kMwyyhaznGJ+kbZrDN1jFZMt2G9bxkOHWFQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>




<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container mt-3" align="center">
	<%-- memo --%>
	<div id="popup">
		<div class="memo-fluid" style="display: none;">
			<!-- 세로 리스트 박스 -->
			<div class="col-3 column">
				<div class="card text-white" style="background-color: rgb(253, 196, 130);">
					<div class="card-header">
						내 일상 메모
						<div>
							<label onclick="saveMemo()">[저장]</label> <label onclick="loadMemo()">[불러오기]</label> <label class="deleteBox" onclick="clearMemo()">[삭제]</label>

						</div>
					</div>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<textarea id="memo" class="card-text"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<button id="createBtn" class="btn btn-info">Memo Here!</button>
	<%-- memo --%>
</div>

<br>


<script>

//메모장js
		$("#createBtn").click(function() {
			$(".memo-fluid").toggle();
		});
		
/*
		  $(function() {
			    $( ".memo-fluid" ).draggable({
			    	  containment: "parent"
			    });
			  } );
			  */


const memo = document.getElementById("memo");

function saveMemo() {
localStorage.setItem("memo", memo.value);
}

function loadMemo() {
memo.value = localStorage.getItem("memo");
}

function clearMemo() {
memo.value = "";
localStorage.removeItem("memo");
}

//==============








</script>
