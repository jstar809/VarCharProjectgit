<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib tagdir="/WEB-INF/tags" prefix="koala" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
        <!-- △위에는 배열의 길이를 사용하기위해 사용 △-->
        
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
  <!--  
		<link rel="stylesheet" href="css/jquery.timepicker.css" />
  -->
    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="css/icomoon.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/filterSearch.css" />
    <script
      src="https://code.jquery.com/jquery-3.6.1.min.js"
      integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
      crossorigin="anonymous"
    ></script>
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
                ><a href="main.html"
                  >Home <i class="ion-ios-arrow-forward"></i></a
              ></span>
              <span>Cars <i class="ion-ios-arrow-forward"></i></span>
            </p>
            <h1 class="mb-3 bread">Choose Your Car</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section bg-light">
      <div class="filterOpenner"><strong>filter</strong></div>
      <!-- 8.20 김종현 수정(필터 검색란 추가) -->
       <div class="filterContainer">
        <div class="filterCloser">
          <h2 class="filterTitle">Close Filter</h2>
          <!-- <i class="filterMark"></i> -->
        </div>
        <hr />

        <form action="" method="post">
          <!--상품 정렬-->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>상품 정렬</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>
            <select name="">
              <option selected>최신 순</option>
              <option>가격 순</option>
              <option>주행거리 순</option>
            </select>
          </div>
          <hr />
          <!--연식 검색-->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>연식</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>
            <select name="">
              <option selected>하한</option>
              <option>1</option>
              <option>2</option>
            </select>
            <span class="between"> ~</span>
            <select name="">
              <option selected>상한</option>
              <option>1</option>
              <option>2</option>
            </select>
          </div>
          <hr />

          <!-- 연료 검색 -->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>연료</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>
            <ul id="fuelFilter">
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">전체</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">LPG</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">휘발유</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">경유</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">CNG</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="fuel">전기</label>
                </span>
              </li>
            </ul>
          </div>
          <hr />
          <!--주행거리 검색-->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>주행거리</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>

            <!--   <select name="">
              <option selected>하한</option>
              <option>1</option>
              <option>2</option>
            </select>
            <span class="between"> ~</span>
            <select name="">
              <option selected>상한</option>
              <option>1</option>
              <option>2</option>
            </select> -->

            <div class="slideContainer">
              <div>
                <div class="col-sm-12">
                  <div id="slider-range"></div>
                </div>
              </div>
              <div class="slider-labels">
                <div>
                  <strong>최소 :&nbsp;&nbsp;</strong>
                  <span id="slider-range-value1"></span>&nbsp;&nbsp;km
                </div>
                <div>
                  <strong>최대 :&nbsp;&nbsp;</strong>
                  <span id="slider-range-value2"></span>&nbsp;&nbsp;km
                </div>
              </div>
              <div>
                <div class="col-sm-12">
                  <form>
                    <input type="hidden" name="min-value" value="" />
                    <input type="hidden" name="max-value" value="" />
                  </form>
                </div>
              </div>
            </div>
          </div>
          <hr />
          <!--가격 검색-->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>가격</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>

            <select name="">
              <option selected>하한</option>
              <option>1</option>
              <option>2</option>
            </select>
            <span class="between"> ~</span>
            <select name="">
              <option selected>상한</option>
              <option>1</option>
              <option>2</option>
            </select>
          </div>
          <hr />
          <!-- 지역 검색 -->
          <div class="filterBox hideFilter">
            <div class="filterBoxTitle">
              <label>지역</label>
              <i class="openArrow"
                ><img src="images/down_arrow.png" alt="down arrow"
              /></i>
            </div>

            <ul id="regionFilter">
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">전체</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">서울</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">경기</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">인천</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">강원</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">충북</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">충남</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">대전</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">세종</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">경북</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">경남</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">대구</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">부산</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">울산</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">전북</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">전남</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">광주</label>
                </span>
              </li>
              <li>
                <span>
                  <input type="checkbox" value="" />
                  <label class="region">제주</label>
                </span>
              </li>
            </ul>
          </div>
          <hr />
          <!-- 검색 / 초기화 버튼 -->
          <button type="submit" class="filterBtn">상세조건 검색</button>
          <button class="intializeBtn">초기화</button>
        </form>
      </div>

      <!-- 찜 목록---------------------------------- -->
   		  <koala:zzim/>
      
      <!---------------------------------- -->

      <div class="container">
       <div id="infinityScroll" value="fsc"> 
      <!-- 차 목록 -->
       
       
         <koala:fitterSearchRow/>
      
       <!-- ============== -->
       </div>
      
      <script type="text/javascript">
      window.onscroll = function(e) {
    	    //추가되는 임시 콘텐츠
    	    //window height + window scrollY 값이 document height보다 클 경우,
    	    if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
    	    	//실행할 로직 (콘텐츠 추가)
    	//    	var fsr=document.querySelector("#infinityScroll").innerHTML='<koala:fitterSearchRow/>';
    	        var addContent = '<div class="block"><p>번째로 추가된 콘텐츠</p></div>';
    	        //article에 추가되는 콘텐츠를 append
    	        $('#infinityScroll').append(addContent);
    	    }
    	};
      </script>
       
       
        <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              총 ${fn:length(cdatas)} 게시물을 보고 있습니다
                <!-- 
              <ul>
                <li><a href="#">&lt;</a></li>
				<c:forEach var="i" begin="1" end="${(fn:length(cdatas)/12)+1}">
					<li><a href="#">${i}</a></li>				
				</c:forEach>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
                
              </ul>
                 -->
            </div>
                <button id="viewMore" type="button" class="moreContent">view more</button>
               <!--  원본
               
                 <button type="button" class="moreContent" onclick="location.href='filterSearch.do?cnt=${cnt+1}';">view more</button>
               -->
          </div>
        </div>
      </div>
    </section>
<!-- 
     <koala:fotter/>	
 -->

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
    <script src="js/filterOpenner.js"></script>
    <script src="js/cartOpenner.js"></script>
    <script src="js/rangeSlider.js"></script>
  

  </body>
</html>
