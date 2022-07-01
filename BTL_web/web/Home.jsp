<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang chủ</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="thancontainer">
                <div class="noidungthan">
                    <div class="cot">
                        <nav aria-label="duongdan">
                            <ol class="duongdan">
                                <li class="duongdan-item"><a href="home">Trang chủ</a></li>
                                <li class="duongdan-item"><a href="#">Thể loại</a></li>
                                <c:forEach items="${listC}" var="o">
                                    <c:if test="${o.id == cId}">
                                        <li class="duongdan-item active" aria-current="#">${o.name}</li>
                                    </c:if>
                            </c:forEach>
                                
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="thancontainer">
                <div class="hangsach">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="cotdssach">
                        <div id="content" class="hangsach">
                        <c:forEach items="${listP}" var="o">
                            <div class="Sach">
                                <div class="The">
                                    <img src="img/${o.image}" alt="Ảnh sách">
                                    <div class="Thanthe">
                                        <h4 class="tieudethe"><a href="detail?pid=${o.id}" title="Xem sản phẩm">${o.name}</a></h4>
                                        <p class="tieudethe">${o.category_name}</p>
                                        <div class="hang">
                                            <div class="cot">
                                                <p class="Giasachmua">${o.price} ₫</p>
                                            </div>
                                            <div class="cot">   
                                                <c:if test="${sessionScope.acc == null}">
                                                    <a href="Login.jsp" class="themvaogiohang">Thêm vào giỏ</a>
                                                </c:if>
                                                <c:if test="${sessionScope.acc.role == 0}">
                                                    <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${o.id}" class="themvaogiohang">Thêm vào giỏ</a>
                                                </c:if>
                                                <c:if test="${sessionScope.acc.role == 1}">
                                                    <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${o.id}" class="themvaogiohang">Thêm vào giỏ</a>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <!-- -- -->

                    </div>
                    <button onclick="loadMore()" class="btn btn-loadmore">Xem thêm</button>
                </div>
                <!-- -- -- -- -->

            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                        function loadMore() {
                            var amount = document.getElementsByClassName("Sach").length;
                            $.ajax({
                                url: "/web_project/load",
                                type: "get", //send it through get method
                                data: {
                                    exist: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
        </script> 
        <script src="js/main.js"></script>
    </body>

</html>