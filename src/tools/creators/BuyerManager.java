/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Buyer;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BuyerManager {
    private Scanner scanner = new Scanner(System.in);
    public Buyer createBuyer() {
        Buyer buyer = new Buyer();
        System.out.println("~~~ Регистрация нового пользователя ~~~");
        System.out.print("Введите имя: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        buyer.setPhone(scanner.nextLine());
        System.out.println("Введите кол-во денег на кошельке");
        buyer.setWallet(scanner.nextInt());
        this.printBuyer(buyer);
        return buyer;
    }

    public void addBuyerToArray(Buyer buyer, List<Buyer> listBuyers) {
        listBuyers.add(buyer);
    }

    public void printBuyer(Buyer buyer) {
        System.out.println("Имя читателя: "
                +buyer.getFirstname()
                +" "
                + buyer.getLastname()
        );
    }
    
    public void addMoney(Buyer buyer, Integer setWallet) {
        Integer tempMoney;
        System.out.println("Сколько денег вы хотите добавить в кошелек?");
        tempMoney = scanner.nextInt();
        scanner.nextLine();
        buyer.wallet = setWallet + tempMoney;
    }

    public void printListBuyers(List<Buyer> listBuyers) {
        for (int i = 0; i < listBuyers.size(); i++) {
            if(listBuyers.get(i) != null){
                System.out.println(i+1+". " + listBuyers.get(i).toString());
            }
        }
    }


}
