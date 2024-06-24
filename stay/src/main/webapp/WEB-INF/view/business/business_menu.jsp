<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<title>메뉴 페이지</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary mt-5">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" style="margin: auto;">
                <li class="nav-item active">
                    <a id="addition_list_link" class="nav-link" href="#" style="color: black;
                    font-size: 20px; margin-right: 30px;">내숙소 보기</a>
                </li>
                
                <li class="nav-item active">
    				<a id="business_booking" class="nav-link" href="#"
    					style="color: black; font-size: 20px; margin-right: 30px;">예약 확인</a>
				</li>
                <li class="nav-item active">
                    <a id="business_checkin" class="nav-link" href="#"
                    	style="color: black; font-size: 20px; margin-right: 30px;">체크인</a>
                </li>
                <li class="nav-item active">
                    <a id="business_checkout" class="nav-link" href="#"
                    style="color: black; font-size: 20px; margin-right: 30px;">체크아웃</a>
                </li>
                <li class="nav-item active">
                    <a id="review_manage_link" class="nav-link" style="color: black;
                    font-size: 20px; margin-right: 20px;">리뷰관리</a>
                </li>
            </ul>
        </div>
    </nav>
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#review_manage_link').on('click', function(e) {
			//     	alert("숙소 수정 뷰 링크 함수 실행됨");
			    e.preventDefault(); // 기본 액션 막음. (중복 막음)        
			    var form = $('<form>', {
			        'action': '../review/business_review',
			        'method': 'post'
			    });
			    form.append($('<input>', {
			        'type': 'hidden',
			        'name': 'email_id',
			        'value': '${sessionScope.LoginVO.email_id}'
			    }));
			
			    $('body').append(form);
			    form.submit();
			});
		
		//숙소 list 링크 함수 modify_accommodation_link
		$('#addition_list_link').on('click', function(e) {
		//     	alert("숙소 수정 뷰 링크 함수 실행됨");
		    e.preventDefault(); // 기본 액션 막음. (중복 막음)        
		    var form = $('<form>', {
		        'action': '/stay/business/bc_ac_list',
		        'method': 'post'
		    });
		    form.append($('<input>', {
		        'type': 'hidden',
		        'name': 'email_id',
		        'value': '${sessionScope.LoginVO.email_id}'
		    }));
		
		    $('body').append(form);
		    form.submit();
		});
		
		
		
		//숙소 추가 링크 함수 addition_accommodation_link
	    $('#addition_accommodation_link').on('click', function(e) {
	//     	alert("숙소 추가 뷰 링크 함수 실행됨");
	        e.preventDefault(); // 기본 액션 막음. (중복 막음)        
	        var form = $('<form>', {
	            'action': '/stay/accommodation/insert_view',
	            'method': 'post'
	        });
	        form.append($('<input>', {
	            'type': 'hidden',
	            'name': 'email_id',
	            'value': '${accommodationlist[0].email_id}'
	        }));
	        form.append($('<input>', {
	            'type': 'hidden',
	            'name': 'bu_name',
	            'value': '${accommodationlist[0].bu_name}'
	        }));
	        form.append($('<input>', {
	            'type': 'hidden',
	            'name': 'ac_id',
	            'value': '${accommodationlist[0].ac_id}'
	        }));
	
	        $('body').append(form);
	        form.submit();
	    });
		
	    $('#business_booking').on('click', function(e) {
	    	//     	alert("숙소 추가 뷰 링크 함수 실행됨");
	    	        e.preventDefault(); // 기본 액션 막음. (중복 막음)        
	    	        var form = $('<form>', {
	    	            'action': '/stay/business/business_booking',
	    	            'method': 'post'
	    	        });
	    	        form.append($('<input>', {
	    	            'type': 'hidden',
	    	            'name': 'email_id',
	    	            'value': '${sessionScope.LoginVO.email_id}'
	    	        }));
	    	        $('body').append(form);
	    	        form.submit();
	    	    });
	    
	    $('#business_checkin').on('click', function(e) {
	    	//     	alert("숙소 추가 뷰 링크 함수 실행됨");
	    	        e.preventDefault(); // 기본 액션 막음. (중복 막음)        
	    	        var form = $('<form>', {
	    	            'action': '/stay/business/business_checkin',
	    	            'method': 'post'
	    	        });
	    	        form.append($('<input>', {
	    	            'type': 'hidden',
	    	            'name': 'email_id',
	    	            'value': '${sessionScope.LoginVO.email_id}'
	    	        }));
	    	        $('body').append(form);
	    	        form.submit();
	    	    });
	    
	    $('#business_checkout').on('click', function(e) {
	    	//     	alert("숙소 추가 뷰 링크 함수 실행됨");
	    	        e.preventDefault(); // 기본 액션 막음. (중복 막음)        
	    	        var form = $('<form>', {
	    	            'action': '/stay/business/business_checkout',
	    	            'method': 'post'
	    	        });
	    	        form.append($('<input>', {
	    	            'type': 'hidden',
	    	            'name': 'email_id',
	    	            'value': '${sessionScope.LoginVO.email_id}'
	    	        }));
	    	        $('body').append(form);
	    	        form.submit();
	    	    });
	});
	
	
	
</script>
    
</body>
</html>
