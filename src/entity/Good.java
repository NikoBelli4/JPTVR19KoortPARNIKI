/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Melnikov
 */
public class Good implements Serializable{
    private String name;
    private String manufacturer;
    private Integer publishedYear;
    public Integer price;

    public Good() {
    }

    public Good(String name, String manufacturer, Integer publishedYear, Integer price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" 
                + "name=" + name 
                + ", manufacturer=" + manufacturer 
                + ", publishedYear=" + publishedYear 
                + ", price=" + price
                + '}';
    }
    
    
    
}
