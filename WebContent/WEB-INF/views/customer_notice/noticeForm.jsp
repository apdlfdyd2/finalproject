<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<header>
		<h1>공지</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- boardForm 들어 갈 자리. --%>
		<form action="addinsert" method="post">
			<%-- 사용자의 아이피를 받아와서 보이지 않는 속성으로 reip 란 파라미터로 지정한다. --%>
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="title">제목</label>
				<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
				<!-- required 속성을 설정하면 필수입력 사항이된다. -->
				<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
				<input type="text" class="form-control" id="subject"
					placeholder="제목 입력(4-100)" name="nsub" maxlength="100"
					required="required" pattern=".{4,100}">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
				<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
				<textarea class="form-control" rows="5" id="ncontent"
					name="ncontent" placeholder="내용 작성"></textarea>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> <input type="text"
					class="form-control" id="nwriter" placeholder="작성자(2자-10자)"
					name="nwriter">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">등록</button>
			</div>
		</form>

	</div>

</article>