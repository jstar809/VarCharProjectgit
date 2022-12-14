<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib tagdir="/WEB-INF/tags" prefix="koala" %>
    
<!DOCTYPE html>
<html>
 <head>
    <title>Carbook - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <link
      href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
      rel="stylesheet"
    />

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css" />
    <link rel="stylesheet" href="css/animate.css" />

    <link rel="stylesheet" href="css/owl.carousel.min.css" />
    <link rel="stylesheet" href="css/owl.theme.default.min.css" />
    <link rel="stylesheet" href="css/magnific-popup.css" />

    <link rel="stylesheet" href="css/aos.css" />

    <link rel="stylesheet" href="css/ionicons.min.css" />

    <link rel="stylesheet" href="css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="css/jquery.timepicker.css" />

    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="css/icomoon.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/login.css" />
  </head>
  <body>
    <koala:nav/>

    <section
      class="hero-wrap hero-wrap-2 js-fullheight"
      style="background-image: url('images/bg_3.jpg')"
      data-stellar-background-ratio="0.5"
    >
      <div class="overlay"></div>
      <div class="container">
        <div
          class="row no-gutters slider-text js-fullheight align-items-end justify-content-start"
        >
          <div class="col-md-9 ftco-animate pb-5">
            <p class="breadcrumbs">
              <span class="mr-2"
                ><a href="index.html"
                  >Home <i class="ion-ios-arrow-forward"></i></a
              ></span>
              <span>Blog <i class="ion-ios-arrow-forward"></i></span>
            </p>
            <h1 class="mb-3 bread">Our Blog</h1>
          </div>
        </div>
      </div>
    </section>
    <!----------------------????????? form------------------------->
    <div id="wrap">
      <!-- <div class="logo"><img src="./images/logo_user.jpg" alt="logo" /></div> -->
      <div id="loginContainer">
        <form name="login" action="" method="post">
          <p id="emailTitle">????????? ??????</p>
          <input
            name="email"
            type="email"
            id="emailInput"
            placeholder="????????? ??????"
            autocomplete="off"
          />

          <p id="pwTitle">????????????</p>
          <input
            name="pw"
            type="password"
            id="pwInput"
            placeholder="????????????"
            autocomplete="off"
          />

          <div>
            <button type="submit" id="loginBtn" disabled>?????????</button>
          </div>

          <div id="missing1">
            <p>???????????? '@' ????????? ???????????? ????????????!</p>
          </div>

          <div id="missing2">
            <p>???????????? ' . ' ????????? ???????????? ????????????!</p>
          </div>

          <div id="blank">
            <p>???????????? ?????? ????????? ????????????!</p>
          </div>

          <div id="short">
            <p>??????????????? 8?????? ?????? ???????????? ?????????!</p>
          </div>
        </form>

        <div id="findInner">
          <span
            ><a id="findIdPassword" href="search.html"
              >?????????/???????????? ??????</a
            ></span
          >
        </div>
        <div
          id="g_id_onload"
          data-client_id="615741589396-5dfl9sp8kj42s8i4609eulb0mv4cdreb.apps.googleusercontent.com"
          data-callback="handleCredentialResponse"
        ></div>

        <h2 class="subLogin"><span>????????? ???????????????</span></h2>
        <div id="">
          <!-- ????????? ????????? ApI ????????????????????? ??????=================================== -->
          <div style="text-align: center;">
        <a id="naver_id_login" href="javascript:void(0)"></a>
          </div>
          
        </div>
        <h2 class="subLogin"><span>?????? ????????? ?????????????</span></h2>
        <div id="registerInner">
          <a id="registerButton" href="signup.html">
            <span>????????????</span>
          </a>
        </div>

        <div id="moreService">
          <p>
            ??????????????? ?????? ????????? ??????, ?????????????????? ??? <br />??? ?????? ????????????
            ???????????? ??? ????????????.
          </p>
        </div>

        <div id="footer">
          <address>??? Yellow Balloon tour. All Rights Reserved.</address>
        </div>
      </div>
    </div>
    <!------------------------------>

   <koala:fotter/>

    <!-- loader -->
    <div id="ftco-loader" class="show fullscreen">
      <svg class="circular" width="48px" height="48px">
        <circle
          class="path-bg"
          cx="24"
          cy="24"
          r="22"
          fill="none"
          stroke-width="4"
          stroke="#eeeeee"
        />
        <circle
          class="path"
          cx="24"
          cy="24"
          r="22"
          fill="none"
          stroke-width="4"
          stroke-miterlimit="10"
          stroke="#F96D00"
        />
      </svg>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-migrate-3.0.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/jquery.timepicker.min.js"></script>
    <script src="js/scrollax.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script>
    <script src="js/main.js"></script>
    <!-- ????????? ???????????? =============================================-->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
  	var naver_id_login = new naver_id_login("Xkx0uuCjBlwxfo11qYok", "http://localhost:8088/VarCharProject/naverLogin.jsp");
  	var state = naver_id_login.getUniqState();
  	//naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8088/VarCharProject/login.jsp");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>

<!-- ????????? ???????????? =============================================-->
  </body>
</html>
