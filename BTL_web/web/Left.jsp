<%-- 
    Document   : Left
    Created on : Jun 3, 2022, 11:29:27 AM
    Author     : sonnk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="cotmenu">
    <div class="The">
        <div class="Tieudetheloai">
            <p class="menuicon"></p> Thể loại</div>
        <ul class="khoidstheloai">
            <c:forEach items="${listC}" var="o">
                <li class="dstheloai" active><a href="category?cid=${o.id}">${o.name}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="motasach">
        <div class="Sachcuoi">Sách xem lần cuối</div>
        <div class="Thanthe">
            <img class="anhcuoi" src="img/${P.image}" />
            <h5 class="tieudethe">${P.name}</h5>
            <p>${P.category_name}</p>
            <p class="Giasach">${P.price}$</p>
        </div>
    </div>
</div>
