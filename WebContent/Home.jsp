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
			alert("Load thành công.");
		}
	});
</script>

<script type="text/javascript" src="js/jquery.als-1.7.min.js"></script>
<link rel="stylesheet" href="css/slider.css" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#demo1").als({
			visible_items : 5,
			scrolling_items : 1,
			orientation : "horizontal",
			circular : "yes",
			autoscroll : "yes",
			interval : 4000,
			speed : 400,
			easing : "linear",
			direction : "left",
			start_from : 0
		});
	});
</script>


<%@include file="FILE\header.jsp"%>
<div id="slideShow">
	<div class="neoslideshow">
		<img src="images/promotion/app-3vn.jpg"> <img
			src="images/promotion/Rice1.jpg"> <img
			src="images/promotion/app.jpg"> <img
			src="images/promotion/SaladSoup3.jpg"> <img
			src="images/promotion/Drink-1.jpg"> <img
			src="images/promotion/pizza39k.jpg"> <img
			src="images/promotion/Drink-2.jpg"> <img
			src="images/promotion/SaladSoup2.jpg"> <img
			src="images/promotion/pizza99k.jpg"> <img
			src="images/promotion/Rice.jpg"> <img
			src="images/promotion/Drink-4.jpg">
	</div>
</div>
<div id="slideProducts">
	<div id="title">FOR TODAY ?</div>
	<div class="als-container" id="demo1">
		<span class="als-prev"><img src="images/prev.png" alt="prev"
			title="previous" /></span>
		<div class="als-viewport">
			<ul class="als-wrapper">
				<%
					ArrayList<SANPHAM> topSanPhamRandom = (ArrayList<SANPHAM>) request
							.getAttribute("topSanPhamRandom");
					for (int i = 0; i < topSanPhamRandom.size(); i++) {
				%>
				<li class="als-item">
					<p id="tenSanPham"><%=topSanPhamRandom.get(i).getTenSanPham()%>
					</p> <a
					href="XemThongTinSanPhamServlet?id=<%=topSanPhamRandom.get(i).getIdSanPham()%>"><img
						title="<%=topSanPhamRandom.get(i).getTenSanPham()%>"
						src="images/products/<%=topSanPhamRandom.get(i).getHinhAnh()%>"></a>
					<p id="giaBan"><%=topSanPhamRandom.get(i).getGiaBan()%>
						VNĐ
					</p>
				</li>
				<%
					}
				%>
			</ul>
		</div>
		<span class="als-next"><img src="images/next.png" alt="next"
			title="next" /></span>
	</div>
</div>
<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<div id="content">
		<div id="title">TOP NEW FAST FOOD</div>
		<div id="contentPage">
			<div class="khung3">
				<div class="listsanpham">
					<%
						ArrayList<SANPHAM> topSanPhamMoiNhat = (ArrayList<SANPHAM>) request
								.getAttribute("topSanPhamMoiNhat");
						int i = 0;
						while (topSanPhamMoiNhat != null && i < topSanPhamMoiNhat.size()) {
					%>
					<div class="sanpham">
						<a
							href="XemThongTinSanPhamServlet?id=<%=topSanPhamMoiNhat.get(i).getIdSanPham()%>">
							<img alt=""
							src="images/products/<%=topSanPhamMoiNhat.get(i).getHinhAnh()%>">
						</a> <br> <a id="tenSanPham"
							href="XemThongTinSanPhamServlet?id=<%=topSanPhamMoiNhat.get(i).getIdSanPham()%>">
							<%=topSanPhamMoiNhat.get(i).getTenSanPham()%>
						</a> <br>
						<p>
							Price : <span><%=topSanPhamMoiNhat.get(i).getGiaBan()%> </span> đ
						</p>
						<a id="muaNgay"
							href="ThanhToanOnlineServlet?id=<%=topSanPhamMoiNhat.get(i).getIdSanPham()%>">
							Checkout </a> <a id="a<%=topSanPhamMoiNhat.get(i).getIdSanPham()%>"
							class="ghang"><img src="images/add-to-cart.png"
							align="bottom"></a>
					</div>
					<%
						i++;
						}
					%>
				</div>
			</div>
		</div>
		<div id="title">TOP HOT FAST FOOD</div>
		<div id="contentPage">
			<div class="khung3">
				<div class="listsanpham">
					<%
						ArrayList<SANPHAM> topSanPhamBanChay = (ArrayList<SANPHAM>) request
								.getAttribute("topSanPhamBanChay");
						int j = 0;
						while (topSanPhamBanChay != null && j < topSanPhamBanChay.size()) {
					%>
					<div class="sanpham">
						<a
							href="XemThongTinSanPhamServlet?id=<%=topSanPhamBanChay.get(j).getIdSanPham()%>">
							<img alt=""
							src="images/products/<%=topSanPhamBanChay.get(j).getHinhAnh()%>">
						</a> <br> <a id="tenSanPham"
							href="XemThongTinSanPhamServlet?id=<%=topSanPhamBanChay.get(j).getIdSanPham()%>">
							<%=topSanPhamBanChay.get(j).getTenSanPham()%>
						</a> <br>
						<p>
							Price : <span><%=topSanPhamBanChay.get(j).getGiaBan()%> </span> đ
						</p>
						<a id="muaNgay"
							href="ThanhToanOnlineServlet?id=<%=topSanPhamBanChay.get(j).getIdSanPham()%>">
							Checkout </a> <a id="a<%=topSanPhamBanChay.get(j).getIdSanPham()%>"
							class="ghang"><img src="images/add-to-cart.png"
							align="bottom"></a>
					</div>
					<%
						j++;
						}
					%>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="FILE\footer.jsp"%>
