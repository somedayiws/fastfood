<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.DONHANG"%>
<%@page import="java.util.ArrayList"%>

<%@include file="FILE\HEAD.jsp"%>
<script>
	$(document).ready(function() {
		var $container = $("#tbNewOrders");
		$.ajax({
			url : "CapNhatDSDonHangMoiServlet",
			type : "post",
			dateType : "text",
			success : function(result) {
				//Kết quả danh sách đơn hàng trả về trong đoạn text
				$container.html(result);
			}
		});
		var refreshId = setInterval(function() {
			$.ajax({
				url : "CapNhatDSDonHangMoiServlet",
				type : "post",
				dateType : "text",
				success : function(result) {
					//Kết quả số đơn hàng trả về trong đoạn text
					$container.html(result);
				}
			});
		}, 15000);
	});
</script>



<%@include file="FILE\header.jsp"%>
<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<div id="content">
		<div id="title">MANAGEMENT SYSTEM OH!FASTFOOD.VN</div>
		<div id="contentPage">
			<div id="ListWaitingOrder">
				<div class="titleList">
					<Strong>List of product begin transported</Strong>
				</div>
				<div class="contentList">
					<table border="1">
						<tr>
							<th>ID Order</th>
							<th>Customer name</th>
							<th>Phone number</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
						<%
							ArrayList<DONHANG> arrDonHangDangChuyen = (ArrayList<DONHANG>) request
									.getAttribute("arrDonHangDangChuyen");
							if (arrDonHangDangChuyen != null) {
								for (int i = 0; i < arrDonHangDangChuyen.size(); i++) {
						%>
						<tr class="<%=(i % 2 == 0) ? "odd" : "even"%>">
							<td><%=arrDonHangDangChuyen.get(i).getIdDonHang()%></td>
							<td><%=arrDonHangDangChuyen.get(i).getTenKhachHang()%></td>
							<td><%=arrDonHangDangChuyen.get(i).getSoDienThoai()%></td>
							<td><%=arrDonHangDangChuyen.get(i).getNgayLap()%></td>
							<td id="tdThaoTac">
								<form name="fThanhCongDonHang<%=i%>"
									action="CapNhatKetQuaDonHangServlet" method="post">
									<input type="hidden"
										value="<%=arrDonHangDangChuyen.get(i).getIdDonHang()%>"
										name="idDonHang"> <input type="hidden"
										value="Thành công" name="tinhTrang"> <a
										href="javascript:fThanhCongDonHang<%=i%>.submit()"><img
										src="images/complete.png" title="Complete"></a>
								</form>
								<form name="fHuyDonHang<%=i%>"
									action="CapNhatKetQuaDonHangServlet" method="post">
									<input type="hidden"
										value="<%=arrDonHangDangChuyen.get(i).getIdDonHang()%>"
										name="idDonHang"> <input type="hidden" value="Deny"
										name="tinhTrang"> <a
										href="javascript:fHuyDonHang<%=i%>.submit()"><img
										src="images/delete.png" title="Fail"></a>
								</form>
							</td>
						</tr>
						<%
							}
							}
						%>
					</table>
				</div>
			</div>
			<div id="ListNewOrder">
				<div class="titleList">
					<Strong>List new order</Strong>
				</div>
				<div class="contentList">
					<table border="1" id="tbNewOrders">

						<!-- 						Lấy kết quả từ ajax để tự động cập nhật -->

					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="FILE\footer.jsp"%>
