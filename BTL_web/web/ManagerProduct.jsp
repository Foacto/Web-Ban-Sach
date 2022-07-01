<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý sách</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="quanlysanpham">
                    <div class="tieudequanly">
                        <div class="hangtieude">
                            <div class="nuadong">
                                <h2>Quản lý <b>Sản phẩm</b></h2>
                            </div>
                            <div class="nuadong">
                                <a href="loadAdd" class="nut nutthem"><span>Thêm sản phẩm mới</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="bangsanpham">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên</th>
                                <th>Ảnh</th>
                                <th>Giá</th>
                                <th>Tùy chọn</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr> 
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img class="imgP" src="img/${o.image}">
                                </td>
                                <td>${o.price}$</td>
                                <td>
                                    <a href="loadProduct?pid=${o.id}" class="nut chinhsua" title="">Chỉnh sửa</a>
                                    <a href="${pageContext.request.contextPath}/delete?pid=${o.id}" class="nut nutxoa" title="">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="chanbang">
                    <div class="thongbaoxemsp">Xem <b>1</b> trên <b>10</b> mặt hàng</div>
                    <ul class="danhsachtrangsp">
                        <c:if test="${tag > 1}">
                            <li class="noidunglink"><a href="manager?index=${tag-1}" linktrang>Trước</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${endP}" var="i">
                            <li class="${tag == i?"noidunglink active":"noidunglink"}"><a href="manager?index=${i}" class="linktrang">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag < endP}">
                            <li class="noidunglink"><a href="manager?index=${tag+1}" linktrang>Tiếp</a></li>
                            </c:if>
                    </ul>

                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="js/manager.js" type="text/javascript"></script>
        <script>
        </script>
    </body>

</html>