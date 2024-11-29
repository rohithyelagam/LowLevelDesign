package VendingMachine.State;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.Services.VendingMachine;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IdleState implements State{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        vendingMachine.setSelectedProduct(null);
        for(Map.Entry<Product, Integer> p : vendingMachine.getProducts().entrySet()){
            Product curProd = p.getKey();
            if(Objects.equals(curProd.getName(), product.getName())){
                vendingMachine.setSelectedProduct(curProd);
                System.out.println("Product Selected : "+curProd.getName());
                this.vendingMachine.changeState(new InsertCashState(vendingMachine));
                return;
            }
        }
        System.out.println("Product is unavailable!");
    }

    @Override
    public void InsertCash(List<Denomination> denominations) {
        System.out.println("Please select product first");

    }

    @Override
    public void DispenseProduct() {
        System.out.println("Please select product first");

    }

    @Override
    public void ReturnCash() {
        System.out.println("Please select product first");

    }
}
