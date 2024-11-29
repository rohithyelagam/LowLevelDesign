package VendingMachine.State;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.Services.VendingMachine;

import java.util.List;

public class DispenseState implements State {

    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the product!");
    }

    @Override
    public void InsertCash(List<Denomination> denominations) {
        System.out.println("Please collect the product!");
    }

    @Override
    public void DispenseProduct() {
        Product product = this.vendingMachine.getSelectedProduct();
        Integer productQuant = this.vendingMachine.getProducts().get(product);
        System.out.println("Product Dispensed : " + product.getName());
        this.vendingMachine.setProductsSize(this.vendingMachine.getProductsSize()-1);
        if(productQuant==1){
            this.vendingMachine.getProducts().remove(product);
        }else{
            this.vendingMachine.getProducts().put(product,productQuant-1);
        }
        this.vendingMachine.changeState(new ReturnChangeState(vendingMachine));
    }

    @Override
    public void ReturnCash() {
        System.out.println("Please collect the product!");
    }
}
