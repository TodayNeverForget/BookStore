<%--
  Created by IntelliJ IDEA.
  User: YpEng
  Date: 2023/8/29
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--大导航开始--%>
<div id="page_nav">
    <%--首页/上一页--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%--字钮--%>
    <c:choose>

        <%--当小于5--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">

            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>


        </c:when>

        <c:when test="${requestScope.page.pageTotal > 5}">

            <c:choose>
                <%--当在中间--%>
                <c:when test="${requestScope.page.pageNo >= 3
							&& requestScope.page.pageNo <= requestScope.page.pageTotal - 2}">

                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>


                </c:when>


                <%--当在最左--%>
                <c:when test="${requestScope.page.pageNo < 3}">

                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>

                </c:when>

                <%--当在最右--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 2}">

                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>

                </c:when>

            </c:choose>
        </c:when>

    </c:choose>
    <%--接上--%>
    <c:forEach begin="${begin}" end="${end}" var="i">

        <c:if test="${i == requestScope.page.pageNo}">
            [${i}]
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
        </c:if>

    </c:forEach>

    <%--末页/下一页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    <%--导航--%>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="search" value="确定">


    <script type="text/javascript">

        $(function () {
            $("#search").click(function () {
                var pageNo = $("#pn_input").val();
                if (pageNo > ${requestScope.page.pageTotal}) {
                    pageNo = ${requestScope.page.pageTotal};
                } else if (pageNo < 1) {
                    pageNo = 1;
                }
                location.href = "http://localhost:8080//BookStore_war_exploded/client/clientBookServlet?action=page&pageNo=" + pageNo;
            });
        })

    </script>

</div>
<%--大导航结束--%>