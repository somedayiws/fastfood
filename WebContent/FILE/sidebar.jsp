<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.DANHMUC"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.SANPHAM"%>

<div id="sidebar">
	<div id="category">
		<div id="title">Category</div>
		<div id="contentCategory">
			<%
				//Load dữ liệu danh mục
				ArrayList<DANHMUC> dm = (ArrayList<DANHMUC>) request
						.getAttribute("danhmuc");
				if (dm != null) {
			%>
			<ul>
				<%
					int idm = 0;
						while (idm < dm.size()) {
				%>
				<a href="SanPham?idDanhMuc=<%=dm.get(idm).getIdDanhMuc()%>"
					style="text-decoration: none"><li><%=dm.get(idm).getDanhMuc()%>
				</li> </a>
				<%
					idm++;
						}
					}
				%>
			</ul>
		</div>
	</div>
	<div id="category" class="divPhanAnDaChon">
		<div id="title">My cart</div>
		<div id="contentCategory">
			<div class="giohang">
				<%@include file="../GioHangOnline.jsp"%>
			</div>
		</div>
	</div>
</div>
