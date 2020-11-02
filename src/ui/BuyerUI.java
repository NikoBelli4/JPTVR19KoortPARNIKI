/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Good;
import entity.History;
import entity.Buyer;
import entity.User;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;
import tools.creators.GoodManager;
import tools.creators.LibraryManager;
import tools.creators.BuyerManager;
import tools.savers.GoodSaver;
import tools.savers.HistorySaver;
import tools.savers.BuyerSaver;
import tools.savers.UserSaver;

/**
 *
 * @author pupil
 */
public class BuyerUI {
    private GoodManager goodManager = new GoodManager();
    private BuyerManager readerManager = new BuyerManager();
    private LibraryManager libraryManager = new LibraryManager();
    private GoodSaver goodSaver = new GoodSaver();
    private BuyerSaver buyerSaver = new BuyerSaver();
    private HistorySaver historySaver = new HistorySaver();
    private SecureManager secureManager = new SecureManager();
    private UserSaver userSaver = new UserSaver();
    
    public void getBuyerUI(List<Buyer> listBuyers,List<User> listUsers, List<Good> listGoods, List<History> listHistories){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Список товаров");
            System.out.println("2. Купить товар");
            //System.out.println("3. Вернуть товар обратно");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("~~~ конец программы ~~~");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("~~~ Список товаров ~~~");
                    goodManager.printListGoods(listGoods);
                    break;
                case "2":
                    System.out.println("~~~ Купить товар ~~~");
                    History history = libraryManager.takeOnGood(listGoods, listBuyers);
                    libraryManager.addHistoryToArray(history,listHistories);
                    historySaver.saveHistories(listHistories);
                    break;
                //case "3":
                //    System.out.println("~~~ Вернуть товар обратно ~~~");
                //    libraryManager = new LibraryManager();
                //    libraryManager.returnGood(listHistories);
                //    historySaver = new HistorySaver();
                //    historySaver.saveHistories(listHistories);
                //    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
