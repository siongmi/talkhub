<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>나의 게시판</title>
</head>
<body>
<h1>나의 게시판</h1>
<form action="${pageContext.request.contextPath}/post/write-proceed" method="get">
    <p>
        <label>아이디</label>
    <div>
        <input type="text" name="writer_id">
    </div>
    </p>
    <p>
        <label>카테고리</label>
    <div>
    <label><input type="radio" name="category" value="일상"/>일상/</label>
    <label><input type="radio" name="category" value="일상"/>음악/</label>
    <label><input type="radio" name="category" value="일상"/>특별한일/</label>
    <label><input type="radio" name="category" value="일상"/>기타/</label>
    </div>
    </p>
    <p>
        <label>제목</label>
    <div>
        <input type="text" name="title">
    </div>
    </p>
    <p>
        <label>내용</label>
    <div>
        <input type="text" name="content">
    </div>
    </p>

    <button type="submit">제출</button>

</form>
</body>
</html>
