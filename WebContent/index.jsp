<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Tour</title>
</head>
<body>

<h1><a href="${pageContext.request.contextPath}/main">tour 페이지로</a></h1>

<script>
	function check() {
		//location="redirect:/main";
		location="${pageContext.request.contextPath}/main";
	}
	
	check();

</script>

</body>
</html>