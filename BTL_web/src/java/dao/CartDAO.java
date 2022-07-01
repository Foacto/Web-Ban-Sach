/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import dto.CartDTO;
import dto.ItemDTO;
import dto.ProductionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonnk
 */
public class CartDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertCart(int userId, ItemDTO item) {
        try {
            String query = "INSERT INTO `cart`(`user_id`, `product_id`, `quantity`) VALUES (?, ?, ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, item.getProduct().getId());
            ps.setInt(3, item.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public List<CartDTO> getCartbyUid(int uid) {
        List<CartDTO> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM `cart` WHERE user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                DAO dao = new DAO();
                ProductionDTO p = dao.getProductbyId(rs.getInt(3));
                ItemDTO i = new ItemDTO(p, rs.getInt(4));
                list.add(new CartDTO(rs.getInt(1), rs.getInt(2), i));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CartDTO getCartbyPidAndUid(int uid, int pid) {
        try {
            String query = "SELECT * FROM `cart` WHERE user_id = ? and product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            ps.setInt(2, pid);
            rs = ps.executeQuery();
            if (rs.next()) {
                DAO dao = new DAO();
                ProductionDTO p = dao.getProductbyId(rs.getInt(3));
                ItemDTO i = new ItemDTO(p, rs.getInt(4));

                return new CartDTO(rs.getInt(1), rs.getInt(2), i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateQuantityCartbyPidandUid(int uid, int pid, int quantity) {
        try {
            String query = "UPDATE `cart` SET `quantity`= ? WHERE user_id = ? and product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, uid);
            ps.setInt(3, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void removeCartByPidandUid(int uid, int pid){
        try {
            String query = "DELETE FROM `cart` WHERE user_id = ? and product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            ps.setInt(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void removeAllCartByUid(int uid){
        try {
            String query = "DELETE FROM `cart` WHERE user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
//        List<CartDTO> list = a.getCartbyPidAndUid(10, 5);
//        for(CartDTO i : list){
//            System.out.println(i.getItem().getProduct().getId());
//        }
    }
}
