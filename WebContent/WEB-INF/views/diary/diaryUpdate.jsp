<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 500;
	font-style: normal;
}

@font-face {
	font-family: 'TTTtangsbudaejjigaeB';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2212@1.0/TTTtangsbudaejjigaeB.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}

body {
	font-family: 'Pretendard-Regular';
}

.container {
	width: 750px;
	padding: 30px 35px 35px;
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

.container.disable .editor-panel, .container.disable .btnspace .reset-filter,
	.container.disable .btnspace .save-img {
	opacity: 0.5;
	pointer-events: none;
}

.container h2 {
	font-family: 'TTTtangsbudaejjigaeB';
	margin-top: -10px;
	font-size: 22px;
	font-weight: bold;
	color: #3c3c3c;
}

.container .wrapper {
	display: flex;
	margin: 20px auto;
	min-height: 335px;
}

.wrapper {
	justify-content: center;
	width: 500px;
}

input[type=text] {
	width: 100%;
	padding: 5px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: none;
	border-bottom: 2px solid gray;
}

input[type=text]:focus {
	width: 100%;
	padding: 12px 20px 10px;
	margin: 8px 0;
	outline: none;
	box-sizing: border-box;
	border: none;
	border-bottom: 2px solid #2EE59D;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
	box-sizing: border-box;
}

textarea {
	width: 100%;
	height: 6.25em;
	border: none;
	border-bottom: 2px solid gray;
}

textarea:focus {
	width: 100%;
	height: 6.25em;
	outline: none;
	border: none;
	border-bottom: 2px solid #2EE59D;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.options, .btnspace {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

button {
	margin-right: 10px;
}

.button_submit {
	width: 140px;
	height: 45px;
	font-family: 'Roboto', sans-serif;
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 2.5px;
	font-weight: 500;
	color: #000;
	background-color: #fff;
	border: none;
	border-radius: 45px;
	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease 0s;
	cursor: pointer;
	outline: none;
	margin-top: 15px;
}

.button_submit:hover {
	background-color: #2EE59D;
	box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
	color: #fff;
	transform: translateY(-7px);
}

#imgx {
	width: 390px;
	height: 270px;
	border-radius: 25px;
	margin-top: 10px ;
	margin-bottom: 15px;
	box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
}

#imgfilter {
	width: 380px;
	height: 50px;
	border-radius: 15px;
	opacity: 0.9;
	color: #fff;
	font-weight: bold;
	transform: translateY(-7px);
	text-align: center;
	line-height: 3;
	margin-top: 20px;
	border: 1px solid #2EE59D;
	background-color: #2EE59D;
	box-shadow: 0px 5px 5px rgba(46, 229, 157, 0.4);
}


</style>



<div class="container disable">
	<h2>다이어리 수정</h2>
	<div class="wrapper">
		<form method="post" action="updateDiary" enctype="multipart/form-data" id="diaryUpdate">
		<input type="hidden" name="dno" value="${vo.dno }">
		<input type="hidden" name="dwriter" value="${vo.dwriter }">
			<label for="dtitle">제목</label> 
			<input type="text" id="dtitle" name="dtitle" required="required" value="${vo.dtitle}">

			<%--------------- 이미지 시작 ---------------%>
			<label for="mfile">이미지</label> 
			<div class="options">
				<input class="btn btn-light" type="file" id="mfile" name="mfile">


				<div id="imgfilter">
					<a href="../diary/photo"> 나만의 여행 사진 필터 적용하기 </a>
				</div>
				<img id="imgx" src="${ctrpath}/resources/imgfile/${vo.dimg}">

				
			</div>
			<%--------------- 이미지 끝! ---------------%>

			<div>
				<label for="dcontent">내용</label>
				<textarea name="dcontent" id="dcontent" required="required">${vo.dcontent }</textarea>

				<label for="dtag">해시태그</label> <input type="text" id="dtag" name="dtag" required="required" value="${vo.dtag }">
			</div>

			<div class="btnspace">
				<%-- https://devdevout.com/css/css-round-buttons --%>
				<button type="submit" class="button_submit">Submit</button>
			</div>
		</form>

	</div>

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

	$(function() {
		$('#mfile').change(function() {
			if ($(this).val().length != 0) {
				//함수 호출
				readURL(this);
			} else {
				console.log("이미지 없습니다.");
			}
		});
	});
</script>