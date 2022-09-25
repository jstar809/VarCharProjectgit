<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
 <!-- 찜 목록 -->
      <div class="cartOpenner"><strong>Cart</strong></div>
      <div class="cartContainer">
<c:choose>
	<c:when test="${mid!=null}">
        <h2 class="cartTitle">${mnickname} 님이관심 있는 차들</h2>
       </c:when>
       <c:otherwise>
       
       </c:otherwise>
</c:choose>
<h2 class="cartTitle">Cart</h2>
<!-- ------------------------------------------------------------------------ -->
          <hr />
<!-- 여기서 부터 장바구니 리스트 -->
        <div class="scrollAttach">
        
          <c:forEach var="sdatas" items="${sdatas}">
          <!-- 상담 예약이면 0으로변환 -->
       	<c:choose>
       		<c:when test="${sdatas.cprice!=2147483647}">
       			<c:set var="total" value="${total + sdatas.cprice}"/>
       		</c:when>
       		<c:otherwise>
       			<c:set var="total" value="${total + 0}"/>
       		</c:otherwise>
       	</c:choose>
         
         
          	<div class="cartItem">
            <div class="itemPhoto"> <img width="100%" alt="장바구니 사진" src="${sdatas.cimg}"> </div>
            <div class="itemInfo">
              <a href="detail.do?cnum=${sdatas.cnum}" class="itemTitle">${sdatas.ctitle}</a><br />
      			<a href="storeRemove.do?cnum=${sdatas.cnum}">x</a> 
              <span>연식 : ${sdatas.cyear}</span><br />
              <span>연료 : ${sdatas.cfuel}</span><br />
              <span>주행거리 : ${sdatas.ckm}km</span><br />
              <span>지역 : ${sdatas.ccity}</span><br />
              <span>가격 : 
              <c:choose>
              	<c:when test="${sdatas.cprice==2147483647}">
              		상담예약
              	</c:when>
              	<c:otherwise>
	              ${sdatas.cprice}만원
              	</c:otherwise>
              </c:choose>
              </span>
            </div>
          </div>
          <hr />
          </c:forEach>
         <!-- 상품 리스트 끝============================ -->
         
         
          <div class="totalPrice">
            <span>총 상품 금액</span>
            <strong>${total}만원</strong>
          </div>
          <div class="cartBtn">
          <c:choose>
	<c:when test="${mid!=null}">
          <button type="submit" onclick="location.href='myPage.jsp';">마이페이지</button>

       </c:when>
       <c:otherwise>
		   <button type="submit" onclick="location.href='login.jsp';">로그인 하기</button>
		   <button  color="red" type="submit" onclick="location.href='join.jsp';">회원 가입 하기</button>

		
       </c:otherwise>
</c:choose>
            <button class="cartCloser">Close Cart</button>
          </div>
        </div>
        <!-- 
		<div class="cartBtn">
		
		<button class="cartCloser">Close Cart</button>
	      </div>
         -->
	
      </div>