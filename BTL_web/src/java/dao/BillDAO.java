/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NCC
 */
public class BillDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertBillDeltail(int billId, int productId, double price, int quantity) {
        try {
            String query = "INSERT INTO `bill_detail`(`bill_id`, `product_id`, `price`, `quantity`) VALUES (?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            ps.setInt(2, productId);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public Bill insertBill(int userId, double total, String phone, String address) {
        try {
            String query = "INSERT INTO `bill`(`user_id`, `total`, `date`,`phone_number`, `delivery_address`, `payment_status`, `bill_status`) VALUES (?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();
            DateFormat dateFormatYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String vDateYMD = dateFormatYMD.format(now);
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setDouble(2, total);
            ps.setString(3, vDateYMD);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setInt(6, 0);
            ps.setInt(7, 0);

            ps.executeUpdate();
            Bill bill = getLatestBillById();
            return bill;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Bill getLatestBillById() {
        try {
            String query = "select * from bill order by bill_id desc limit 1";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                return bill;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public List<Bill> getAllBill() {
        List<Bill> list = new ArrayList<>();
        try {
            String query = "select * from bill";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public List<Bill> getAllBillNewest() {
        List<Bill> list = new ArrayList<>();
        try {
            String query = "select * from bill order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public void editStatus(String id, String paymentStatus, String billStatus) {
        try {
            String query = "UPDATE `bill` SET `payment_status`=?,`bill_status`=? WHERE bill_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, paymentStatus);
            ps.setString(2, billStatus);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBillById(String id) {
        try {
            String query = "DELETE FROM `bill` WHERE bill_id=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Bill> searchByStatus(String status) {
        List<Bill> list = new ArrayList<>();
        try {
            String query = "select * from bill where payment_status = ? order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public List<Bill> searchByTime(String startD, String endD) {
        List<Bill> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM `bill` WHERE date BETWEEN ? and ? order by bill_id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, startD);
            ps.setString(2, endD);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

    public static void main(String[] args) {
        BillDAO b = new BillDAO();

        
        Date startDate = null;
        Date endDate = null;

        Calendar cal = Calendar.getInstance();
        endDate = cal.getTime();
        cal.add(Calendar.MONTH, -1);
        startDate = cal.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        String startD = dateFormat.format(startDate);
        String endD = dateFormat.format(endDate);
        
        List<Bill> list = b.searchByTime(startD, endD);

        for (Bill i : list) {
            System.out.println(i.getId());
        }
    }
}
