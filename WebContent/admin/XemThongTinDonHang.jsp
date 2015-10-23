<%@page import="model.bean.SANPHAM"%>
<%@page import="model.bean.CHINHANH"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.DONHANG"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Phần mở đầu gôm các file thư viện cần cho trang web --%>
<%@include file="FILE\HEAD.jsp"%>
<%-- Định nghĩa lại title, đoạn javascript dùng cho chính trang web --%>

<%-- Phần header bao gồm logo thanh top menu --%>
<%@include file="FILE\header.jsp"%>

<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<%-- Trình bày nội dung web đây --%>
	<div id="content">
		<div id="title">
			<p>Detail of order</p>
		</div>
		<div id="contentPage">
			<%
				DONHANG donhang = (DONHANG) request.getAttribute("donhang");
				ArrayList<SANPHAM> dssanpham = (ArrayList<SANPHAM>) request
						.getAttribute("list");
			%>
			<%-- Chi tiết đơn hàng --%>
			<div class="thongtindonhang">
				<table border="1">
					<tr>
						<td width="120px"><strong>Id Order</strong></td>
						<td><%=donhang.getIdDonHang()%></td>
						<td width="150px"><strong>Customer</strong></td>
						<td><%=donhang.getTenKhachHang()%></td>
					</tr>
					<tr>
						<td width="120px"><strong>Branch</strong></td>
						<td><div id="divMaChiNhanh"><%=donhang.getIdChiNhanh()%></div>
							</td>
						<td width="150px"><strong>Address</strong></td>
						<td><%=donhang.getDiaChiNhanHang()%></td>
					</tr>
					<tr>
						<td width="120px"><strong>Date</strong></td>
						<td><%=donhang.getNgayLap()%></td>
						<td width="150px"><strong>Email</strong></td>
						<td><%=donhang.getEmail()%></td>
					</tr>
					<tr>
						<td width="120px"><strong>Status</strong></td>
						<td><%=donhang.getTinhTrang().equals("Hủy")?"Denied":(donhang.getTinhTrang().equals("Thành công")?"Complete":(donhang.getTinhTrang().equals("Mới")?"New":"Delivering"))%></td>
						<td width="150px"><strong>Phone number</strong></td>
						<td><%=donhang.getSoDienThoai()%></td>
					</tr>
				</table>
				<%-- Danh sách sản phẩm đặt mua --%>
				<p>List of product</p>
				<table border="1" id="listProducts">
					<tr>
						<th width="5%">No.</th>
						<th width="10%">Id product</th>
						<th>Name product</th>
						<th>Mount</th>
						<th>Price</th>
						<th width="10%">Action</th>
					</tr>
					<%
						for (int i = 0; i < dssanpham.size(); i++) {
					%>
					<tr>
						<td><%=i + 1%></td>
						<td><%=dssanpham.get(i).getIdSanPham()%></td>
						<td><%=dssanpham.get(i).getTenSanPham()%></td>
						<td><%=dssanpham.get(i).getSoLuong() + ""%></td>
						<td><%=dssanpham.get(i).getGiaBan() + ""%></td>
						<td><a
							href="XoaChiTietDonHangServlet?idsp=<%=dssanpham.get(i).getIdSanPham()%>&iddh=<%=donhang.getIdDonHang()%>">
								Delete ... </a></td>
					</tr>
					<%
						}
					%>
				</table>
				<hr>
				<%
					if (donhang.getTinhTrang().equals("Mới")
							|| donhang.getTinhTrang().equals("Vận chuyển")) {
						if (donhang.getTinhTrang().equals("Mới")) {
				%>
				<form name="fVanChuyen" action="CapNhatKetQuaDonHangServlet"
					method="post">
					<input type="hidden" value="<%=donhang.getIdDonHang()%>"
						name="idDonHang"> <input type="hidden" value="Vận chuyển"
						name="tinhTrang"> <a href="Javascript:fVanChuyen.submit()"
						id="XacNhan">Confirm</a> 
				</form>

				<%
					} else {
				%>
				<form name="fThanhCong" action="CapNhatKetQuaDonHangServlet"
					method="post">
					<input type="hidden" value="<%=donhang.getIdDonHang()%>"
						name="idDonHang"> <input type="hidden" value="Thành công"
						name="tinhTrang"><a href="Javascript:fThanhCong.submit()"
						id="XacNhan">Confirm</a>
				</form>
				<%
					}
				%>
				<form name="fHuyDonHang" action="CapNhatKetQuaDonHangServlet"
					method="post">
					<input type="hidden" value="<%=donhang.getIdDonHang()%>"
						name="idDonHang"> <input type="hidden" value="Hủy"
						name="tinhTrang"> <a
						href="Javascript:fHuyDonHang.submit()" id="Huy">Deny Order</a>
				</form>
				<%
					}
				%>
				<p id="TongTien">
					Total: <span><%=donhang.getTongTien() + ""%> VNĐ</span>
				</p>
			</div>
		</div>
		<div class="xoa"></div>
	</div>
</div>
<%-- Kết thúc quá trình code --%>
<%@include file="FILE\footer.jsp"%>