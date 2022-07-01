<%-- 
    Document   : CheckOut
    Created on : Jun 14, 2022, 12:47:42 AM
    Author     : sonnk
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin mua hàng</title>
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="row">
            <div class="col-75">
                <div class="container">
                    <form action="pay" method="post">
                        <div class="row">
                            <div class="col-50">
                                <h3>Thông tin mua hàng</h3>
                                <label for="fname"><i class="fa fa-user"></i> Họ tên</label>
                                <input type="text" id="fname" name="firstname" placeholder="${u.name}" readonly >
                                <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                <input type="text" id="email" name="email" placeholder="${u.email}" readonly >
                                <label for="fname"><i class="fa fa-phone"></i> Số điện thoại</label>
                                <input type="text" id="fname" name="phone" placeholder="Sô điện thoại">
                                <label for="adr"><i class="fa fa-address-card-o"></i> Địa chỉ giao</label>
                                <input type="text" id="adr" name="address" placeholder="Số nhà - Tên ngõ - Tên Đường" >

                                <div class="row">
                                    <div class="col-50">
                                        <a href="${pageContext.request.contextPath}/cart">
                                            <button type="button"  class="btn">Quay lại Giỏ</button>
                                        </a>
                                    </div>
                                    <div class="col-50">
                                        <a href="${pageContext.request.contextPath}/cart?action=pay">
                                            <input type="submit" value="Đặt Hàng" class="btn">
                                        </a>
                                    </div>
                                </div>
                            </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
