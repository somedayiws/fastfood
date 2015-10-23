<%@page import="model.bean.KHACHHANG"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.bean.QUANTRI"%>
<link rel="stylesheet"	href="font-awesome-4.4.0/css/font-awesome.min.css">
<html>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="top_nav">
				<ul>
					<li><a href="ThanhToanOnlineServlet"><i class="fa fa-shopping-cart"> </i>
					My Cart </a></li>
				</ul>
			</div>
			<div id="logoBar">
				<div id="logo">
					<a href="TrangChu" title="Oh!FastFood.vn"><img src="images/logo.png"></a>
				</div>
				<div id="search">
					<form method="post" action="SanPham" name="TimKiem">
						<input type="text" placeholder="Search fast foods ..."
							name="txtSearch"> <a href="javascript:TimKiem.submit()">Search</a>
					</form>
				</div>
			</div>
			<div id="top_menu">
				<ul>
					<li><a href="TrangChu"> Home page </a></li>
					<li><a href="SanPham"> Products </a></li>
				</ul>
				<div id="hotline">(+84) 935905659</div>
			</div>
		</div>