package VendingMachine;

import VendingMachine.Enums.CashType;
import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.Services.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        Integer capacity = 5;

        VendingMachine vendingMachine = VendingMachine.getInstance(capacity);

        Product hideAndSeek = new Product("Hide&Seek",5.0);
        Product drink = new Product("Sprite",10.0);
        Product snack = new Product("Lays",20.0);

        vendingMachine.addProduct(hideAndSeek);
        vendingMachine.addProduct(hideAndSeek);
        vendingMachine.addProduct(drink);
        vendingMachine.addProduct(drink);
        vendingMachine.addProduct(snack);
        vendingMachine.addProduct(snack);

        vendingMachine.display();

        Denomination fiveCoin = new Denomination(CashType.COIN, 5.0);
        Denomination tenNote = new Denomination(CashType.CASH, 10.0);

        List<Denomination> money = new ArrayList<>();

        money.add(fiveCoin);
        money.add(tenNote);

        // selecting product and checking its state validation
        vendingMachine.selectProduct(drink);
        vendingMachine.dispenseProduct(drink);

        // insertCash cash and checking its state validation
        vendingMachine.insertCash(money);
        vendingMachine.returnCash();

        // dispenseProduct and checking its state validation
        vendingMachine.dispenseProduct(drink);
        vendingMachine.selectProduct(drink);

        // returnCash and checking its state validation
        vendingMachine.returnCash();
        vendingMachine.insertCash(money);

        vendingMachine.display();

        vendingMachine.getCashInVendingMachine();

        vendingMachine.selectProduct(snack);
        vendingMachine.insertCash(money);

        vendingMachine.selectProduct(drink);
        vendingMachine.insertCash(money);
        vendingMachine.dispenseProduct(drink);
        vendingMachine.returnCash();

        vendingMachine.display();

        vendingMachine.selectProduct(drink);


    }
}
