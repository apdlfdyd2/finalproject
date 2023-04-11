<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />

<%--2023. 1. 12./Kosmo --%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>°øÁÖ´Ô ³î·¯°¡ÀÚ!(¼¼¹Ì)</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="${path}/img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/css/owl.carousel.min.css">
<link rel="stylesheet" href="${path}/css/magnific-popup.css">
<link rel="stylesheet" href="${path}/css/font-awesome.min.css">
<link rel="stylesheet" href="${path}/css/themify-icons.css">
<link rel="stylesheet" href="${path}/css/nice-select.css">
<link rel="stylesheet" href="${path}/css/flaticon.css">
<link rel="stylesheet" href="${path}/css/gijgo.css">
<link rel="stylesheet" href="${path}/css/animate.css">
<link rel="stylesheet" href="${path}/css/slick.css">
<link rel="stylesheet" href="${path}/css/slicknav.css">
<link rel="stylesheet" href="${path}/css/side_menu.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/041939f55f.css">

<link rel="stylesheet" href="${path}/css/style.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<!-- <link rel="stylesheet" href="css/responsive.css"> -->


</head>

<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header-start -->
	<tiles:insertAttribute name="header" />
	<!-- header-end -->
	<tiles:insertAttribute name="sidebar" />

	<!-- ==========Body Start========== -->

	<!-- body-start -->
	<tiles:insertAttribute name="body" />
	<!-- body-end -->


	<!-- ==========Body End========== -->

	<!-- footer stargt -->
	<tiles:insertAttribute name="footer" />
	<!-- footer end -->

	<!-- searchbar : Modal -->
	<tiles:insertAttribute name="searchbar" />
	<!-- searchbar : Modal -->

	<!-- link that opens popup -->
	<!--     
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>

    <script src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> </script> -->
	<!-- JS here -->
	<script src="${path}/js/vendor/modernizr-3.5.0.min.js"></script>
	<!--<script src="${path}/js/vendor/jquery-1.12.4.min.js"></script>-->
	<script src="${path}/js/popper.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/owl.carousel.min.js"></script>
	<script src="${path}/js/isotope.pkgd.min.js"></script>
	<script src="${path}/js/ajax-form.js"></script>
	<script src="${path}/js/waypoints.min.js"></script>
	<script src="${path}/js/jquery.counterup.min.js"></script>
	<script src="${path}/js/imagesloaded.pkgd.min.js"></script>
	<script src="${path}/js/scrollIt.js"></script>
	<script src="${path}/js/jquery.scrollUp.min.js"></script>
	<script src="${path}/js/wow.min.js"></script>
	<script src="${path}/js/nice-select.min.js"></script>
	<script src="${path}/js/jquery.slicknav.min.js"></script>
	<script src="${path}/js/jquery.magnific-popup.min.js"></script>
	<script src="${path}/js/plugins.js"></script>
	<script src="${path}/js/gijgo.min.js"></script>
	<script src="${path}/js/slick.min.js"></script>
	<script src="https://kit.fontawesome.com/041939f55f.js" crossorigin="anonymous"></script>


	<!--contact js-->
	<script src="${path}/js/contact.js"></script>
	<script src="${path}/js/jquery.ajaxchimp.min.js"></script>
	<script src="${path}/js/jquery.form.js"></script>
	<script src="${path}/js/jquery.validate.min.js"></script>
	<script src="${path}/js/mail-script.js"></script>

	<script src="${path}/js/main.js"></script>
	<script>
		$('#datepicker').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}
		});
	</script>
</body>

</html>