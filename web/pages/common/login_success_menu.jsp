<%--
  Created by IntelliJ IDEA.
  User: YpEng
  Date: 2023/8/28
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临杨鹏的书城</span>
    <a href="orderServlet?action=myOrders">我的订单</a>
    <a href="userServlet?action=logOut">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
