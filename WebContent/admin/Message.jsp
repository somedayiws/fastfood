<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.DONHANG"%>
<%@page import="java.util.ArrayList"%>

<!-- Sử dụng kiểm tra dữ liệu server -->
<%
	if (request.getAttribute("message") != null) {
%>
<p id="message"><%=(String) request.getAttribute("message")%></p>
<%
	}
%>
<!-- Kết thúc sử dụng kiểm tra dữ liệu server -->

<!-- Sử dụng lấy danh sách đơn hàng mới từ server -->
<%
	ArrayList<DONHANG> arrDonHangMoi = (ArrayList<DONHANG>) request
			.getAttribute("arrDonHangMoi");
	if (arrDonHangMoi != null) {
%>
<tr>
	<th>ID Order</th>
	<th>Customer name</th>
	<th>Phone number</th>
	<th>Date</th>
	<th>Action</th>
</tr>
<%
	for (int i = 0; i < arrDonHangMoi.size(); i++) {
%>
<tr class="<%=(i % 2 == 0) ? "odd" : "even"%>">
	<td><%=arrDonHangMoi.get(i).getIdDonHang()%></td>
	<td><%=arrDonHangMoi.get(i).getTenKhachHang()%></td>
	<td><%=arrDonHangMoi.get(i).getSoDienThoai()%></td>
	<td><%=arrDonHangMoi.get(i).getNgayLap()%></td>
	<td><a
		href="XemThongTinDonHang?id=<%=arrDonHangMoi.get(i).getIdDonHang()%>" id="buttonOk">Detail</a></td>
</tr>
<%
	}
	}
%>
<!-- Kết thúc sử dụng lấy danh sách đơn hàng mới từ server -->
