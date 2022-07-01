/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import entity.Bill;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sonnk
 */
public class BillControl extends HttpServlet {

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
        String action = request.getParameter("action");
        if (action == null) {
            doGet_DisplayBill(request, response);
        } else if (action.equalsIgnoreCase("edit")) {
            doGet_editBill(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            doGet_deleteBill(request, response);
        }
    }

    protected void doGet_DisplayBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BillDAO billdao = new BillDAO();
        List<Bill> list = billdao.getAllBillNewest();

        request.setAttribute("listB", list);
        request.getRequestDispatcher("ManagerBill.jsp").forward(request, response);
    }

    protected void doGet_editBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BillDAO billdao = new BillDAO();

        String bid = request.getParameter("bid");
        String paymentStatus = request.getParameter("paymentStatus");
        String billStatus = request.getParameter("billStatus");

        billdao.editStatus(bid, paymentStatus, billStatus);

        List<Bill> list = billdao.getAllBillNewest();

        request.setAttribute("listB", list);
        request.getRequestDispatcher("ManagerBill.jsp").forward(request, response);
    }

    protected void doGet_deleteBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BillDAO billdao = new BillDAO();

        String bid = request.getParameter("bid");

        billdao.deleteBillById(bid);

        List<Bill> list = billdao.getAllBillNewest();

        request.setAttribute("listB", list);
        request.getRequestDispatcher("ManagerBill.jsp").forward(request, response);
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
