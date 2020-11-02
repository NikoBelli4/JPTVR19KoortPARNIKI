/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19koortparniki;

import tools.savers.HistorySaver;
import tools.creators.LibraryManager;
import tools.savers.GoodSaver;
import tools.creators.BuyerManager;
import entity.Good;
import entity.History;
import entity.Buyer;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;
import tools.creators.GoodManager;
import tools.savers.BuyerSaver;
import tools.savers.UserSaver;
import ui.ManagerUI;
import ui.BuyerUI;

/**
 *
 * @author pupil
 */
public class App {
    private List<Good> listGoods = new ArrayList<>();
    private List<Buyer> listBuyers = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();

    private GoodSaver goodSaver = new GoodSaver();
    private BuyerSaver buyerSaver = new BuyerSaver();
    private HistorySaver historySaver = new HistorySaver();
    private UserSaver userSaver = new UserSaver();

    private SecureManager secureManager = new SecureManager();
    
    public static User loginedUser;
    
    public App() {
        listGoods = goodSaver.loadGoods();
        listBuyers = buyerSaver.loadBuyers();
        listHistories = historySaver.loadHistories();
        listUsers = userSaver.loadUsers();
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("~~~ Магазин парников ~~~");
        this.loginedUser = secureManager.checkTask(listUsers,listBuyers);
        if(SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI(listBuyers, listUsers, listGoods, listHistories);
        }else if(SecureManager.role.BUYER.toString().equals(this.loginedUser.getRole())){
            BuyerUI buyerUI = new BuyerUI();
            buyerUI.getBuyerUI(listBuyers, listUsers, listGoods, listHistories);
        }
    }
}
