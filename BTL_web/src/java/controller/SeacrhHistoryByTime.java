/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.HistoryDAO;
import dto.HistoryDTO;
import entity.Bill;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "SeacrhHistoryByTime", urlPatterns = {"/seacrhhistorybymonth"})
public class SeacrhHistoryByTime extends HttpServlet {

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
        String monthS = request.getParameter("time");
        int month = Integer.parseInt(monthS);
        Date startDate = null;
        Date endDate = null;

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("acc");
        int userId = u.getId();
        
        if (month == 1) {
            Calendar cal = Calendar.getInstance();
            endDate = cal.getTime();
            cal.add(Calendar.MONTH, -1);
            startDate = cal.getTime();
        } else if (month == 2) {
            Calendar cal = Calendar.getInstance();
            endDate = cal.getTime();
            cal.add(Calendar.MONTH, -3);
            startDate = cal.getTime();
        } else if (month == 3) {
            Calendar cal = Calendar.getInstance();
            endDate = cal.getTime();
            cal.add(Calendar.MONTH, -6);
            startDate = cal.getTime();
        } else if (month == 4) {
            Calendar cal = Calendar.getInstance();
            endDate = cal.getTime();
            cal.add(Calendar.MONTH, -9);
            startDate = cal.getTime();
        } else if (month == 5) {
            Calendar cal = Calendar.getInstance();
            endDate = cal.getTime();
            cal.add(Calendar.MONTH, -12);
            startDate = cal.getTime();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        List<HistoryDTO> list = new ArrayList<>();

        HistoryDAO dao = new HistoryDAO();
        if (month == 0) {
            list = dao.getHistorybyUserID(userId);
        } else {
            String startD = dateFormat.format(startDate);
            String endD = dateFormat.format(endDate);
            list = dao.searchByTime(userId, startD, endD);
        }

        request.setAttribute("monthSelected", monthS);
        request.setAttribute("listHistory", list);
        request.getRequestDispatcher("History.jsp").forward(request, response);
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
