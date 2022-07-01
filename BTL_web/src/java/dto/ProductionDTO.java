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
public class ProductionDTO {
    private int id;
    private String name;
    private String image;
    private Double price;
    private String decription;
    private String category_name;

    public ProductionDTO() {
    }

    public ProductionDTO(int id, String name, String image, Double price, String decription, String category_name) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.decription = decription;
        this.category_name = category_name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    
    
}
