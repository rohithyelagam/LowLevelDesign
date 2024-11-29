package VendingMachine.State;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.Services.VendingMachine;

import java.util.List;

import static VendingMachine.Services.VendingMachine.calculateCash;

public class InsertCashState implements State {

    private VendingMachine vendingMachine;

    public InsertCashState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please Insert Cash!");
    }

    @Override
    public void InsertCash(List<Denomination> denominations) {
        this.vendingMachine.setBalance(0.0);
        Double cash = calculateCash(denominations);
        if(cash < this.vendingMachine.getSelectedProduct().getPrice()){
            System.out.println("Insufficient Cash!");
            this.vendingMachine.changeState(new IdleState(vendingMachine));
            return;
        }
        this.vendingMachine.setCashDesk(this.vendingMachine.getCashDesk()+this.vendingMachine.getSelectedProduct().getPrice());
        this.vendingMachine.setBalance(cash - this.vendingMachine.getSelectedProduct().getPrice());
        System.out.println("Cash inserted : "+cash);
        // need to check the possibility of balance to be returned.
        this.vendingMachine.changeState(new DispenseState(vendingMachine));
    }

    @Override
    public void DispenseProduct() {
        System.out.println("Please Insert Cash!");
    }

    @Override
    public void ReturnCash() {
        System.out.println("Please Insert Cash!");
    }
}
