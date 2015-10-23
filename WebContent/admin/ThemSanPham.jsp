<%@page import="model.bean.DANHMUC"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Phần mở đầu gôm các file thư viện cần cho trang web --%>
<%@include file="FILE\HEAD.jsp"%>
<%-- Định nghĩa lại title, đoạn javascript dùng cho chính trang web --%>
<script src="../js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#fThemSanPham")
								.validate(
										{
											rules : {
												tensanpham : {
													required : true
												},
												mota : {
													required : true
												},
												giaban : {
													required : true,
													digits : true
												},
												hinhanh : {
													required : true,
													accept:".jpg|.png|.jpge"
												},
											},
											messages : {
												tensanpham : {
													required : "<br>Invalid name of product!",
												},
												mota : {
													required : "<br>Invalid description!",
												},
												giaban : {
													required : "<br>Invalid price",
													digits : "<br>Wrong format price",	
												},
												hinhanh : {
													required : "<br>Invalid picture description!",
													accept:"<br>Wrong format picture!"
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



<%-- Phần header bao gồm logo thanh top menu --%>
<%@include file="FILE\header.jsp"%>


<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<%-- Trình bày nội dung web đây --%>
	<div id="content">
		<div id="title">
			<p>Add new product</p>
		</div>
		<div id="contentPage">
			<!-- 			<form action="ThemSanPhamServlet" method="post"> -->
			<form id="fThemSanPham" action="ThemSanPhamServlet" enctype="multipart/form-data"
				method="POST">
				<table class="bang" cellpadding="10px">
					<tr>
						<td style="width: 125px; text-align: left;">ID Category(*) :</td>
						<td><select name="iddanhmuc" style="width: 17%;">
								<%
									ArrayList<DANHMUC> danhmuc = (ArrayList<DANHMUC>) request
											.getAttribute("danhmuc");
									int i = 0;
									while (danhmuc != null && i < danhmuc.size()) {
								%>
								<option value="<%=danhmuc.get(i).getIdDanhMuc()%>">
									<%=danhmuc.get(i).getDanhMuc()%>
								</option>
								<%
									i++;
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Product Name(*) :
						</th>
						<td><input type="text" name="tensanpham"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Description(*) :</td>
						<td><input type="text" name="mota"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Price(*) :</td>
						<td><input type="text" name="giaban"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Picture Description :</td>
						<td><input type="file" name="hinhanh"></td>
					</tr>
					<tr>
						<th colspan="2" align="right"><input type="submit"
							value="Add"> <input type="reset" value="Reset"></th>
					</tr>
				</table>
			</form>
		</div>
		<div class="xoa"></div>
	</div>
</div>
<%-- Kết thúc quá trình code --%>
<%@include file="FILE\footer.jsp"%>
