<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <link rel="stylesheet" href="css/cart.css">
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="thongtingiohang">
                <div class="container">
                    <div class="hangthongtinsach">
                        <div class="thongtinmuasach">

                            <!-- Shopping cart table -->
                            <div class="bangthongtinsach">
                                <table class="bang">
                                    <thead>
                                        <tr>
                                            <th scope="cot">
                                                <div class="tieudesanpham">Sản Phẩm</div>
                                            </th>
                                            <th scope="cot">
                                                <div class="tieudesanpham">Đơn Giá</div>
                                            </th>
                                            <th scope="cot">
                                                <div class="tieudesanpham">Số Lượng</div>
                                            </th>
                                            <th scope="cot">
                                                <div class="tieudesanpham">Tùy chọn</div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>   
                                    <c:forEach var="cart" items="${cart_1}">
                                        <c:set var="total" value="${total + cart.item.product.price * cart.item.quantity }"></c:set>
                                            <tr>
                                                <th scope="hang">
                                                    <div>
                                                        <img src="img/${cart.item.product.image}" alt="" width="70" class="anhsach">
                                                    <div class="tensach1">
                                                        <h5> <a href="#" class="tensach2">${cart.item.product.name}</a></h5>
                                                    </div>
                                                </div>
                                            </th>
                                            <td class="cangiua"><strong>${cart.item.product.price * cart.item.quantity }</strong></td>
                                            <td class="cangiua">
                                                <c:if test="${cart.item.quantity > 1}">
                                                    <a href="${pageContext.request.contextPath}/cart?action=sub&id=${cart.item.product.id}"><button class="nutthem">-</button></a>
                                                </c:if>
                                                <c:if test="${cart.item.quantity <= 1}">
                                                    <a><button class="nutthem">-</button></a>
                                                </c:if>
                                                <strong>${cart.item.quantity}</strong> 
                                                <a href="${pageContext.request.contextPath}/cart?&action=buy&id=${cart.item.product.id}"><button class="nutgiam">+</button></a>
                                            </td>
                                            <td class="cangiua">
                                                <a href="${pageContext.request.contextPath}/cart?action=remove&id=${cart.item.product.id}">
                                                    <button type="button"  class="nutxoa">Xóa</button>
                                                </a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                </div>
                <div class="thongtinthanhtoan">
                    <div class="bangthongtinthanhtoan">
                        <div class="thanhtien">Thành tiền</div>
                        <div class="noidungthanhtoan">
                            <ul class="bangthanhtoan">
                                <li class="hangthanhtoan"><strong>Tổng tiền hàng</strong><strong>${total }</strong></li>
                                <li class="hangthanhtoan"><strong>Phí vận chuyển</strong><strong>Free ship</strong></li>
                                <li class="hangthanhtoan"><strong>Tổng thanh toán</strong><strong class="sotienthanhtoan">${total}</strong>
                                </li>
                            </ul><a href="${pageContext.request.contextPath}/cart?action=checkout" class="muahang">Mua hàng</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
                        
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>

</html>