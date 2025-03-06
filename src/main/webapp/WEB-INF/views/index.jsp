<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오전 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TalkHub</title>
    <style>
        .color-primary {
            color: powderblue;
            font-size: large;
        }
    </style>
</head>
<body>
<h1 style="color:pink">TalkHub</h1>
<p>토크허브를 통해 사람들과 의견을 나누세요</p>
<c:choose>
    <c:when test="${authentication}">
<div>
    <a href="">마이페이지</a>
    <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
</div>
    </c:when>
    <c:otherwise>
<div>
    <form action="${pageContext.request.contextPath}/join">
        <button type="submit">회원가입</button>
    </form>

    <form action="${pageContext.request.contextPath}/login">
        <button type="submit">로그인</button>
    </form>
</div>
    </c:otherwise>
</c:choose>
<p>
    TalkHub 에 오신것을 환영합니다람쥐
</p>
</body>
</html>
