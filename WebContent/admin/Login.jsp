<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.bean.QUANTRI"%>
	
<%@include file="FILE\HEAD.jsp"%>
<script src="../js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//Check validate username
						$.validator.addMethod("username", function(value,
								element, regexpr) {
							return regexpr.test(value);
						}, "Tên đăng nhập không đúng định dạng");
						
						$("#fLoginAdmin")
								.validate(
										{
											rules : {
												tenTaiKhoan : {
													required : true,
													username : /^(?=[_a-zA-Z]+)[a-zA-Z0-9_]{8,25}$/
												},
												matKhau : {
													required : true,
													minlength: 8,
													maxlength:25
												}
											},
											messages : {
												tenTaiKhoan : {
													required : "<br>Invalid username",
													username : "<br>Invalid username<br>"
												},
												matKhau : {
													required : "<br>Invalid password!",
													minlength: "<br>Password have more than 8 character and small than 25 character",
													maxlength: "<br>Password have more than 8 character and small than 25 character",
												},
											},
											submitHandler : function(form) {
															form.submit();
											}
										});
					});
</script>
<style type="text/css">
label.error {
	color: #FF0000;
}

input.error {
	border: 2px solid #FF0000;
	color: #0000FF;
	border-style: ridge;
}
</style>

<div id="primary">
	<form id="fLoginAdmin" action=XuLyDangNhapAdmin method="post">
		<div id="frame">
			<div id="titleLogin">Login</div>
			<div id="tbLogin">
				<span><% QUANTRI quanTri = (QUANTRI)session.getAttribute("quanTri");
							if(quanTri !=null) {
								%>
								* You have not enough permission<br>
								* Login with root account!
								<%} %>
							</span>
				<table>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="tenTaiKhoan" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="matKhau" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>
