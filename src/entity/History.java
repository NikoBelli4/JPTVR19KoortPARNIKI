/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pupil
 */
public class History implements Serializable{
    private Good good;
    private Buyer buyer;
    private Date giveOutDate;
    private Date returnDate;

    public History() {
    }

    public History(Good good, Buyer buyer, Date giveOutDate, Date returnDate) {
        this.good = good;
        this.buyer = buyer;
        this.giveOutDate = giveOutDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getGiveOutDate() {
        return giveOutDate;
    }

    public void setGiveOutDate(Date giveOutDate) {
        this.giveOutDate = giveOutDate;
    }

    @Override
    public String toString() {
        return "History{" 
                + "good=" + good.getName()
                + ", buyer=" + buyer.getLastname()
                + ", giveOutDate=" + giveOutDate
                + ", returnDate=" + returnDate
                + '}';
    }
    
}
