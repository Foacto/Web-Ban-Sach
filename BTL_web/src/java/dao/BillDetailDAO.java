/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import dto.BillDetailDTO;
import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonnk
 */
public class BillDetailDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<BillDetailDTO> getBillDetail(int bId) {
        List<BillDetailDTO> list = new ArrayList<>();
        try {
            String query = "SELECT pd.product_name, pd.product_image, bd.price, bd.quantity FROM `bill_detail` bd inner "
                    + "join product pd on bd.product_id = pd.product_id WHERE bd.bill_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BillDetailDTO(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }
    
    
}
