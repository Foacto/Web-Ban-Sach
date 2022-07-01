/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import dto.ProductionDTO;
import entity.Category;
import entity.Product;
import entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Response;

/**
 *
 * @author NCC
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllP() {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select * from product";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<ProductionDTO> getAllProduct() {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p inner join category c ON p.category_id = c.category_id";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        try {
            String query = "select * from users where role = 0";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Users a = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductionDTO> getTop8Product() {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p inner join category c ON p.category_id = c.category_id order by p.product_id limit 8";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductionDTO> getNext4Product(int amount) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p inner join category c ON p.category_id = c.category_id limit ?, 4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String query = "select * from category";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category a = new Category(rs.getInt(1), rs.getString(2));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductionDTO getProductbyId(int id) {
        String query = "select * from product p inner join category c "
                + "ON p.category_id = c.category_id where product_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public ProductionDTO getNewstProduct() {
        try {
            String query = "select * from product p inner join category c "
                    + "ON p.category_id = c.category_id ORDER BY product_id DESC LIMIT 1";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ProductionDTO> getProductByCID(String cid) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p  inner join category c ON p.category_id = c.category_id where c.category_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductionDTO getProductByID(String id) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p inner join category c ON p.category_id = c.category_id where p.product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ProductionDTO> searchByName(String txtSearch) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p inner join category c ON p.category_id = c.category_id where p.product_name like ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Users login(String user, String pass) {
        try {
            String query = "SELECT * FROM `users` WHERE email = ? and pass = ? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Users checkAccountExist(String email) {
        try {
            String query = "SELECT * FROM `users` WHERE email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void signup(String name, String user, String password) {
        try {
            String query = "INSERT INTO `users`(`name`, `email`, `pass`, `role`) "
                    + "VALUES (?, ?, ?, 0)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, user);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<ProductionDTO> getProductBySellID(int id) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p  inner join category c ON p.category_id = c.category_id where p.sell_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProductionDTO> pagingProduct(int id, int index) {
        List<ProductionDTO> list = new ArrayList<>();
        try {
            String query = "select * from product p  inner join category c ON p.category_id = c.category_id where p.sell_id = ? limit ?,3";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductionDTO a = new ProductionDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(9));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(String pid) {
        try {
            String query = "DELETE FROM `product` WHERE product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(String uid) {
        try {
            String query = "DELETE FROM `users` WHERE user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String category, String name, String image, String price, String description, int sId) {
        try {
            String query = "INSERT INTO `product`(`category_id`, `product_name`, `product_image`, "
                    + "`product_price`, `product_description`, `sell_id`) VALUES (?,?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, category);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, description);
            ps.setInt(6, sId);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String category, String name, String image, String price, String description, String pid) {
        try {
            String query = "UPDATE `product` SET `category_id`=?,`product_name`=?,`product_image`=?,"
                    + "`product_price`=?,`product_description`=? WHERE product_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, category);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, description);
            ps.setString(6, pid);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getTotalProductByCellID(int id) {
        try {
            String query = "Select count(*) from product where sell_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public Users getUserById(String id) {
        try {
            String query = "SELECT * FROM `users` WHERE user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editUser(String id, String name, String email, String pass, int role) {
        try {
            String query = "UPDATE `users` SET `name`=?,`email`=?,`pass`=?,"
                    + "`role`=? WHERE user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setInt(4, role);
            ps.setString(5, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Users> list = dao.getAllUser();

//        for (Users i : list) {
//            System.out.println(i.getName());
//        }
//        int s = dao.getTotalProductByCellID(10);
//        System.out.println(s);
//
//        List<Product> a = dao.getAllP();
//        for (Product i : a) {
//            System.out.println(i.getName());
//        }
        List<ProductionDTO> list_product = dao.getTop8Product();
        for(ProductionDTO i : list_product){
            System.out.println(i.getName());
        }
    }
}
