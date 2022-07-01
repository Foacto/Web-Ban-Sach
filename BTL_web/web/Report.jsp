<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Thống kê</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="quanlysanpham">
                    <div class="tieudequanly">
                        <div class="hangtieude">
                            <div class="nuadong">
                                <h2>Thống kê <b>Doanh thu</b></h2>  
                                <div class="searchBill">
                                    <div class="searchByStatus">    
                                        <form action="searchtop10report" method="post">
                                            <label>Top 10 doanh thu</label>
                                            <select name="top" class="form-select" aria-label="Default select example">
                                            <c:forEach begin="0" end="2" var="i">
                                                <c:if test="${i == 0}">
                                                    <c:set var="st" value="Tất cả danh sách" ></c:set>   
                                                </c:if>
                                                <c:if test="${i == 1}">
                                                    <c:set var="st" value="Cao nhất"></c:set>  
                                                </c:if>
                                                <c:if test="${i == 2}">
                                                    <c:set var="st" value="Thấp nhất"></c:set>  
                                                </c:if> 
                                                <option value="${i-1}" ${i-1 == statusSelected ? 'selected="selected"' : ''}>${st}</option>
                                            </c:forEach>
                                            <input type="submit" value="Tìm kiếm" class="btn">
                                        </select>
                                    </form>
                                </div>
                                <div class="searchByTime">                                  
                                    <form action="searchreportbymonth" method="post">
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
                            <th>Tổng doanh thu</th>
                            <th>Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listReport}" var="listR">
                            <tr> 
                                <td>${listR.nameProduct}</td>
                                <td>${listR.total}</td>
                                <td>${listR.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>

</html>