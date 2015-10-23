<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.bean.QUANTRI"%>
<script>
	$(document).ready(function() {
		var $newOrders = $("#newOrders");
		var $deliveryOrders = $("#deliveryOrders");
		var $resultDiv = $("#resultDiv");
		$.ajax({
			url : "CapNhatSoLuongDonHangServlet",
			type : "post",
			dateType : "text",
			success : function(result) {
				//Kết quả số đơn hàng trả về trong đoạn text
				$resultDiv.html(result);
				$newOrders.children('p').text($('#newOrdersNum').text());
				$deliveryOrders.children('p').text($('#delivery').text());
			}
		});
		var refreshId = setInterval(function() {
			$.ajax({
				url : "CapNhatSoLuongDonHangServlet",
				type : "post",
				dateType : "text",
				success : function(result) {
					//Kết quả số đơn hàng trả về trong đoạn text
					$resultDiv.html(result);
					$newOrders.children('p').text($('#newOrdersNum').text());
					$deliveryOrders.children('p').text($('#delivery').text());
				}
			});
		}, 15000);
	});
</script>


<html>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="title">MANAGEMENT</div>
			<div id="top_nav">
				<div id="welcome">
					<p>Hello! Admin</p>
				</div>
				<div id="user_icon">
						<img src="images/user.png" width="35px" height="35px">
				</div>
			</div>
		</div>