/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Product;

/**
 *
 * @author NCC
 */
public class ItemDTO {

    private ProductionDTO product;
    private int quantity;

    public ItemDTO(ProductionDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ItemDTO() {
    }

    public ProductionDTO getProduct() {
        return product;
    }

    public void setProduct(ProductionDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
