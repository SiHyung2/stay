<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Business Check-in</title>
    <style>
        .con {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            margin-top: 50px;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        h3 {
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .table:first-child {
            margin-top: 20px;
        }
        .checkout-text {
            display: none;
        }
    </style>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <%@include file="./business_menu.jsp"%>
    <div class="con">
        <h3>입실 전</h3>
        <table class="table" style="margin-top: 50px;">
            <thead>
                <tr>
                    <th scope="col">예약번호</th>
                    <th scope="col">객실이름</th>
                    <th scope="col">체크인</th>
                    <th scope="col">체크아웃</th>
                    <th scope="col">예약자</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">예약상태</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${businessbooking}">
                    <c:if test="${booking.status == 2}">
                        <tr>
                            <td>${booking.bo_num}</td>
                            <td>${booking.ro_name}</td>
                            <td>${booking.checkin_day}</td>
                            <td>${booking.checkout_day}</td>
                            <td>${booking.name}</td>
                            <td>${booking.tel}</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-sm checkout-btn" data-bo-num="${booking.bo_num}">체크인</button>
                                <span class="checkout-text">입실완료</span>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
        <h3>입실 후</h3>
        <table class="table" style="margin-top: 50px;">
            <thead>
                <tr>
                    <th scope="col">예약번호</th>
                    <th scope="col">객실이름</th>
                    <th scope="col">체크인</th>
                    <th scope="col">체크아웃</th>
                    <th scope="col">예약자</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">예약상태</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${businessbooking}">
                    <c:if test="${booking.status == 3}">
                        <tr>
                            <td>${booking.bo_num}</td>
                            <td>${booking.ro_name}</td>
                            <td>${booking.checkin_day}</td>
                            <td>${booking.checkout_day}</td>
                            <td>${booking.name}</td>
                            <td>${booking.tel}</td>
                            <td>입실완료</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).on('click', '.checkout-btn', function(e) {
            e.preventDefault();

            var bo_num = $(this).data('bo_num');
            console.log("예약번호: " + bo_num);

            var form = $('<form>', {
                'action': /stay/business/business_checkin_update',
                'method': 'post'
            });

            form.append($('<input>', {
                'type': 'hidden',
                'name': 'bo_num',
                'value': bo_num
            }));
            
            form.append($('<input>', {
	            'type': 'hidden',
	            'name': 'email_id',
	            'value': '${sessionScope.LoginVO.email_id}'
	        }));
            
            form.append($('<input>', {
                'type': 'hidden',
                'name': 'status',
                'value': '2' // 예약 상태를 여기에 추가
            }));
            

            $('body').append(form);
            form.submit();

            // 버튼 숨기기 및 텍스트 표시
            $(this).hide();
            $(this).siblings('.checkout-text').show();
        });

        document.addEventListener('DOMContentLoaded', function () {
            const checkoutBtns = document.querySelectorAll('.checkout-btn');
            const checkoutTexts = document.querySelectorAll('.checkout-text');

            checkoutBtns.forEach((btn, index) => {
                btn.addEventListener('click', function () {
                    btn.style.display = 'none'; // 버튼 숨기기
                    checkoutTexts[index].style.display = 'inline'; // 퇴실완료 텍스트 보이기
                });
            });
        });
    </script>
</body>
</html>
