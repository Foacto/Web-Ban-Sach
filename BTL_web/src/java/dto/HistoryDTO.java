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
public class HistoryDTO {
    private int billId;
    private double total;
    private String date;
    private int paymentStatus;
    private int billStatus;
    public HistoryDTO() {
    }

    public HistoryDTO(int billId, double total, String date, int paymentStatus, int billStatus) {
        this.billId = billId;
        this.total = total;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.billStatus = billStatus;
    }

    

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    
   

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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

    @Override
    public String toString() {
        return "HistoryDTO{" + "billId=" + billId + ", total=" + total + ", date=" + date + ", paymentStatus=" + paymentStatus + ", billStatus=" + billStatus + '}';
    }

   
    
}
