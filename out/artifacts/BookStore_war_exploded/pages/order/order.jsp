<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

	<%@ include file="/pages/common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>

		<%@ include file="/pages/common/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>

			<c:forEach items="${requestScope.myOrders}" var="order">

				<tr>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td>${order.status eq 0 ? "未发货" : order.status eq 1 ? "已发货" : "已收货"}</td>
					<td><a href="orderServlet?action=orderDetail
					&orderId=${order.orderId}">查看详情</a></td>
				</tr>

			</c:forEach>


		</table>
		
	
	</div>

	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>