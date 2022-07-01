<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Quản Lý Tài Khoản</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/manager.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <!--begin of menu-->
        <jsp:include page="Menu.jsp"></jsp:include>
            <!--end of menu-->
            <div class="container">
                <div class="quanlysanpham">
                    <div class="tieudequanly">
                        <div class="hangtieude">
                            <div class="nuadong">
                                <h2>Quản lý <b>Tài khoản</b></h2>
                            </div>
                            <div class="nuadong">
                                <a href="loadAdd" class="nut nutthem"><span>Thêm sản phẩm mới</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="bangtaikhoan">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Tùy chọn</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listU}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>${o.email}</td>
                                <td>${o.password}</td>
                                <td>
                                    <a href="loadEditUser?uid=${o.id}" class="nut chinhsua">Chỉnh sửa</a>
                                    <a href="deleteUser?uid=${o.id}" class="nut nutxoa">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>