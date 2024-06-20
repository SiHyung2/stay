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
                    <form action="/stay/booking/booking_insert" method="post">
                        <input type="hidden" name="email_id" value="${sessionScope.LoginVO.email_id}">
                        <c:forEach var="accommodation" items="${accommodation_list}">
                            <input type="hidden" name="room_num" value="${accommodation.room_num}">
                            <input type="hidden" name="ac_id" value="${accommodation.ac_id}">
                        </c:forEach>
                        <input type="hidden" name="checkin" value="${param.checkin}">
                        <input type="hidden" name="checkout" value="${param.checkout}">
                        <button type="submit" class="btn btn-primary btn-sm">예약하기</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
