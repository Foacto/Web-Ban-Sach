/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dto.ProductionDTO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sonnk
 */
@WebServlet(name = "LoadMoreControl", urlPatterns = {"/load"})
public class LoadMoreControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String t_amount = request.getParameter("exist");
        int amount = Integer.parseInt(t_amount);
        DAO dao = new DAO();
        List<ProductionDTO> list = dao.getNext4Product(amount);
        PrintWriter out = response.getWriter();
        
        for(ProductionDTO o : list){
            out.println("<div class=\"Sach\">\n"
                    + "                                <div class=\"The\">\n"
                    + "                                    <img src=\"img/" + o.getImage() + "\" alt=\"Ảnh sách\">\n"
                    + "                                    <div class=\"Thanthe\">\n"
                    + "                                        <h4 class=\"tieudethe\"><a href=\"detail?pid=" + o.getId() + " title=\"Xem sản phẩm\">" + o.getName() + "</a></h4>\n"
                    + "                                        <p class=\"tieudethe\">" + o.getCategory_name() + "</p>\n"
                    + "                                        <div class=\"hang\">\n"
                    + "                                            <div class=\"cot\">\n"
                    + "                                                <p class=\"Giasachmua\">" + o.getPrice() + " ₫" + "</p>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"cot\">\n"
                    + "                                                <a href=\"Cart.jsp\" class=\"themvaogiohang\">Thêm vào giỏ</a>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
