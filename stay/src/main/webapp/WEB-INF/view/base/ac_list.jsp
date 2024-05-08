<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SEARCH</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--     c태그를 이용하여 절대주소로 css파일과 연결되었다 -->
	<link href="<c:url value="/resources/css/search.css" />" rel="stylesheet" type="text/css">
</head>

<body>
	<%@include file="../base/menu.jsp" %> 
<%-- 	<%@include file="<c:url value="/WEB-INF/base/menu.jsp" />" %>  --%>
    <div class="container">
<!--     	미완 -->
    	<form>
	        <aside class="left-aside">
	        	<div>
	        		<h2>상세 조건</h2>
	        	</div>
	            
	            <div>
	                 <!-- 가는 날  -->
	                 <div class="datepicker">
	                    <label for="go_day">가는 날</label>
	                    <input type="date" id="go_day" name="go_day">
	                  </div>
	                 <!-- 오는 날  -->
	                 <div class="datepicker">
	                    <label for="Comming_day">오는 날</label>
	                    <input type="date" id="Comming_day" name="Comming_day">
	                  </div>
	            </div>
	            <div>
	                <h2>인원수</h2>
	                <div class="people_number">
	                    <input type="text" id="people_number_input" class="input-field" value="0" readonly>
	                    <button type="button" class="people_number_button" id="increment">+</button>
	                    <button type="button" class="people_number_button" id="decrement">-</button>
	                </div>
	            </div>
	            
	            <!-- 인원 수 선택창  (이 스크립트는 반드시 인원수 html코드 밑에 위치해야한다) -->
	            <script>
	                const input = document.getElementById('people_number_input');
	                const incrementBtn = document.getElementById('increment');
	                const decrementBtn = document.getElementById('decrement');
	
	                incrementBtn.addEventListener('click', () => {
	                    let value = parseInt(input.value);
	                    input.value = value + 1;
	                });
	
	                decrementBtn.addEventListener('click', () => {
	                    let value = parseInt(input.value);
	                    if (value > 0) {
	                        input.value = value - 1;
	                    }
	                });
	
	            </script>
	            <div>
	                <h2>검색</h2>
	                <!-- 검색어 -->
	                <input id="search_word" class="search_word" type="text" name="search_word" 
	                        placeholder="숙소 이름 또는 지역 검색">
	
	            </div>
	            <!-- 체크박스 form으로 컨트롤러로 데이터 전송하는 법
	            https://ktae23.tistory.com/187
	            값은 value값이 들어간다 -->
	            <div>
	                <h2>숙소 유형</h2>
	                <div>
	                    <input type="checkbox" id="hotel" name="hotel" value="hotel" checked>
	                    <!-- label의 for속성값과 input의 id을 일치시켜서 input과 label이 연결되었다 라벨을 클릭해도 체크박스가 체크된다 -->
	                    <label for="hotel">호텔</label><br>
	                    <input type="checkbox" id="motel" name="motel" value="motel" >
	                    <label for="motel">모텔</label><br>
	                    <input type="checkbox" id="pension" name="pension" value="pension">
	                    <label for="pension">펜션</label><br>
	                    <input type="checkbox" id="resort" name="resort" value="resort">
	                    <label for="resort">리조트</label><br>
	                    <input type="checkbox" id="home_villa" name="home_villa" value="home_villa">
	                    <label for="home_villa">홈&빌라</label><br>
	                    <input type="checkbox" id="guest_house" name="guest_house" value="guest_house">
	                    <label for="guest_house">게하</label><br> 
	                    <input type="checkbox" id="camping" name="camping" value="camping">
	                    <label for="camping">캠핑</label><br>
	                    
	                </div>
	            </div>
	
	            <button id="search_button" class="search_button" name="search_button" onclick="javascript: form.action='/stay/search/aside_search';">검색</button>
	            
	        </aside>
    	</form>

		
	        <section class="accommodation-list">
	        	<c:forEach items="${accommodation_list}" var="accommodation">
	            <div>
	                <asdie class="accommodation-img">
	                    숙소 이미지
	                </asdie>
		                <div class="accommodation-content">
		                    <div class="accommodation-title">
		                    	<h3>${accommodation.ac_title} &nbsp; ${accommodation.ac_address}</h3>
		                    </div>
		                    <div class="accommodation-infomation">
		                    	<h4>${accommodation.ac_info}    &nbsp;&nbsp;지도 보기(미구현)</h4>
		                    </div>
		                    <div class="accommodation-price">
		                    	<h1>${accommodation.min_room_price} 원</h1>
		                    </div>
		                    <button class="accommodation-button" 
		                        onclick="location.href='/stay/accommodation/detail?ac_id=${accommodation.ac_id}'">
		                    	숙소로 이동
		                    </button>
		                </div>
	            </div>
	            </c:forEach>
	        </section>        
        
        
    </div>
</body>
</html>