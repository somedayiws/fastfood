<%@page import="model.bean.DONHANG"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>

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
			<p>List of order</p>
		</div>
		<div id="contentPage">
			<form action="DonHang" method="post">
				<table border="1" class="bang">
					<tr>
						<th width="100px">Search :</th>
						<td colspan="8"><input type="text" name="txttimkiem"
							placeholder="Input search value..." style="width: 91%">
							<input type="submit" value="Filter" style="width: 50px"></td>
					</tr>
					<tr>
						<td colspan="9"><br></td>
					</tr>
					<tr>
						<th width="100px">ID order</th>
						<th>Customer Name</th>
						<th>Address</th>
						<th>Phone number</th>
						<th>Email</th>
						<th>Total</th>
						<th>Status</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
					<%
						ArrayList<DONHANG> list = (ArrayList<DONHANG>) request
								.getAttribute("list");
						int i = 0;
						while (i < list.size()) {
					%>
					<tr class="<%=(i % 2 == 0) ? "odd" : "even"%>">
						<td width="100px"><%=list.get(i).getIdDonHang()%></td>
						<td><%=list.get(i).getTenKhachHang()%></td>
						<td><%=list.get(i).getDiaChiNhanHang()%></td>
						<td><%=list.get(i).getSoDienThoai()%></td>
						<td><%=list.get(i).getEmail()%></td>
						<td><%=list.get(i).getTongTien() + " đ"%></td>
						<td><%=list.get(i).getTinhTrang().equals("Hủy")?"Denied":(list.get(i).getTinhTrang().equals("Thành công")?"Complete":(list.get(i).getTinhTrang().equals("Mới")?"New":"Delivering"))%></td>
						<td>
							<%
								SimpleDateFormat timeFormat = new SimpleDateFormat(
											"dd/MM/yyyy hh:mm:ss");
									String NgayThamGia = timeFormat.format(list.get(i).getNgayLap()
											.getTime());
							%> <%=NgayThamGia%></td>
						<td><a
							href="XemThongTinDonHang?id=<%=list.get(i).getIdDonHang()%>"
							class="xem">Detail</a> - <a
							href="XoaDonHangServlet?id=<%=list.get(i).getIdDonHang()%>"
							class="xoa">Delete</a></td>
					</tr>
					<%
						i++;
						}
					%>
				</table>
			</form>
			<div id="Navigation" align="center">
				<%=request.getAttribute("pageNav")%>
			</div>
		</div>
	</div>
</div>
<%-- Kết thúc quá trình code --%>
<%@include file="FILE\footer.jsp"%>
