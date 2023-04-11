<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="utf-8">
<!------ Include the above in your HEAD tag
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

 ---------->
<div class="container forget-password">
	<div class="row">
		<div class="col-md-12 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="text-center">
						<img src="${path}/img/icon/icon_password.png" alt="car-key"
							border="0">
						<h2 class="text-center">Forgot Password?</h2>
						<p>You can reset your password here.</p>
						<form id="register-form" role="form" autocomplete="off"
							class="form" method="post">
							<div class="form-group">
								<div class="input-group">
									<select class="form-control" id="sel1">
										<option selected="true" disabled="disabled">Please
											Select Security Question</option>
										<option>옵젝트킹의 이름은?</option>
										<option>공주님의 이름은?</option>
										<option>지금 당신의 옆자리는 누규?</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope color-blue"></i></span> <input
										id="forgetAnswer" name="forgetAnswer" placeholder="Answer"
										class="form-control" type="text">
								</div>
							</div>
							<div class="form-group">
								<input name="btnForget"
									class="btn btn-lg btn-primary btn-block btnForget"
									value="Reset Password" type="submit">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>