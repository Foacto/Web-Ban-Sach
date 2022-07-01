/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.CartDAO;
import dao.SendMail;
import dto.BillInfoSendMail;
import dto.CartDTO;
import entity.Bill;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonnk
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/pay"})
public class CheckOutController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
      
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();

        CartDAO cartdao = new CartDAO();
        BillDAO billDao = new BillDAO();
        
        List<CartDTO> list = cartdao.getCartbyUid(userId);

        double total = 0;
        
        for (CartDTO cart : list) {
            total += (cart.getItem().getProduct().getPrice() * cart.getItem().getQuantity());
        }
        
        Bill bill = billDao.insertBill(userId, total, phone, address);
        for (CartDTO cart : list) {
            billDao.insertBillDeltail(bill.getId(), cart.getItem().getProduct().getId(), cart.getItem().getProduct().getPrice()*cart.getItem().getQuantity(), cart.getItem().getQuantity());
        }
        
        SendMail sendMail = new SendMail();
        BillInfoSendMail billInfo = new BillInfoSendMail();
        billInfo.setBillId(bill.getId());
        billInfo.setTotal(bill.getTotal());
        billInfo.setDate(bill.getDate());
        billInfo.setName(u.getName());
        billInfo.setEmail(u.getEmail());
        billInfo.setAddress(address);
        billInfo.setPhoneNumber(phone);
        sendMail.sendMail(billInfo);

        
        cartdao.removeAllCartByUid(userId);
        List<CartDTO> last_list = cartdao.getCartbyUid(userId);
        request.setAttribute("cart_1", last_list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response); 
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
