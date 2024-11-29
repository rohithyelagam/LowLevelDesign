package VendingMachine.State;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.Services.VendingMachine;

import java.util.List;

public class ReturnChangeState implements State {

    private VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change!");
    }

    @Override
    public void InsertCash(List<Denomination> denominations) {
        System.out.println("Please collect the change!");
    }

    @Override
    public void DispenseProduct() {
        System.out.println("Please collect the change!");
    }

    @Override
    public void ReturnCash() {
        if(this.vendingMachine.getBalance() > 0.0){
            System.out.println("Balance collected : "+this.vendingMachine.getBalance());
        }
        this.vendingMachine.changeState(new IdleState(vendingMachine));
    }
}
