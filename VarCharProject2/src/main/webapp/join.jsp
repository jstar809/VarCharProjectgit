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
    <link rel="stylesheet" href="./css/signup.css" />
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
    <!----------------------회원가입 form------------------------->
    <div class="joinbox">
      <div id="signupContainer">
        <form class="contact-form" data-aos="fade-up" data-aos-delay="200">
          <div class="form-group">
            <label class="text-black" for="id">ID</label>
            <div id="inputbox">
              <div id="idboxtop">
                <span id="idinput">
                  <input type="text" class="form-control" id="id" />
                </span>
                <button id="idboxbottomright">중복확인</button>
              </div>
              <div class="warnbox">
                <span>아이디 형식이 잘못 되었습니다.</span>
              </div>
              <!-- <div id="idboxbottom">
                <span id="idboxbottomleft"
                  >본인 소유의 이메일 계정이 아닐 경우 임의로 삭제될 수
                  있습니다.</span
                >
                <button id="idboxbottomright">중복확인</button>
              </div> -->
            </div>
          </div>
          <div id="inputbox">
            <label class="text-black" for="fname">Password</label>
            <div id="pwboxtop">
              <input
                type="text"
                class="form-control"
                placeholder="비밀번호(영문 숫자 조합, 8~12자리)"
                id="password"
                autocomplete="off"
              />
            </div>
            <div class="warnbox">-영문,숫자 조합 8~12자리</div>
            <label class="text-black checkPwLabel" for="fname"
              >Check Password</label
            >
            <div id="pwboxbottom">
              <input
                type="text"
                class="form-control"
                placeholder="비밀번호 확인"
                id="passwordck"
                autocomplete="off"
              />
            </div>
            <div class="warnbox">
              <span>비밀번호와 비밀번호 확인이 불일치합니다.</span>
            </div>
          </div>
          <div id="inputbox">
            <label class="text-black" for="fname">Name</label>
            <div id="namebox">
              <input
                type="text"
                class="form-control"
                placeholder="이름(실명)"
                id="nameinput"
              />
            </div>
            <div class="warnbox">
              <span>이름은 한글 영어만 입력 가능합니다.</span>
            </div>
          </div>

          <div id="inputbox">
            <label class="text-black" for="fname">Nickname</label>
            <div id="nicknamebox">
              <input
                type="text"
                class="form-control"
                placeholder="닉네임"
                id="nicknameinput"
              />
            </div>
            <div class="warnbox">
              <span>이름은 한글 영어만 입력 가능합니다.</span>
            </div>
          </div>

          <div id="inputbox">
            <label class="text-black" for="fname">Phone</label>
            <div id="phonebox">
              <div id="phoneboxleft">
                <input
                  type="text"
                  class="form-control"
                  placeholder="휴대폰번호(숫자만 입력)"
                  id="phoneinput"
                  autocomplete="off"
                />
              </div>
              <button id="phoneboxright">인증번호 발송</button>
            </div>
            <div class="warnbox">형식에 맞게 적어주세요</div>
          </div>
          <div class="warnbox">
            <span>이메일 형식이 잘못 되었습니다.</span>
          </div>

          <div id="inputbox">
            <label class="text-black" for="fname">Email</label>
            <div id="emailboxtop">
              <span id="emailinput">
                <input type="email" class="form-control" id="email" />
              </span>
            </div>
            <div class="warnbox">
              <span>이메일 형식이 잘못 되었습니다.</span>
            </div>
            <div id="emailboxbottom">
              <span id="emailboxbottomleft"
                >본인 소유의 이메일 계정이 아닐 경우 임의로 삭제될 수
                있습니다.</span
              >
              <!-- <button id="emailboxbottomright">중복확인</button> -->
            </div>
          </div>

          <div id="inputbox">
            <label class="text-black" for="fname">Birth</label>
            <div id="birthbox">
              <div id="birthboxleft">
                <input
                  type="text"
                  class="form-control"
                  placeholder="생년월일(예 : 19900101)"
                  id="birthinput"
                />
              </div>
              <div id="birthboxright">
                <span
                  ><input
                    type="radio"
                    class="genderbox"
                    checked="checked"
                    name="gender"
                    id="male"
                  />&nbsp;&nbsp;남</span
                >
                <span
                  ><input
                    type="radio"
                    class="genderbox"
                    name="gender"
                    id="female"
                  />&nbsp;&nbsp;여</span
                >
              </div>
            </div>
            <div class="warnbox">8자리입니다.</div>
          </div>
          <div id="inputbox">
            <div id="myinfock">
              <strong>개인정보 유효기간&nbsp;</strong
              ><button type="button" class="btn_infomore"></button>
            </div>
            <div class="hiddenbox">
              <ul class="hiddenboxul">
                <li>
                  3년 이상으로 설정하시면 장기 미 이용 시에 휴면계정으로
                  전환되지 않고 노랑풍선 회원으로 유지되어 다양한 혜택을
                  이용하실 수 있습니다.
                </li>
                <li>
                  개인정보 파기 또는 분리 저장·관리하는 서비스 미이용 기간을
                  위의 선택 기간으로 요청합니다.
                </li>
                <li>
                  별도의 요청(선택)이 없으실 경우 서비스 미이용 기간은
                  1년(기본값)으로 설정됩니다.
                </li>
              </ul>
            </div>
            <div>
              <span class="yearbox"
                ><input
                  type="radio"
                  class="yearboxcheck"
                  checked="checked"
                  name="year"
                />&nbsp;&nbsp;회원 탈퇴 시 까지</span
              >
              <span class="yearbox"
                ><input
                  type="radio"
                  class="yearboxcheck"
                  checked="checked"
                  name="year"
                />&nbsp;&nbsp;5년</span
              >
              <span class="yearbox"
                ><input
                  type="radio"
                  class="yearboxcheck"
                  checked="checked"
                  name="year"
                />&nbsp;&nbsp;3년</span
              >
              <span class="yearbox"
                ><input
                  type="radio"
                  class="yearboxcheck"
                  checked="checked"
                  name="year"
                />&nbsp;&nbsp;1년</span
              >
            </div>
          </div>

          <div id="inputbox">
            <div id="agreeboxtop">
              <span
                ><input type="checkbox" id="agree1" class="agreeck" /><label
                  for="agree1"
                  class="agreelabel"
                  >&nbsp;(필수) 약관 전체 동의</label
                ></span
              >
              <span
                ><input type="checkbox" id="agree2" class="agreeck" /><label
                  for="agree2"
                  class="agreelabel"
                  >&nbsp;(선택) 약관 전체 동의</label
                ></span
              >
            </div>
            <div id="agreeboxbottom">
              <ul id="agreeul">
                <li class="agreeli">
                  <input type="checkbox" id="agree3" class="agreeck" /><label
                    for="agree3"
                    class="agreelabel"
                    >&nbsp;(필수) 노랑풍선 이용약관 동의</label
                  ><span class="agreespan"><a href="#">(전체보기)</a></span>
                </li>
                <li class="agreeli">
                  <input type="checkbox" id="agree4" class="agreeck" /><label
                    for="agree4"
                    class="agreelabel"
                    >&nbsp;(필수) 만14세 이상 확인</label
                  ><span class="agreespan"><a href="#">(전체보기)</a></span>
                </li>
                <li class="agreeli">
                  <input type="checkbox" id="agree5" class="agreeck" />
                  <label for="agree5" class="agreelabel"
                    >&nbsp;(필수) 개인정보 수집 및 이용 동의</label
                  >
                  <span class="agreespan"><a href="#">(전체보기)</a></span>
                </li>
                <li class="agreeli">
                  <input type="checkbox" id="agree6" class="agreeck" /><label
                    for="agree6"
                    class="agreelabel"
                    >&nbsp;(선택) 개인정보 수집 및 이용 동의</label
                  ><span class="agreespan"><a href="#">(전체보기)</a></span>
                </li>
                <li class="agreeli">
                  <span
                    ><input type="checkbox" id="agree7" class="agreeck" /><label
                      for="agree7"
                      class="agreelabel"
                      >&nbsp;(선택) 마케팅 정보 수신 동의</label
                    ></span
                  >
                  <div id="agreelibottom">
                    <span
                      ><input
                        type="checkbox"
                        class="checkboxbottom agreeck"
                        id="agree8"
                      /><label for="agree8" class="agreelabel"
                        >&nbsp;이메일</label
                      ></span
                    >
                    <span
                      ><input
                        type="checkbox"
                        class="checkboxbottom agreeck"
                        id="agree9"
                      /><label for="agree9" class="agreelabel"
                        >&nbsp;SMS</label
                      ></span
                    >
                  </div>
                </li>
              </ul>
            </div>
          </div>

          <button type="submit" id="submitbox">가입완료</button>
        </form>
      </div>
    </div>

    <!--fotter-->

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
  </body>
</html>
