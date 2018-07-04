<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>直推会员信息</title>
    <%@ include file="/common/admin/head.jsp" %>
</head>
<body>
<span ${empty directChild ? "style='font-size: 20px'":"style='display: none'"} >&nbsp;&nbsp;&nbsp; 没有直推</span>
<section class="content" ${empty directChild ? "style='display: none'":""}>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>姓名</th>
            <th>昵称</th>
            <th>性别</th>
            <th>城市</th>
            <th>手机号</th>
            <th>最后登录时间</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${directChild}" var="one">
            <tr>
                <td>${one.name}</td>
                <td>${one.nickname}</td>
                <td>${one.gender eq 1?'男':(one.gender eq 2?'女':'不详')}</td>
                <td>${one.city}</td>
                <td>${one.mobile}</td>
                <td>${one.loginTime}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</section>
<%@ include file="/common/admin/my_js.jsp" %>
</body>
</html>
