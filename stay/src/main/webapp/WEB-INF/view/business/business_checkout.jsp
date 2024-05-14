<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Insert title here</title>
    <style>
        .con {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            margin-top: 50px;
            text-align: center; /* 텍스트 가운데 정렬 */
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: center; /* 텍스트 가운데 정렬 */
        }
        th {
            background-color: #f2f2f2; /* 헤더 배경색 설정 */
        }
        h3 {
            margin-top: 20px; /* 마진 탑 설정 */
            margin-bottom: 20px; /* 아래쪽 마진 설정 */
        }
        .table:first-child {
            margin-top: 20px; /* 테이블 위쪽에 마진 추가 */
        }
        .checkout-text {
            display: none; /* 초기에는 숨김 */
        }
    </style>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <%@include file="./business_menu.jsp"%>
    <div class="con">
        <h3>퇴실 전</h3>
        <table class="table" style="margin-top: 50px;">
            <thead>
                <tr>
                    <th scope="col">예약번호</th>
                    <th scope="col">객실이름</th>
                    <th scope="col">체크인</th>
                    <th scope="col">체크아웃</th>
                    <th scope="col">예약자</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">에약상태</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${booking.bo_num}test</td>
                    <td>${booking.ro_type}</td>
                    <td>${booking.checkin_day}</td>
                    <td>${booking.checkout_day}</td>
                    <td>${booking.email_id}</td>
                    <td>${booking.phoneNumber}</td>
                   	<td><button type='button' class="btn btn-primary btn-sm checkout-btn">체크아웃</button></td>
                </tr>
            </tbody>
        </table>
        <h3>퇴실 후</h3>
        <table class="table" style="margin-top: 50px;">
            <thead>
                <tr>
                    <th scope="col">예약번호</th>
                    <th scope="col">객실이름</th>
                    <th scope="col">체크인</th>
                    <th scope="col">체크아웃</th>
                    <th scope="col">예약자</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">에약상태</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${booking.bo_num}test</td>
                    <td>${booking.ro_type}</td>
                    <td>${booking.checkin_day}</td>
                    <td>${booking.checkout_day}</td>
                    <td>${booking.email_id}</td>
                    <td>${booking.phoneNumber}</td>
                    <td><span class="checkout-text">퇴실완료</span></td>
                </tr>
            </tbody>
        </table>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const checkoutBtn = document.querySelector('.checkout-btn');
            const checkoutText = document.querySelector('.checkout-text');

            checkoutBtn.addEventListener('click', function () {
                checkoutBtn.style.display = 'none'; // 버튼 숨기기
                checkoutText.style.display = 'inline'; // 퇴실완료 텍스트 보이기
            });
        });
    </script>
</body>
</html>
