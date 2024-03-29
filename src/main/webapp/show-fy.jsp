<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2019/4/8
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页页面</title>
</head>
<body>
<table align="center" border="1" bgcolor="#6495ed" cellspacing="10" cellpadding="15">
    <tr>
        <td><a href="javascript:toPage(1)">首页</a></td>
        <td><a href="javascript:toPage(${sessionScope.page.currPage-1})">上一页</a></td>
        <c:forEach var="i"  begin="1" end="${sessionScope.page.totalPage}">
            <td><a href="javascript:toPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:toPage(${sessionScope.page.currPage+1})">下一页</a></td>
        <td><a href="javascript:toPage(${sessionScope.page.totalPage})">尾页</a></td>
        <td>跳到第 <input type="text" size="1" name="" value="${sessionScope.page.currPage}">页
            <input type="button" name="" onclick="toPage(this.previousElementSibling.value)" value="GO"></td>
    </tr>
</table>

</body>
<script >
    //参数就是当前页
    function toPage(pageNo) {
        if(pageNo<=1){
            pageNo=1;
        }
        if(pageNo>=${sessionScope.page.totalPage}){
            pageNo=${sessionScope.page.totalPage};
        }
        location.href="/show?currPage="+pageNo;

    }
</script>
</html>
