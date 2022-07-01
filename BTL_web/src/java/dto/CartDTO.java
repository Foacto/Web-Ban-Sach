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
public class CartDTO {

    private int id;
    private int user_id;
    private ItemDTO item;

    public CartDTO() {
    }

    public CartDTO(int id, int user_id, ItemDTO item) {
        this.id = id;
        this.user_id = user_id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

}
