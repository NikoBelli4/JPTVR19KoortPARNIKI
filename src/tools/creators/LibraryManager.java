/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Good;
import entity.History;
import entity.Buyer;
import entity.User;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import jptvr19koortparniki.App;

/**
 *
 * @author pupil
 */
public class LibraryManager {
    private Scanner scanner = new Scanner(System.in);
    private BuyerManager buyerManager = new BuyerManager();
    private GoodManager goodManager = new GoodManager();

    public History takeOnGood(List<Good> listGoods, List<Buyer> listBuyers) {
        History history = new History();
        User loggedInUser = App.loginedUser;
        Buyer buyer = null;
        if("BUYER".equals(loggedInUser.getRole())){
            buyer = loggedInUser.getBuyer();
        }else if("MANAGER".equals(loggedInUser.getRole())){
            System.out.println("~~~ Список покупателей ~~~");
            buyerManager.printListBuyers(listBuyers);
            System.out.print("Выберите номер покупателя: ");
            int buyerNumber = scanner.nextInt();
            scanner.nextLine();
            buyer = listBuyers.get(buyerNumber-1);
        }
        history.setBuyer(buyer);
        goodManager.printListGoods(listGoods);
        System.out.print("Выберите номер товара: ");
        int goodNumber = scanner.nextInt();
        scanner.nextLine();
        Good good = listGoods.get(goodNumber-1);
        if(buyer.wallet >=  good.price){
            System.out.println("Оплата прошла");
            buyer.wallet -= good.price;
            history.setGood(good);
            Calendar calendar = new GregorianCalendar();
            history.setGiveOutDate(calendar.getTime());
            this.printHistory(history);
        }else if(buyer.wallet < good.price){
            System.out.println("Вам не хватает денег на этот товар.");
        }
        return history;
    }

    public void returnGood(List<History> listHistories) {
        System.out.println("~~~ Список проданных товаров ~~~");
        for (int i = 0; i < listHistories.size(); i++) {
            if("MANAGER".equals(App.loginedUser.getRole())){
                if(listHistories.get(i) != null && listHistories.get(i).getReturnDate() == null){
                    System.out.printf("%d. Товар \"%s\" продали %s %s%n" 
                            ,i+1
                            ,listHistories.get(i).getGood().getName()
                            ,listHistories.get(i).getBuyer().getFirstname()
                            ,listHistories.get(i).getBuyer().getLastname()
                    );
                }
            }else if("BUYER".equals(App.loginedUser.getRole())){
                if(listHistories.get(i) != null 
                        && listHistories.get(i).getBuyer().equals(App.loginedUser.getBuyer())
                        && listHistories.get(i).getReturnDate() == null){
                    System.out.printf("%d. Товар \"%s\" продали %s %s%n" 
                            ,i+1
                            ,listHistories.get(i).getGood().getName()
                            ,listHistories.get(i).getBuyer().getFirstname()
                            ,listHistories.get(i).getBuyer().getLastname()
                    );
                }
            }
        }
        System.out.print("Выберите номер возвращаемого товара: ");
        int historyNumber = scanner.nextInt();
        scanner.nextLine();
        Calendar calendar = new GregorianCalendar();
        listHistories.get(historyNumber-1).setReturnDate(calendar.getTime());
    }

    public void addHistoryToArray(History history, List<History> listHistories) {
        listHistories.add(history);
    }
    
    private void printHistory(History history) {
        System.out.printf("Товар \"%s\" продан %s %s%n"
                ,history.getGood().getName()
                ,history.getBuyer().getFirstname()
                ,history.getBuyer().getLastname()
        );
    }

    public void printListBuyGoods(List<History> listHistories) {
        for (int i = 0; i < listHistories.size(); i++) {
            if(listHistories.get(i) != null && listHistories.get(i).getReturnDate()==null){
                System.out.printf("%d. Товар \"%s\" продали %s %s%n" 
                        ,i+1
                        ,listHistories.get(i).getGood().getName()
                        ,listHistories.get(i).getBuyer().getFirstname()
                        ,listHistories.get(i).getBuyer().getLastname()
                );
            }
        }
    }


    
}
