<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.SANPHAM"%>
<%@page import="java.util.ArrayList"%>

<%@include file="FILE\HEAD.jsp"%>
<%@include file="ScriptAnimation.jsp"%>
<%-- Xử lý việc thêm một hàng mới vào giỏ --%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('.tangItem').click(
						function() {
							window.location = "CapNhatGioHangServlet?id="
									+ this.id.slice(1) + "&soluong=1";
						});

				$('.giamItem').click(
						function() {
							window.location = "CapNhatGioHangServlet?id="
									+ this.id.slice(1) + "&soluong=-1";
						});

				$('.xoaItem').click(
						function() {
							window.location = "XoaGioHangServlet?id="
									+ this.id.slice(1);
						});

				$('#xoagiohang').click(function() {
					window.location = "XoaGioHangServlet";
				});

			});
</script>


<%@include file="FILE\header.jsp"%>
<div id="primary">
		<%@include file="FILE\sidebarLienHe.jsp"%>
	<div id="content">
		<div id="title">MY CART</div>
		<div id="contentPage">
			<form name="fDatHang" action="DatHangOnlineServlet" method="post">
				<div class="khung3">
					<table class="bang" border="1">
						<tr>
							<th>No</th>
							<th>Product</th>
							<th>Mount</th>
							<th>Price</th>
							<th>Total</th>
							<th>Delete</th>
						</tr>
						<%
							ArrayList<SANPHAM> list = (ArrayList<SANPHAM>) request.getSession()
									.getAttribute("Giohang");
							int i = 0;
							int tien1 = 0;
							while (list != null && i < list.size()) {
								tien1 += list.get(i).getGiaBan() * list.get(i).getSoLuong();
						%>
						<tr class="<%=(i % 2 == 0) ? "odd" : "even"%>">
							<td><%=(i + 1)%></td>
							<td><%=list.get(i).getTenSanPham()%></td>
							<td width="80px"><a id="g<%=list.get(i).getIdSanPham()%>"
								class="giamItem" type="button">-</a> <span
								style="float: left; margin: 0px 5px;"><%=list.get(i).getSoLuong()%></span>
								<a id="t<%=list.get(i).getIdSanPham()%>" class="tangItem"
								type="button">+</a></td>
							<td align="center"><%=list.get(i).getGiaBan()%></td>
							<td align="center"><%=list.get(i).getGiaBan() * list.get(i).getSoLuong()%></td>
							<td width="40px"><a id="x<%=list.get(i).getIdSanPham()%>"
								class="xoaItem">X</a></td>
						</tr>
						<%
							i++;
							}
						%>
						<tr>
							<th><br></th>
							<th><br></th>
							<th><br></th>
							<th>Total</th>
							<th><%=tien1%></th>
							<th><br></th>
						</tr>
					</table>
					<div id="btnThaoTac">
						<a id="datHang" href="javascript:fDatHang.submit()">Checkout</a>
						<a id="xoagiohang">Clear cart</a>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>

<%@include file="FILE\footer.jsp"%>
