<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 5.
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
    <h2>토크허브에 회원가입하기</h2>
        <form action="${pageContext.request.contaxtPath}/join-proceed" method="post"></form>
    <div>
<label>아이디</label>
<div>
    <input type="text" name="id"/>
</div>
<c:if test="${idError !=null}"/>
    <div style="color:darkred; font-size:small">${idError}</div>
    </div>

    <div>
    <label>비밀번호</label>
<div>
    <input type="password" name="password"/>
</div>
<c:if test="${passwordError !=null}"/>
    <div style="color:darkred; font-size:small">${passwordError}</div>
    </div>

    <div>
    <label>닉네임</label>

<div>
    <input type="text" name="nickname"/>
</div>
<c:if test="${nicknameError !=null}"/>
    <div style="color:darkred; font-size:small">${nicknameError}</div>
    </div>
    <div>
    <label>성별</label>
<div>
    <label><input type="radio" value="남" name="gender"/>남</label>
    <label><input type="radio" value="여" name="gender"/>여</label>
    <label><input type="radio" value="비공개" name="gender"/>비공개</label>
</div>
<c:if test="${genderError !=null}"/>
    <div style="color:darkred; font-size:small">${genderError}</div>
    </div>
    <div>
    <label>출생연도</label>
<div>
    <select name="birth">
        <c:forEach var="i" begin="1970" end="2025">
            <option value="${i}">${i}년</option>
        </c:forEach>
    </select>
</div>
    </div>
<button type="submit">회원가입</button>
</form>
</body>
</html>

