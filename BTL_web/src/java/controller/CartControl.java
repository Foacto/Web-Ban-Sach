/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.CartDAO;
import dao.DAO;
import dto.CartDTO;
import dto.ItemDTO;
import dto.ProductionDTO;
import entity.Users;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonnk
 */
public class CartControl extends HttpServlet {

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            doGet_DisplayCart(request, response);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                doGet_Buy(request, response);
            } else if (action.equalsIgnoreCase("remove")) {
                doGet_Remove(request, response);
            } else if (action.equalsIgnoreCase("sub")) {
                subCart(request, response);
            } 
            else if (action.equalsIgnoreCase("checkout")) {
                checkOut(request, response);
            }
        }
    }

    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        CartDAO cartdao = new CartDAO();

        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();
        List<CartDTO> last_list = cartdao.getCartbyUid(userId);
        request.setAttribute("cart_1", last_list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();
        String productId = request.getParameter("id");

        CartDAO cartdao = new CartDAO();
        cartdao.removeCartByPidandUid(userId, Integer.parseInt(productId));

        List<CartDTO> last_list = cartdao.getCartbyUid(userId);
        request.setAttribute("cart_1", last_list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO dao = new DAO();
        HttpSession session = request.getSession();

        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();
        String productId = request.getParameter("id");

        ProductionDTO p = dao.getProductByID(productId);

        CartDAO cartdao = new CartDAO();
        List<CartDTO> list = cartdao.getCartbyUid(userId);

        if (list.size() < 1) {
            ItemDTO item = new ItemDTO(p, 1);
            cartdao.insertCart(userId, item);
        } else {
            boolean tmp = false;
            for (CartDTO i : list) {
                if (i.getItem().getProduct().getId() == Integer.parseInt(request.getParameter("id"))) {
                    tmp = true;
                    break;
                }
            }
            if (tmp == true) {
                CartDTO c = cartdao.getCartbyPidAndUid(userId, Integer.parseInt(productId));
                int quantity = c.getItem().getQuantity() + 1;
                cartdao.updateQuantityCartbyPidandUid(userId, Integer.parseInt(productId), quantity);
            } else {
                ItemDTO item = new ItemDTO(p, 1);
                cartdao.insertCart(userId, item);
            }
        }
        List<CartDTO> last_list = cartdao.getCartbyUid(userId);
        request.setAttribute("cart_1", last_list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    protected void subCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();
        String productId = request.getParameter("id");

        ProductionDTO p = dao.getProductByID(productId);

        CartDAO cartdao = new CartDAO();
        List<CartDTO> list = cartdao.getCartbyUid(userId);

        CartDTO c = cartdao.getCartbyPidAndUid(userId, Integer.parseInt(productId));
        int quantity = c.getItem().getQuantity() - 1;
        cartdao.updateQuantityCartbyPidandUid(userId, Integer.parseInt(productId), quantity);

        List<CartDTO> last_list = cartdao.getCartbyUid(userId);
        request.setAttribute("cart_1", last_list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);

    }

    protected void checkOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("acc");
        request.setAttribute("u", u);
        request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        DAO dao = new DAO();
//        List<Product> list = dao.getAllP();
//        Cookie[] arr = request.getCookies();
//        String txt="";
//        if(arr != null){
//            for(Cookie c:arr){
//                if(c.getName().equals("cart")){
//                    txt += c.getValue();
//                }
//            }
//        }
//        Cart cart = new Cart(txt, list);
//        List<Item> listI = cart.getItems();
//        int n = 0;
//        if(listI == null){
//            n = 1;
//        }
//        request.setAttribute("size", n);
//        request.setAttribute("data", list);
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
