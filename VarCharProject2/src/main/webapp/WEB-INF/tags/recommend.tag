<%@ tag language="java" pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <% %>
<div class="row">
	
          <div class="col-md-4">
            <div class="car-wrap rounded ftco-animate">
            <!-- 이미지 -->
              <div
                class="img rounded d-flex align-items-end"
                style="background:url('${cdata.cimg}') no-repeat center 80%;background-size:cover;">
             <!-- <img style="width:100%;,height:100%;" alt="크롤링한 페이지" src="${datas.cimg}"></img> -->
             </div>
             <!-- 제목 -->
              <div class="text">
                <h2 class="mb-0">
                  <a href="detail.html">${cdata.ctitle}</a>
                </h2>
                <!-- 키로수 -->
                <div class="d-flex mb-3">
                  <span class="cat">${cdata.ckm} km</span>
                  <!-- 가격 인트 의 최댓값일때 == 상담 예약으로 변경-->
                  <c:choose>
                  	<c:when test="${cdata.cprice==2147483647}">
                  		<p class="price ml-auto">상담예약</p>
                  	</c:when>
                  	<c:otherwise>
                  		<p class="price ml-auto">${cdata.cprice}<span>만원</span></p>
                  	</c:otherwise>
                  	
                  </c:choose>
                  
                </div>
                <p class="d-flex mb-0 d-block">
                  <a href="storeAdd.do?cnum=${cdata.cnum}" class="btn btn-primary py-2 mr-1">예약 하기</a>
                  <a href="detail.do?cnum=${cdata.cnum}" class="btn btn-secondary py-2 ml-1"
                    >자세한 정보</a>
                </p>
               
              </div>
            </div>
          </div>
	
          
  </div>