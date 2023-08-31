<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>

	<%@ include file="/pages/common/head.jsp"%>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情页</span>

		<div>
			<a href="orderServlet?action=myOrders">返回</a>
		</div>

	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>

			<%--不发此判断--%>
			<c:if test="${not empty requestScope.orderItems}">

				<c:forEach items="${requestScope.orderItems}" var="orderItem">

					<tr>
						<td>${orderItem.name}</td>
						<td>${orderItem.count}</td>
						<td>${orderItem.price}</td>
						<td>${orderItem.totalPrice}</td>
					</tr>

				</c:forEach>

			</c:if>

			
		</table>

	</div>

	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>