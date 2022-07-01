/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import dto.ReportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonnk
 */
public class ReportDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ReportDTO> getAllReportNewest() {
        List<ReportDTO> list = new ArrayList<>();
        try {
            String query = "SELECT p.product_name, sum(pd.price*pd.quantity), sum(pd.quantity) FROM `bill_detail` pd inner "
                    + "JOIN product p on pd.product_id = p.product_id group by p.product_id";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ReportDTO(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public List<ReportDTO> getTop10Report() {
        List<ReportDTO> list = new ArrayList<>();
        try {
            String query = "SELECT p.product_name, sum(pd.price*pd.quantity), sum(pd.quantity) FROM `bill_detail` pd inner "
                    + "JOIN product p on pd.product_id = p.product_id group by p.product_id order by sum(pd.price*pd.quantity) desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ReportDTO(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }
    
    public List<ReportDTO> getTop10ReportReverse() {
        List<ReportDTO> list = new ArrayList<>();
        try {
            String query = "SELECT p.product_name, sum(pd.price*pd.quantity), sum(pd.quantity) FROM `bill_detail` pd inner "
                    + "JOIN product p on pd.product_id = p.product_id group by p.product_id order by sum(pd.price*pd.quantity)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ReportDTO(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }
//    public List<ReportDTO> searchByTime(String startD, String endD) {
//        List<ReportDTO> list = new ArrayList<>();
//        try {
//            String query1 = "SELECT p.product_name, sum(pd.price*pd.quantity), sum(pd.quantity) FROM `bill_detail` pd inner "
//                    + "JOIN product p on pd.product_id = p.product_id group by p.product_id";
//            String query = "SELECT * FROM `bill` WHERE date BETWEEN ? and ? order by bill_id desc";
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, startD);
//            ps.setString(2, endD);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//        return list;
//    }
    public static void main(String[] args) {
        ReportDAO r = new ReportDAO();
        List<ReportDTO> list = r.getTop10ReportReverse();
        for (ReportDTO i : list) {
            System.out.println(i.getNameProduct() + " " + i.getTotal() + " " + i.getQuantity());
        }
    }
}
