<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.DANHMUC"%>
<%@page import="model.bean.SANPHAM"%>
<%@page import="java.util.ArrayList"%>

<%@include file="FILE\HEAD.jsp"%>
<%@include file="ScriptAnimation.jsp"%>
<script type="text/javascript" src="js/jquery.als-1.7.min.js"></script>
<link rel="stylesheet" href="css/slider.css" type="text/css">

<script type="text/javascript">
	$(document).ready(function() {
		$("#demo1").als({
			visible_items : 4,
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
			alert("Load success!");
		}
	});
</script>


<%@include file="FILE\header.jsp"%>
<div id="primary">
	<%@include file="FILE\sidebar.jsp"%>
	<div id="content">
		<div id="title">Information of food</div>
		<div id="contentPage">
			<div class="noidung">
				<%
					SANPHAM sp = (SANPHAM) request.getAttribute("sanpham");
				%>
				<div id="imgDes">
					<img src="images/products/<%=sp.getHinhAnh()%>">
				</div>
				<div id="infoProduct">
					<h2>
						Name :
						<%=sp.getTenSanPham()%>
					</h2>
					<h1>
						Price :
						<%=sp.getGiaBan()%>
						đ
					</h1>
					<strong> Description : </strong> <br>
					<p id="thongTinThem">
						<%=sp.getMoTa()%>
					</p>
					<p id="btnMuaSanPham">
						<%-- 						<a href="ThanhToanOnlineServlet?id=<%=sp.getIdSanPham()%>"> --%>
						<!-- 							Mua sản phẩm này</a> -->
						<a id="muaNgay"
							href="ThanhToanOnlineServlet?id=<%=sp.getIdSanPham()%>"> Checkout </a> <a id="a<%=sp.getIdSanPham()%>" class="ghang"><img
							src="images/add-to-cart.png" align="bottom"></a>
					</p>

				</div>
			</div>

		</div>
		<div id="slideProducts">
			<div id="title">MAY BE YOU WANT</div>
			<div class="als-container" id="demo1">
				<span class="als-prev"><img src="images/prev.png" alt="prev"
					title="previous" /></span>
				<div class="als-viewport">
					<ul class="als-wrapper">
						<%
							ArrayList<SANPHAM> arrLienQuan = (ArrayList<SANPHAM>) request
									.getAttribute("arrLienQuan");
							if (arrLienQuan != null) {
								for (int i = 0; i < arrLienQuan.size(); i++) {
						%>
						<li class="als-item">
							<p id="tenSanPham"><%=arrLienQuan.get(i).getTenSanPham()%>
							</p> <a
							href="XemThongTinSanPhamServlet?id=<%=arrLienQuan.get(i).getIdSanPham()%>"><img
								title="<%=arrLienQuan.get(i).getTenSanPham()%>"
								src="images/products/<%=arrLienQuan.get(i).getHinhAnh()%>"></a>
							<p id="giaBan"><%=arrLienQuan.get(i).getGiaBan()%>
								VNĐ
							</p>
						</li>
						<%
							}
							}
						%>
					</ul>
				</div>
				<span class="als-next"><img src="images/next.png" alt="next"
					title="next" /></span>
			</div>
		</div>
	</div>
</div>

<%@include file="FILE\footer.jsp"%>