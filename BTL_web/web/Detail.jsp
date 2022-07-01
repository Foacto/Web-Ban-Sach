<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/style2.css">
        <link rel="stylesheet" href="css/footer.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="trencung"></div>
            <div></div>
            <div class="thancontainer">
                <div class="hangsach">
                <jsp:include page="Left.jsp"></jsp:include>
                </div>
                <div class="thongtinsach">
                    <div class="thancontainer">
                        <div class="The">
                            <div class="hangsach">
                                <aside class="anhsach">
                                    <article class="goianh">
                                        <div class="anhlon">
                                            <div>
                                                <a href="#"><img src="img/${detail.image}"></a>
                                        </div>
                                    </div>
                                    <!--                                        <div class="tapanhbe">
                                                                                <div class="anhbe"> <img src="img/sherlock.jpg"> </div>
                                                                                <div class="anhbe"> <img src="img/sherlock.jpg"> </div>
                                                                                <div class="anhbe"> <img src="img/sherlock.jpg"> </div>
                                                                                <div class="anhbe"> <img src="img/sherlock.jpg"> </div>
                                                                            </div>-->
                                </article>
                            </aside>
                            <aside class="thongtinmuasach">
                                <article class="noidungthe">
                                    <h1 class="tieudesach">${detail.name}</h1>
                                    <p>
                                        <span class="giaquyensach"> 
                                            <span>VNĐ ₫</span><span>${detail.price}</span>
                                        </span>
                                    </p>
                                    <dl>
                                        <dt>Mô tả</dt>
                                        <dd>
                                            <p>${detail.decription} </p>
                                        </dd>
                                    </dl>
                                    <!--  <a href="#" class="nutmua"> Mua ngay </a>-->
                                    <c:if test="${sessionScope.acc == null}">
                                        <a href="Login.jsp" class="themvaogiohang">Thêm vào giỏ</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.role == 0}">
                                        <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${detail.id}" class="themvaogiohang">Thêm vào giỏ</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.role == 1}">
                                        <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${detail.id}" class="themvaogiohang">Thêm vào giỏ</a>
                                    </c:if>
<!--                                    <a href="${pageContext.request.contextPath}/cart?&action=buy&id=${detail.id}" class="nutthemvaogio">Thêm vào giỏ
                        </a>-->
                                </article>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
