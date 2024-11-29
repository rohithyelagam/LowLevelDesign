package VendingMachine.State;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;

import java.util.List;

public interface State {
    public void selectProduct(Product product);
    public void InsertCash(List<Denomination> denominations);
    public void DispenseProduct();
    public void ReturnCash();
}
