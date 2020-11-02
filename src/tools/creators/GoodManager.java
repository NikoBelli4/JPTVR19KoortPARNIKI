/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Good;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class GoodManager {
        private Scanner scanner = new Scanner(System.in);

    public Good createGood() {
        Good good = new Good();
        System.out.println("~~~ Создание товара ~~~");
        System.out.print("Введите название товара: ");
        good.setName(scanner.nextLine());
        System.out.print("Введите производителя товара: ");
        good.setManufacturer(scanner.nextLine());
        System.out.print("Введите год создания товара: ");
        good.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите цену товара: ");
        good.setPrice(scanner.nextInt());
        System.out.println("Создан товар: "+good.getName());
        return good;
    }

    public void addGoodToArray(Good good, List<Good> listGoods) {
        listGoods.add(good);
    }

    public void printListGoods(List<Good> listGoods) {
        for (int i = 0; i < listGoods.size(); i++) {
            if(listGoods.get(i) != null){
                System.out.println(i+1+". " + listGoods.get(i).toString());
            }
        }   
    }
}
