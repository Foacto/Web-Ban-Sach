/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import dto.HistoryDTO;
import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sonnk
 */
public class HistoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<HistoryDTO> getHistorybyUserID(int uid) {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            String query = "select bill_id, total, date, payment_status, bill_status from bill where user_id = ? order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HistoryDTO(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public List<HistoryDTO> searchByStatus(int uId, String status) {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            String query = "select bill_id, total, date, payment_status, bill_status from bill where user_id = ? and payment_status = ? order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uId);
            ps.setString(2, status);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HistoryDTO(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public List<HistoryDTO> searchByTime(int uId, String startD, String endD) {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            String query = "select bill_id, total, date, payment_status, bill_status from bill where user_id = ? and date BETWEEN ? and ? order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uId);
            ps.setString(2, startD);
            ps.setString(3, endD);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HistoryDTO(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public static void main(String[] args) {
        HistoryDAO h = new HistoryDAO();

        String s = "2022-06-02 08:46:12";
        String e = "2022-06-19 12:46:12";
 
        
        List<HistoryDTO> list = h.searchByTime(16, s, e);
        for(HistoryDTO i : list){
            System.out.println(i);
        }
    }
}
