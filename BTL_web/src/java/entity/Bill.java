/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author sonnk
 */
public class Bill {
    private int id;
    private int uid;
    private double total;
    private String date;
    private String phoneNumber;
    private String deliveryAdress;
    private int paymentStatus;
    private int bill_status;

    public Bill() {
    }

    public Bill(int id, int uid, double total, String date, String phoneNumber, String deliveryAdress, int paymentStatus, int bill_status) {
        this.id = id;
        this.uid = uid;
        this.total = total;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.deliveryAdress = deliveryAdress;
        this.paymentStatus = paymentStatus;
        this.bill_status = bill_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getBill_status() {
        return bill_status;
    }

    public void setBill_status(int bill_status) {
        this.bill_status = bill_status;
    }
    
    
    
}
