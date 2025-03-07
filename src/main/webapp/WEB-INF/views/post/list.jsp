
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #ffe6f2; /* 공주스럽고 부드러운 연한 핑크 배경 */
            margin: 0;
            padding: 0;
            color: #5a2a6c; /* 진한 보라색 텍스트 */
        }

        h1 {
            color: #ff66b3; /* 핑크 타이틀 */
            text-align: center;
            padding: 50px 0;
            font-size: 3.5em;
            font-family: 'Cursive', sans-serif;
            text-shadow: 3px 3px 5px rgba(255, 105, 180, 0.8); /* 귀여운 그림자 추가 */
        }

        h2 {
            color: #ff66b3; /* 부드러운 핑크 */
            font-size: 2.5em;
            text-align: center;
            font-family: 'Cursive', sans-serif;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 20px;
        }

        li {
            display: flex;
            justify-content: space-between;
            background-color: #ffffff; /* 흰색 배경 */
            margin: 10px 0;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 */
        }

        a {
            color: #ff66b3; /* 핑크색 링크 */
            text-decoration: none;
            font-size: 1.2em;
            font-family: 'Cursive', sans-serif;
        }

        a:hover {
            color: #ff3385; /* 링크 마우스 오버시 핑크 색상 변경 */
            text-decoration: underline;
        }

        .post-info {
            font-size: 1em;
            color: #d56db7;
            font-style: italic;
        }

        .post-info span {
            color: #ffb3d9; /* 글씨에 미세한 핑크 강조 */
        }

    </style>
</head>
<body>

<h1>TalkHub</h1>
<hr/>
<h2>TalkHub 게시판</h2>
<ul>
    <c:forEach var="one" items="${posts}">
        <li>
            <div>
                <a href="${pageContext.request.contextPath}/post/view?id=${one.id}">📝[${one.category}] ${one.title}</a>
            </div>
            <div class="post-info">
                ✍️ ${one.writerId} | 🕒 ${one.writedAt} | 👀 ${one.views} | ❤️ ${one.likes}
            </div>
        </li>
    </c:forEach>
</ul>

</body>
</ht
