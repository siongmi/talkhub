<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TalkHub</title>
  <style>
    body {
      font-family: 'Poppins', sans-serif;
      background-color: #ffd0f3; /* 부드럽고 밝은 핑크 배경 */
      color: #d49bd4; /* 은은한 보라색 텍스트 */
      margin: 0;
      padding: 0;
      background-image: url('https://www.transparenttextures.com/patterns/linen.png'); /* 배경 텍스처 추가 */
      background-size: cover;
    }

    h1 {
      color: #ff6ef6; /* 밝은 핑크 */
      text-align: center;
      padding: 50px 0;
      font-size: 3.5em;
      text-shadow: 3px 3px 10px rgba(255, 105, 180, 0.8); /* 귀여운 텍스트 그림자 */
      font-weight: 700;
      letter-spacing: 3px; /* 글자 간격을 넓혀서 귀엽게 */
    }

    h3 {
      color: #ff85d6; /* 부드러운 핑크 */
      font-size: 2.5em;
      text-align: center;
      padding-bottom: 10px;
      font-weight: 600;
      letter-spacing: 1px;
    }

    .post-details, .post-stats {
      font-size: 1.2em;
      color: #a5678e;
      text-align: center;
    }

    .post-details span, .post-stats span {
      color: #ffccd9; /* 밝은 핑크 */
    }

    hr {
      border: 0;
      border-top: 3px solid #ff8cfa;
      margin: 20px auto;
      width: 80%;
      background: rgba(255, 140, 250, 0.4); /* 부드러운 그라데이션 느낌 */
    }

    .content {
      white-space: pre-wrap;
      line-height: 1.8;
      color: #76346c;
      font-size: 1.2em;
      padding: 20px;
      background-color: #fffbff; /* 아기자기한 흰색 배경 */
      border-radius: 25px;
      box-shadow: 0 10px 20px rgba(255, 105, 180, 0.2);
      max-width: 80%;
      margin: 30px auto;
      transform: rotate(-2deg); /* 내용 박스에 귀여운 회전 효과 */
      animation: bounce 1.5s ease infinite; /* 내용이 뛰는 듯한 효과 */
    }

    @keyframes bounce {
      0%, 20%, 50%, 80%, 100% {
        transform: translateY(0); /* 위로 튀는 효과 */
      }
      40% {
        transform: translateY(-10px); /* 위로 살짝 튕기기 */
      }
      60% {
        transform: translateY(-5px); /* 살짝 덜 튕기기 */
      }
    }

    .decorative-box {
      background-color: #fffbff;
      border-radius: 25px;
      padding: 40px;
      box-shadow: 0 10px 20px rgba(255, 105, 180, 0.2);
      max-width: 80%;
      margin: 30px auto;
      text-align: center;
    }

    .decorative-box p {
      font-size: 1.5em;
      color: #76346c;
      font-weight: 600;
    }

    .heart {
      color: #ff6ef6;
      font-size: 3em;
      animation: pulse 1.5s infinite;
    }

    @keyframes pulse {
      0% {
        transform: scale(1);
      }
      50% {
        transform: scale(1.2);
      }
      100% {
        transform: scale(1);
      }
    }

    /* 귀엽고 화려한 좋아요 버튼 스타일 */
    .like-button {
      background-color: #ff6ef6; /* 밝은 핑크색 */
      color: #fff;
      font-size: 1.5em;
      border: none;
      border-radius: 50px; /* 둥근 모서리 */
      padding: 15px 30px;
      cursor: pointer;
      transition: all 0.3s ease;
      box-shadow: 0 5px 15px rgba(255, 105, 180, 0.4);
      font-weight: bold;
    }

    .like-button:hover {
      background-color: #ff85d6; /* 호버 시 부드러운 핑크 */
      transform: scale(1.1); /* 크기가 커짐 */
    }

    .like-button:active {
      transform: scale(0.95); /* 클릭 시 버튼 크기 작아짐 */
      box-shadow: 0 5px 10px rgba(255, 105, 180, 0.4);
    }

  </style>
</head>
<body>
<h1>TalkHub</h1>
<hr/>
<h3>[${post.category}] ${post.title}</h3>

<div class="post-details">
  <div>작성자 ${post.writerId} <span>|</span> 작성일 ${post.writedAt}</div>
</div>

<div class="post-stats">
  <div>조회 ${post.views} <span>|</span> 추천 ${post.likes}</div>
</div>

<hr/>

<p class="content">${post.content}</p>
<hr/>

<!-- 텍스트 아래에 좋아요 버튼 추가 -->
<div class="decorative-box">
  <p>💖 이 게시글을 좋아요! 💖</p>
  <a href="${pageContext.request.contextPath}/post/likes?id=${post.id}">
    <button type="button" class="like-button">좋아요</button>
  </a>
</div>

<hr/>
</body>
</html>
