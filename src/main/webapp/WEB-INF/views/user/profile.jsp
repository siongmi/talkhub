<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>프로필 - TalkHub</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f7e3f2; /* 부드러운 연한 핑크 배경 */
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
      margin-top: 20px;
    }

    hr {
      border: 1px solid #ff66b3;
      width: 80%;
      margin: 20px auto;
    }

    ul {
      list-style-type: none;
      padding: 0;
      margin: 20px;
      background-color: #fff; /* 흰색 배경 */
      border-radius: 15px;
      padding: 20px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 */
    }

    li {
      font-size: 1.3em;
      margin: 10px 0;
      color: #d56db7;
    }

    a {
      color: #ff66b3; /* 핑크색 링크 */
      text-decoration: none;
      font-size: 1.2em;
      font-family: 'Cursive', sans-serif;
      text-shadow: 1px 1px 2px rgba(255, 105, 180, 0.6);
    }

    a:hover {
      color: #ff3385; /* 링크 마우스 오버시 핑크 색상 변경 */
      text-decoration: underline;
    }

    /* 스타일링된 버튼 */
    button {
      background-color: #ff66b3; /* 핑크색 버튼 */
      color: white; /* 흰색 텍스트 */
      font-size: 1.5em;
      font-family: 'Cursive', sans-serif;
      padding: 10px 20px;
      border: none;
      border-radius: 30px; /* 동그란 모서리 */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 */
      cursor: pointer;
      transition: all 0.3s ease-in-out; /* 부드러운 애니메이션 */
    }

    button:hover {
      background-color: #ff3385; /* 더 진한 핑크색으로 변화 */
      transform: scale(1.1); /* 버튼 크기 약간 확대 */
    }

    button:focus {
      outline: none; /* 포커스시 테두리 없애기 */
    }
  </style>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h2>프로필 확인</h2>

<hr/>

<ul>
  <li>아이디 : ${user.id}</li>
  <li>닉네임 : ${user.nickname}</li>
  <li>성별 : ${user.gender}</li>
  <li>생년 : ${user.birth}</li>
  <li>가입시기 : ${user.createAt}</li>
  <li><a href="${pageContext.request.contextPath}/post/list">TalkHub 게시판ㄱㄱ</a></li>
</ul>

<!-- Optional: A "edit profile" button -->
<div style="text-align: center; margin-top: 30px;">
  <button onclick="window.location.href='${pageContext.request.contextPath}/user/edit'">프로필 수정</button>
</div>
</body>
</html>
