<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.SANPHAM"%>
<%@page import="java.util.ArrayList"%>

<%@include file="FILE\HEAD.jsp"%>
<%@include file="ScriptAnimation.jsp"%>
<%-- Xử lý việc thêm một hàng mới vào giỏ --%>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ghang').click(function() {
			LoadPage1(this.id.slice(1), 1);
		});

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
			alert("Load success");
		}
	});
</script>


<%@include file="FILE\header.jsp"%>
<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<div id="content">
		<div id="title"><%=request.getAttribute("tenDanhMuc").equals("")?"LIST FAST FOODS":request.getAttribute("tenDanhMuc") %></div>
		<div id="contentPage">
			<div class="khung3">
				<div class="listsanpham">
					<%
						ArrayList<SANPHAM> list = (ArrayList<SANPHAM>) request
								.getAttribute("list");
						int i = 0;
						while (list != null && i < list.size()) {
					%>
					<div class="sanpham">
						<a
							href="XemThongTinSanPhamServlet?id=<%=list.get(i).getIdSanPham()%>">
							<img alt="" src="images/products/<%=list.get(i).getHinhAnh()%>">
						</a> <br> <a id="tenSanPham"
							href="XemThongTinSanPhamServlet?id=<%=list.get(i).getIdSanPham()%>">
							<%=list.get(i).getTenSanPham()%>
						</a> <br>
						<p>
							Price : <span><%=list.get(i).getGiaBan()%> </span> đ
						</p>
						<a id="muaNgay"
							href="ThanhToanOnlineServlet?id=<%=list.get(i).getIdSanPham()%>">
							CHECKOUT </a> <a id="a<%=list.get(i).getIdSanPham()%>" class="ghang"><img
							src="images/add-to-cart.png" align="bottom"></a>
					</div>
					<%
						i++;
						}
					%>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="FILE\footer.jsp"%>
