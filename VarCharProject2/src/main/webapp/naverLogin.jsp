<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("Xkx0uuCjBlwxfo11qYok", "http://localhost:8088/VarCharProject/naverLogin.jsp");
  // 접근 토큰 값 출력
  //alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	//이름 이메일 아이디(이메일에서 투스트링) 닉네임  나이 전화번호
	
	//가져 올수 있는 정보
	//아이디 		이메일	 이름 	별명
	var mid=naver_id_login.getProfileData('email');
	var mname=naver_id_login.getProfileData('name');
	var mnickname=naver_id_login.getProfileData('nickname');
	var memail=naver_id_login.getProfileData('email');
	//나이랑 전화번호는 가져올수없음 ==undefined
	// var madd=
	// var mphone=
    
	// 알림 창 off
	//alert(naver_id_login.getProfileData('name'));
  //  alert(naver_id_login.getProfileData('nickname'));
   // alert(naver_id_login.getProfileData('age'));
 //   console.log(naver_id_login.getProfileData('birthyear'));
    window.opener.location.href='naverlogin.do?mid='+mid+'&mname='+mname+'&mnickname='+mnickname+'&memail='+memail;
    window.close();
  }
  
</script>
</body>
</html>