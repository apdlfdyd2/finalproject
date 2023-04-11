<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- 2023. 1. 20. / Kosmo --%>
<!-- file-name -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ex1_checkbox.jsp</title>
<style type="text/css">
.night {
	background-color: black;
	color: white;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<div data-role="page">

	<div data-role="header">
		<h1>Admin page</h1>
		<a href="" class="ui-btn ui-btn-inline">Home</a>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<p>UploadDemo mobile page list</p>
		<div data-role="collapsible" data-mini="true">
			<h3>List</h3>
			<ul data-role="listview">
				<li><a href="list/member">Member list</a></li>
				<li><a href="list/host">Host list</a></li>
				<li><a href="customernotice/listNo">Notice list</a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li><a href=""></a></li>
			</ul>
		</div>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Footer content</h4>
	</div><!-- /footer -->

</div>
</body>
</html>