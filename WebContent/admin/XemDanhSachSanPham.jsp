<%@page import="model.bean.SANPHAM"%>
<%@page import="java.util.ArrayList"%>
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
			<p>List of product</p>
		</div>
		<div id="contentPage">
			<form action="SanPham" method="post">
				<table border="1" class="bang">
					<tr>
						<th width="100px">Search :</th>
						<td colspan="6"><input type="text" name="txttimkiem"
							placeholder="Input search value..." style="width: 91%">
							<input type="submit" value="Filter" style="width: 50px"></td>
					</tr>
					<tr>
						<td colspan="6"><br></td>
					</tr>
					<tr>
						<th width="100px">Id product</th>
						<th>Category</th>
						<th>Name product</th>
						<th>Description</th>
						<th>Price</th>
						<th><a href="ThemSanPhamServlet"> Add new </a></th>
					</tr>
					<%
						ArrayList<SANPHAM> list = (ArrayList<SANPHAM>) request
								.getAttribute("list");
						int i = 0;
						while (i < list.size()) {
					%>
					<tr class="<%=(i % 2 == 0) ? "odd" : "even"%>">
						<td width="100px"><%=list.get(i).getIdSanPham()%></td>
						<td><%=(list.get(i).getDanhMuc()).getDanhMuc()%></td>
						<td><%=list.get(i).getTenSanPham()%></td>
						<td><%=list.get(i).getMoTa()%></td>
						<td><%=list.get(i).getGiaBan()%></td>
						<td><a
							href="SuaSanPhamServlet?id=<%=list.get(i).getIdSanPham()%>">
								Edit </a> - <a
							href="XoaSanPhamServlet?id=<%=list.get(i).getIdSanPham()%>">
								Delete </a>
						</th>
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
