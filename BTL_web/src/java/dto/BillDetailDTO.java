/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author sonnk
 */
public class BillDetailDTO {
    private String productName;
    private String productImage;
    private double price;
    private int quantity;

    public BillDetailDTO() {
    }

    public BillDetailDTO(String productName, String productImage, double price, int quantity) {
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetailDTO{" + "productName=" + productName + ", productImage=" + productImage + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
}
