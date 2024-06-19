<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .member-info table,
        .accommodation-info table {
            width: 100%;
            margin-bottom: 20px;
        }
        .member-info th,
        .accommodation-info th {
            text-align: left;
            border-bottom: 2px solid #dee2e6;
        }
        .member-info td,
        .accommodation-info td {
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3>예약자 정보</h3>
                <div class="member-info">
                    <table class="table table-bordered">
                        <tr>
                            <th>이름</th>
                            <td><c:out value="${member.name}" /></td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td><c:out value="${member.tel}" /></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-6">
                <h3>숙소 정보</h3>
                <div class="accommodation-info">
                        <table class="table table-bordered">
                            <c:forEach var="accommodation" items="${accommodation_list}">
    <tr>
        <th>숙소이름</th>
        <td><c:out value="${accommodation.ac_title}" /></td>
    </tr>
    <tr>
        <th>방이름</th>
        <td><c:out value="${accommodation.ro_name}" /></td>
    </tr>
    </c:forEach>
    <tr>
        <th>체크인</th>
        <td><c:out value="${param.checkin}" /></td>
    </tr>
    <tr>
        <th>체크아웃</th>
        <td><c:out value="${param.checkout}" /></td>
    </tr>
    <c:forEach var="accommodation" items="${accommodation_list}">
    <tr>
        <th>방가격</th>
        <td><c:out value="${accommodation.room_price}" /></td>
    </tr>
	</c:forEach>
             </table>
             <form action="/stay/booking/booking_insertview/payment" method="post" onsubmit="setDates()">
                <input type="hidden" name="email_id" value="${sessionScope.LoginVO.email_id}">
                <input type="hidden" name="room_num" value="${accommodation.room_num}">
                <input type="hidden" name="ac_id" value="${accommodation.ac_id}">
                <input type="hidden" name="checkin" value="${param.checkin}">
                <input type="hidden" name="checkout" value="${param.checkout}">
                <button type="button" class="btn btn-primary btn-sm instert-btn" data-bo-num="${booking.bo_num}">예약하기</button>
            </form>
                </div>
            </div>
        </div>
    </div>
    <script> 
    $(document).on('click', '.instert-btn', function(e) {
        e.preventDefault();

        var bo_num = $(this).data('bo_num');
        console.log("예약번호: " + bo_num);

        var form = $('<form>', {
            'action': '/stay/booking/booking_insert',
            'method': 'post'
        });
        
        form.append($('<input>', {
            'type': 'hidden',
            'name': 'email_id',
            'value': '${sessionScope.LoginVO.email_id}'
        }));
        
        form.append($('<input>', {
            'type': 'hidden',
            'name': 'status',
            'value': '1' // 예약 상태를 여기에 추가
        }));
        
        $('body').append(form);
        form.submit();
        
    });
    
    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', function(event) {
            let checkin = document.getElementById('checkin').value;
            let checkout = document.getElementById('checkout').value;
            this.querySelector('#hidden_checkin').value = checkin;
            this.querySelector('#hidden_checkout').value = checkout;
        });
    });
	</script>
</body>
</html>
