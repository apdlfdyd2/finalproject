<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



	<header>
		<h1>Survey Detail Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- form start --%>
		
			<table class="table">
				<thead>
					<tr>
						<th colspan="2">SurveyDetail</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
						${vo.sub}
						<input type="hidden" name="sub" id="sub" value="${vo.sub}" readonly="readonly"> 
							<input type="hidden" name="subcode" id="num" value="${vo.num}">
							<input type="hidden" name="scid" id="scid" value="${sessionScope.sessionID}">
							<input type="hidden" name="sccode" id="sccode" value="${vo.num}">


						</td>
					</tr>

					<c:forEach var="e" items="${vo.subvey}" varStatus="i">
						<tr>
							<th>${i.index+1}번설문문항 <input type="radio" name="subtype"
								id="subtype" value="${e.subtype}" required="required">
								${e.subtype }
							</th>
							<td>${e.surveytitle}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			
				<tfoot>
					<tr>
						<th colspan="2">
						<div id="target"></div> 
							<input type="button" class="btn btn-primary"  id="surcheck" value="투표하기"/>
						<button class="btn btn-primary" onclick="location='surveyList'">list</button>
						</th>
						
						<!--  
				<th colspan="2">
				<a href="surveylist">
				<input type="button" value="list"></a></th>
			-->
					</tr>
					<tr>
						<td id="chk">check</td>
					</tr>
				</tfoot>
			</table>
		
	</div>
</article>
<script>
	$(function() {
		$('#surcheck').click(function() {

					let scid = $('#scid').val();
					let num = ${vo.num};
					let subtype = $('#subtype').val();
					let radiochk = document.getElementsByName('subtype');
					let chk = 0;
					console.log(scid)
					console.log(num)
					console.log(subtype)
					$.ajax({
						url : "../surcheck?scid="+scid+"&sccode="+num,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'이미 설문조사에 참여했습니다.');

							} else {
								for (let j = 0; j < radiochk.length; j++) {
									if (radiochk[j].checked) {
										chk++;
									}
								}
								if(scid==""){
									$('#target').css('background-color', 'red')
									.css('color', 'white').html(
											'로그인 후 설문참여가 가능합니다.');
								}								
								else if (chk > 0) {
									$('#surveyform').submit();
								} else {
									$('#target').css('background-color', 'red')
											.css('color', 'white').html(
													'설문 문항에 체크하세요.');
								}
							}
						}
					});
				});
	});
</script>