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
public class User implements Serializable{
    private String login;
    private String password;
    private String role;
    private Buyer buyer;

    public User() {
    }

    public User(String login, String password, String role, Buyer buyer) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.buyer = buyer;
    }

   

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setReader(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "User{" 
                + "login=" + login 
                + ", password=" + password 
                + ", role=" + role 
                + ", buyer=" + buyer.getFirstname()
                + " " + buyer.getLastname()
                + '}';
    }
    
}
