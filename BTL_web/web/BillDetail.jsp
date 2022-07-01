<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý đơn hàng</title>
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
                                <h2>Hóa đơn <b>Chi tiêt</b></h2>
                                <div class="searchBill">
                                    <div class="searchByStatus">    
                                        <form action="searchbillbystatus" method="post">
                                            <label>Trạng thái thanh toán</label>
                                            <select name="status" class="form-select" aria-label="Default select example">
                                            <c:forEach begin="0" end="2" var="i">
                                                <c:if test="${i == 0}">
                                                    <c:set var="st" value="Tất cả danh sách" ></c:set>   
                                                </c:if>
                                                <c:if test="${i == 1}">
                                                    <c:set var="st" value="Chưa thanh toán"></c:set>  
                                                </c:if>
                                                <c:if test="${i == 2}">
                                                    <c:set var="st" value="Đã thanh toán"></c:set>  
                                                </c:if>    
                                                <option value="${i-1}" ${i-1 == statusSelected ? 'selected="selected"' : ''}>${st}</option>
                                            </c:forEach>
                                            <input type="submit" value="Tìm kiếm" class="btn">
                                        </select>
                                    </form>
                                </div>
                                <div class="searchByTime">                                  
                                    <form action="searchbillbymonth" method="post">
                                        <label>Số tháng gần nhất  </label>
                                        <select name="time" class="form-select" aria-label="Default select example">
                                            <c:forEach begin="0" end="5" var="i">
                                                <c:if test="${i == 0}">
                                                    <c:set var="month" value="Tất cả danh sách" ></c:set>   
                                                </c:if>
                                                <c:if test="${i == 1}">
                                                    <c:set var="month" value="1 Tháng"></c:set>  
                                                </c:if>
                                                <c:if test="${i == 2}">
                                                    <c:set var="month" value="3 Tháng"></c:set>  
                                                </c:if>
                                                <c:if test="${i == 3}">
                                                    <c:set var="month" value="6 Tháng"></c:set>  
                                                </c:if>
                                                <c:if test="${i == 4}">
                                                    <c:set var="month" value="9 Tháng"></c:set>   
                                                </c:if> 
                                                <c:if test="${i == 5}">
                                                    <c:set var="month" value="12 Tháng"></c:set>   
                                                </c:if> 
                                                <option value="${i}" ${i == monthSelected ? 'selected="selected"' : ''}>${month}</option>
                                            </c:forEach>
                                            <input type="submit" value="Tìm kiếm" class="btn">
                                        </select>
                                    </form> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="bangsanpham">
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Hình ảnh</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listBillDetail}" var="listBD">
                            <c:set var="status"></c:set> 
                            <c:set var="status1"></c:set> 
                            <c:set var="t"></c:set> 
                            <c:set var="t1"></c:set>
                                <tr> 
                                    <td>${listBD.productName}</td>
                                <td>
                                    <img src="img/${listBD.productImage}">
                                </td>
                                <td>${listBD.price}</td>
                                <td>${listBD.quantity}</td>

                                <td>
                                    <a href="${pageContext.request.contextPath}/bill?action=edit&bid=${o.id}&paymentStatus=${t}&billStatus=${t1}" class="nut chinhsua" title="">Chỉnh sửa</a>
                                    <a href="${pageContext.request.contextPath}/bill?action=delete&bid=${o.id}" class="nut nutxoa" title="">Xóa</a>
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
        <!-- Thêm sản phẩm HTML -->

        <div id="themsanpham" class="thethongbao ghide">
            <a href="#" class="vienngoai"></a>
            <div class="noidungthe">
                <form action="add" method="post">
                    <div class="tieudethe">
                        <h4 class="tieudecon">Thêm sản phẩm</h4>
                        <a href="#" class="nutdong"><button type="button">&times;</button></a>
                    </div>
                    <div class="thanthe">
                        <div class="dongthuoctinh">
                            <label>Tên</label>
                            <input name="name" type="text" class="onhapdulieu" required>
                        </div>
                        <div class="dongthuoctinh">
                            <label>Ảnh</label>
                            <input name="image" type="text" class="onhapdulieu" required>
                        </div>
                        <div class="dongthuoctinh">
                            <label>Giá</label>
                            <input name="price" type="text" class="onhapdulieu" required>
                        </div>
                        <div class="dongthuoctinh">
                            <label>Mô tả</label>
                            <textarea name="mota" class="onhapdulieu" required></textarea>
                        </div>
                        <div class="dongthuoctinh">
                            <label>Thể loại</label>
                            <select name="theloaisach" class="chontheloai">
                                <c:forEach items="${listC}" var="o">
                                    <option value="${o.id}">${o.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="chanthe">
                        <a href="#"><input type="button" class="nut nuthuy" value="Hủy"></a>
                        <input type="submit" class="nut nutthem" value="Thêm">
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>

        <script src="js/manager.js" type="text/javascript"></script>
        <script>
        </script>
    </body>

</html>