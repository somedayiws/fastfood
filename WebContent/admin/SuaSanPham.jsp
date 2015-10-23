<%@page import="model.bean.DANHMUC"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.SANPHAM"%>
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
						$("#fSuaSanPham")
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
													digits : "<br>Wrong format of price",	
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
			<p>Edit information of product</p>
		</div>
		<div id="contentPage">
			<form id="fSuaSanPham" action="SuaSanPhamServlet" method="post">
				<%
					SANPHAM spx = (SANPHAM) request.getAttribute("spx");
				%>
				<br> <label></label> <br>
				<table class="bang" cellpadding="10px">
					<tr>
						<td style="width: 125px; text-align: left;">ID Product(*) :
						</td>
						<td><input type="text" name="id" readonly="readonly"
							value="<%=spx.getIdSanPham()%>"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">ID Category(*) :
						</td>
						<td><select name="iddanhmuc" style="width: 17%;">
								<%
									ArrayList<DANHMUC> danhmuc = (ArrayList<DANHMUC>) request
											.getAttribute("danhmuc");
									int i = 0;
									while (danhmuc != null && i < danhmuc.size()) {
								%>
								<option value="<%=danhmuc.get(i).getIdDanhMuc()%>"
									<%if (spx.getDanhMuc().getIdDanhMuc()
						.equals(danhmuc.get(i).getIdDanhMuc())) {%>
									selected="selected" <%}%>>
									<%=danhmuc.get(i).getDanhMuc()%>
								</option>
								<%
									i++;
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Product Name(*) :</td>
						<td><input type="text" name="tensanpham"
							value="<%=spx.getTenSanPham()%>"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Description(*) :</td>
						<td><input type="text" name="mota" value="<%=spx.getMoTa()%>"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Price(*) :</td>
						<td><input type="text" name="giaban"
							value="<%=spx.getGiaBan()%>"></td>
					</tr>
					<tr>
						<td style="width: 125px; text-align: left;">Picture :</td>
						<td><input type="file" name="hinhanh"
							value="<%=spx.getHinhAnh()%>"></td>
					</tr>
					<tr>
						<th colspan="2" align="right"><input type="submit"
							value="Done"> <input type="reset" value="Reset">
						</th>
					</tr>
				</table>
			</form>
		</div>
		<div class="xoa"></div>
	</div>
</div>

<%-- Kết thúc quá trình code --%>
<%@include file="FILE\footer.jsp"%>