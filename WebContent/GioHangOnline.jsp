<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.SANPHAM"%>
<%@page import="java.util.ArrayList"%>
<%-- Xử lý việc thêm một hàng mới vào giỏ --%>
<script type="text/javascript">
	$(document).ready(function() {
		$('.tangItem').click(function() {
			LoadPage1(this.id.slice(1), 1);
		});

		$('.giamItem').click(function() {
			LoadPage1(this.id.slice(1), -1);
		});

		$('.xoaItem').click(function() {
			LoadPage2(this.id.slice(1));
		});

		function LoadPage1(ma, bien) {
			$('.giohang').load('GioHangOnlineServlet', {
				id : ma,
				soluong : bien
			});
		}
		function LoadPage2(ma) {
			$('.giohang').load('XoaItemGioHangOnlineServlet', {
				id : ma
			});
		}
		function thongbao() {
			alert("Load thành công.");
		}
	});
</script>
<form name="fDatHang" action="ThanhToanOnlineServlet" method="post">
	<div class="hangdat">
		<%
			ArrayList<SANPHAM> Giohang = (ArrayList<SANPHAM>) request
					.getSession().getAttribute("Giohang");
			int i11 = 0;
			int tien1 = 0;
			while (Giohang != null && i11 < Giohang.size()) {
				tien1 += Giohang.get(i11).getGiaBan()
						* Giohang.get(i11).getSoLuong();
		%>
		<div class="itemhang">
			<a id="x<%=Giohang.get(i11).getIdSanPham()%>" class="xoaItem"
				type="button">x</a>
			<p id="tenSanPham"><%=Giohang.get(i11).getTenSanPham()%></p>
			<a id="g<%=Giohang.get(i11).getIdSanPham()%>" class="giamItem"
				type="button">-</a>
			<p id="soLuong"><%=Giohang.get(i11).getSoLuong()%></p>
			<a id="t<%=Giohang.get(i11).getIdSanPham()%>" class="tangItem">+</a>
			<p id="giaBan"><%=Giohang.get(i11).getGiaBan()%>
				VNĐ
			</p>

		</div>
		<%
			i11++;
			}
		%>

	</div>
	<p id="tongTien">
		Total  <span><%=tien1%> VNĐ</span>
	</p>
<!-- 	<div id="thanhtoan"> -->
		<a id="thanhtoan" href="javascript:fDatHang.submit()">Checkout</a>
<!-- 	</div> -->
</form>