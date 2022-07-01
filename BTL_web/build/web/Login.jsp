<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>

    <link rel="stylesheet" href="css/login.css">
</head>

<body>
    <div class="trungtam">
        <h1>Login</h1>
        <form action = "login" method="post">
            <p class="Thongbao">${mess}</p>
            <div class="onhap">
                <input name = "username" type="text" required = "">
                <span></span>
                <label>Tên đăng nhập</label>
            </div>
            <div class="onhap">
                <input name = "password" type="password" required = "">
                <span></span>
                <label>Mật khẩu</label>
            </div>
            <div class="quenmatkhau">Quên mật khẩu?</div>
            <input type="submit" value="Đăng nhập">
            <div class="dangky">
                Chưa phải thành viên? <a href="register.jsp">Đăng ký</a>
            </div>
        </form>
    </div>
</body>

</html>