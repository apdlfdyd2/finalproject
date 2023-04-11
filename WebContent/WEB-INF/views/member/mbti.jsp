<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>

</head>
<body>
<h3>MBTI 테스트</h3>
<!--
<div>
<tbody>
<c:forEach begin="0" end="3" step="1" var="e">
<tr>
<td><img src="${path}/img/mbti/mbti${e}.PNG" height="300" width="200"></td>
<td></td>
</tr>
</c:forEach>
</tbody>

</div>-->

<div style="margin: 0 auto;"><img id="imgtarget" src="${path}/img/mbtitest/mbti0.PNG" height="300" width="200"></div>
설명
<div id="text">E : 친구만날 때 충전 , I : 집에있을 때 충전</div>
<hr>
<div id="target2">버튼을 눌러주세요!</div>
<div style="width: 200px; border: 1px dotted; height: 50px;" id="target" ></div>
<input id="btn1" type="button" value="E" onclick="btn1()">
<input id="btn2" type="button" value="I" onclick="btn2()">
<input type="button" value="결과" onclick="btn3()">
<button id="upmbti">결과저장</button>

<input type="hidden" id="mid" value="${sessionScope.sessionID}">
<input type="hidden" id="mmbti" value="null">
<a href="javascript:history.back()">Back</a>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
let type1=["E","E","E","N","N","N","F","F","F","J","J","J"];
let type2=["I","I","I","S","S","S","T","T","T","P","P","P"];
let a=0;
let k=0;
let i=0;
let e=0;
let n=0;
let f=0;
let j=0;
let s=0;
let t=0;
let p=0;
let result ="";
let totalresult="";
let text=["E : 집에있을 때 나가고싶다 , I : 집에 있을 때 편안",
	"E : 출근길 동료 반갑게 아는척한다, I : 출근길 동료 모른척한다","N : 미래를 상상한다 , S : 현재가 중요함",
	"N : 만약에라는 상상을 많이함, S : 굳이 그런상상을 ? 어케암?","N : 이런저런 고민을 많이함, S : 고민은 최대 한줄",
			"F : 쉽게 상처받음, T:덤덤 어쩌라고","F : 말에 다른 뜻이 있는지 과대해석, T:말 그대로 받아드림",
			"F : 수식어가 중요, T : 결론이 중요","J : 빼곡한 계획, P : 자유로운 영혼",
			"J : 배터리는 항상 가득, P : 자유로운 영혼","J : 맛집도 사전에 찾아봄, P : 자유로운 영혼"];
let targetDiv = document.getElementById("target");

function btn1() {
	if(k>11){
		$('#target2').text("설문조사를 완료했습니다 결과보기를 눌러주세요!");
	}
	else{
		if(type1[k]=="E"){
			e++;
		};
		if(type1[k]=="N"){
			n++;
		};
		if(type1[k]=="F"){
			f++;
		};
		if(type1[k]=="J"){
			j++;
		};
		console.log(type1[k]);
		$('#target2').text(type1[k]+"선택하셨습니다.")
		$('#text').text(text[k]);
		k++;
		$('#btn1').attr("value",type1[k]);
		$('#btn2').attr("value",type2[k]);
		document.getElementById("imgtarget").src="${path}/img/mbtitest/mbti"+k+".PNG";
	}
	
}
function btn2() {
	if(k>11){
		$('#target2').text("설문조사를 완료했습니다 결과보기를 눌러주세요!");
	}
	else{
		if(type2[k]=="I"){
			i++;
		};
		if(type2[k]=="S"){
			s++;
		};
		if(type2[k]=="T"){
			t++;
		};
		if(type2[k]=="P"){
			p++;
		};
		console.log(type2[k]);
		console.log(type2[k]);
		$('#target2').text(type2[k]+"선택하셨습니다.")
		$('#text').text(text[k]);
		k++;
		$('#btn1').attr("value",type1[k]);
		$('#btn2').attr("value",type2[k]);
		document.getElementById("imgtarget").src="${path}/img/mbtitest/mbti"+k+".PNG";
	}
	
	
}
function btn3() {
	
	if(e>=2){
		result+="E";
	}else{
		result+="I";
	}
	if(n>=2){
		result+="N";
	}else{
		result+="S";
	}
	if(f>=2){
		result+="F";
	}else{
		result+="T";
	}
	if(j>=2){
		result+="J";
	}else{
		result+="P";
	}
	console.log("e : "+e);
	console.log("n : "+n);
	console.log("f : "+f);
	console.log("j : "+j);
	console.log("i : "+i);
	console.log("s : "+s);
	console.log("t : "+t);
	console.log("p : "+p);
	
	if(a==0){
		targetDiv.innerHTML="당신의 MBTI는 "+result+"입니다";
		$('#mmbti').attr("mmbti",result);
		console.log(k)
		totalresult=result;
		a++;
	}
	
	//targetDiv.innerHTML="당신의 MBTI는 "+result+"입니다";
	//$('#mmbti').attr("mmbti",result);
}
$(function() {
	$('#upmbti').click(
			
			function() {
				let mid = document.getElementById('mid').value
				let mbtitype = totalresult;
				console.log(mid)
				console.log(mbtitype)
				//?mid="+mid+"&mbtitype="+mbtitype
				$.ajax({
					url : "../upmbti?mid="+mid+"&mbtitype="+mbtitype,
					/*method:"POST",
					dataType:"text",
					data:{
						mid:mid,
						mbtitype:mbtitype
					},*/
					success : function(data) {
						console.log("성공한건가..");
						
					}
				});
				
			});
});

</script>
</html>