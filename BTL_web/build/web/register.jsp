<%-- 
    Document   : register
    Created on : Jun 2, 2022, 6:23:07 PM
    Author     : NCC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>

    <link rel="stylesheet" href="css/login.css">
</head>

<body>
    <div  class="trungtam">
        <h1>Register</h1>
        <form action = "signup" method="post">
            <div class="onhap">
                <input name="name" type="text" required="">
                <span></span>
                <label>Họ Tên</label>
            </div>
            <div class="onhap">
                <input name ="email" type="email" required="">
                <span></span>
                <label>Email</label>
            </div>
            <div class="onhap">
                <input name="password" type="password" required="">
                <span></span>
                <label>Mật khẩu</label>
            </div>
            <div class="onhap">
                <input name="repassword" type="password" required="">
                <span></span>
                <label>Nhập lại mật khẩu</label>
            </div>
            <input type="submit" value="Đăng ký">
            <div class="dangky">
                Đã là thành viên? <a href="Login.jsp">Đăng nhập</a>
            </div>
        </form>
    </div>
</body>

</html>
