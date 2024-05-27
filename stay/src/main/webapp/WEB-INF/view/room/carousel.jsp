<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>AdvancedCarousel</title>
  <style>
  	* {
	  padding: 0px;
	  margin: 0px;
	  box-sizing: border-box;
	}
	
	.carousel-container {
	  width: 100%;
	  height: 90%;
	  margin: auto;
	  overflow: hidden;
	  position: relative;
	}
	
	.carousel-slide {
	  display: flex;
	  height: 100%;
	  position: relative;
	}
	
	.carousel-slide.shifting {
	  transition: transform .2s ease-out;
	}
	
	.img {
	  flex: 0 0 auto;
	  width: 100%;
	  height: 100%;
	  text-align: center;
	  cursor: pointer;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  transition: all 1s;
	  background: transparent;
	  border-radius: 2px;
	}
	
	.prev,
	.next {
	  position: absolute;
	  top: 50%;
	  transform: translateY(-50%);
	  width: 50px;
	  height: 50px;
	  border-radius: 50px;
/* 	  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.3); */
	  background-size: 22px;
	  background-position: center;
	  background-repeat: no-repeat;
	  cursor: pointer;
	}
	
	.prev {
	  background-image: url(https://cdn0.iconfinder.com/data/icons/navigation-set-arrows-part-one/32/ChevronLeft-512.png);
	  left: 20px;
	}
	
	.next {
	  background-image: url(https://cdn0.iconfinder.com/data/icons/navigation-set-arrows-part-one/32/ChevronRight-512.png);
	  right: 20px;
	}
	
	.prev:active,
	.next:active {
	  width: 40px;
	  height: 40px;
	}
  </style>
</head>
<body>
    <div class="carousel-container">
      <div class="carousel-slide">
<!--       	c태그 taglib은 detail of detail에 있음 -->
      	<c:forEach items="${ro_pic_list}" var="ro_pic">
	        <div class="img">                     
	        	<img src="../resources/img/room/${ro_pic.pic_name}" alt="../resources/img/room/${ro_pic.pic_name}">
	        </div>
<!-- 	        <div class="img">Slide 2</div> -->
<!-- 	        <div class="img">Slide 3</div> -->
<!-- 	        <div class="img">Slide 4</div> -->
<!-- 	        <div class="img">Slide 5</div> -->
		</c:forEach>
      </div>
      <button id="prev" class="prev"></button>
      <button id="next" class="next"></button>
    </div>
    
    
    
    
    
    
  <script>
	  const carouselContainer = document.querySelector('.carousel-container');
	  const carouselSlide = document.querySelector('.carousel-slide');
	  const carouselImages = document.querySelectorAll('.img');
	
	  const prev = document.querySelector('#prev');
	  const next = document.querySelector('#next');
	
	  // í°ì¹ì ëëê·¸ ê¸¸ì´
	  const threshold = 100;
	
	  const slideWidth = carouselImages[0].clientWidth;
	  const slidesLength = carouselImages.length;
	
	  // ì²«ë²ì§¸ ì´ë¯¸ì§ê° ëíëëë¡ í¨. (ì§ê¸ ë§¨ì²ìêº¼ì lastCloneì´ ìê³  ë§ì§ë§ì firstCloneì´ ìì¼ë¯ë¡)
	  carouselSlide.style.transform = `translateX(${-slideWidth}px)`;
	
	  let posX1 = 0;
	  let posX2 = 0;
	  let posInitial;
	  let posFinal;
	
	  const firstSlide = carouselImages[0];
	  const lastSlide = carouselImages[slidesLength - 1];
	  const cloneFirst = firstSlide.cloneNode(true);
	  const cloneLast = lastSlide.cloneNode(true);
	
	  // Clone first and last slide
	  carouselSlide.appendChild(cloneFirst);
	  carouselSlide.insertBefore(cloneLast, firstSlide);
	
	  let index = 0;
	  let allowShift = true; // ë²ì´ëë ê±° ë§ì (ìì ì½ë) - í¸ëì§ìì´ ëëë©´ ë¤ì í´ë¦­ ê°ë¥
	  let offsetLeft;
	
	  const dragStart = (e) => {
	    e = e || window.event;
	    e.preventDefault();
	    posInitial = (-slideWidth*(index+1));
	    offsetLeft = posInitial;
	    if (e.type == 'touchstart') {
	      posX1 = e.touches[0].clientX;
	    } else {
	      posX1 = e.clientX;
	      document.onmouseup = dragEnd;
	      document.onmousemove = dragAction;
	    }
	  }
	
	  const dragAction = (e) => {
	    e = e || window.event;
	    if (e.type == 'touchmove') {
	      posX2 = posX1 - e.touches[0].clientX;
	      posX1 = e.touches[0].clientX;
	    } else {
	      posX2 = posX1 - e.clientX;
	      posX1 = e.clientX;
	    }
	    offsetLeft -= posX2;
	    carouselSlide.style.transform = "translateX("+(offsetLeft) + "px)";
	  }
	      
	  const dragEnd = (e) => {
	    posFinal = offsetLeft;
	    if (posFinal - posInitial < -threshold) {
	      shiftSlide(1, 'drag');
	    } else if (posFinal - posInitial > threshold) {
	      shiftSlide(-1, 'drag');
	    } else {
	      carouselSlide.style.transform = "translateX(" + (posInitial) + "px)";
	    }
	    document.onmouseup = null;
	    document.onmousemove = null;
	  }
	      
	  const shiftSlide = (dir, action) => {
	    carouselSlide.classList.add('shifting');
	    
	    if (allowShift) { // ë²ì´ëë ê±° ë§ì (ìì ì½ë) - í¸ëì§ìì´ ëëë©´ ë¤ì í´ë¦­ ê°ë¥
	      if (!action) { posInitial = (-slideWidth*(index+1)); }
	      // next
	      if (dir == 1) {
	        carouselSlide.style.transform = "translateX(" + (posInitial - slideWidth) + "px)";
	        index++;   
	      // prev   
	      } else if (dir == -1) {
	        carouselSlide.style.transform = "translateX(" + (posInitial + slideWidth) + "px)";
	        index--;      
	      }
	    };
	    
	    allowShift = false;
	  }
	    
	  const checkIndex = () => {
	    carouselSlide.classList.remove('shifting');
	    if (index == -1) {
	      carouselSlide.style.transform = "translateX(" + (-(slidesLength * slideWidth)) + "px)";
	      index = slidesLength - 1;
	    }
	    if (index == slidesLength) {
	      carouselSlide.style.transform = "translateX(" + (-(1 * slideWidth)) + "px)";
	      index = 0;
	    }
	    
	    allowShift = true; // ë²ì´ëëê±° ë§ì (ìì ì½ë)
	  }
	
	  // Mouse events
	  carouselSlide.onmousedown = dragStart;
	
	  // Touch events
	  carouselSlide.addEventListener('touchstart', dragStart);
	  carouselSlide.addEventListener('touchmove', dragAction);
	  carouselSlide.addEventListener('touchend', dragEnd);
	
	
	  // Click events
	  prev.addEventListener('click', (e) => shiftSlide(-1));
	  next.addEventListener('click', (e) => shiftSlide(1));
	
	  // Transition events
	  carouselSlide.addEventListener('transitionend', checkIndex);
  
  </script>
</body>
</html>