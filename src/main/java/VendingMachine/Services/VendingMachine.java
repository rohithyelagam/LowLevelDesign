package VendingMachine.Services;

import VendingMachine.Models.Denomination;
import VendingMachine.Models.Product;
import VendingMachine.State.IdleState;
import VendingMachine.State.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private State state;
    private Integer capacity;
    private Integer productsSize;
    private Map<Product, Integer> products;
    private Product selectedProduct;
    private Double balance;
    private static VendingMachine vendingMachine;
    private Double cashDesk;

    private VendingMachine(Integer capacity){
        this.state = new IdleState(this);
        this.capacity = capacity;
        this.productsSize = 0;
        this.balance = 0.0;
        this.cashDesk = 0.0;
        this.products = new HashMap<>();
    }

    public static synchronized VendingMachine getInstance(Integer capacity){
        if(vendingMachine==null){
            vendingMachine = new VendingMachine(capacity);
        }
        return vendingMachine;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void selectProduct(Product product){
        this.state.selectProduct(product);
    }

    public void insertCash(List<Denomination> denominations){
        this.state.InsertCash(denominations);
    }

    public void dispenseProduct(Product product){
        this.state.DispenseProduct();
    }

    public void returnCash(){
        this.state.ReturnCash();
    }

    public boolean addProduct(Product product){
        if(this.productsSize == capacity){
            System.out.println("vending Machine is Full");
            return false;
        }
        System.out.println("Added product : "+product.getName());
        Integer count = products.getOrDefault(product,0);
        products.put(product,count+1);
        this.productsSize++;
        return true;
    }

    public void display(){
        System.out.println("Displaying the available products");
        for (Map.Entry<Product, Integer> m : products.entrySet()){
            System.out.println("Product "+m.getKey().getName()+" of quantity : "+m.getValue());
        }
        System.out.println("Cash in Vending Machine : "+this.cashDesk);
    }

    public void getCashInVendingMachine(){
        System.out.println("Cash from Vending Machine collected : "+cashDesk);
        this.cashDesk = 0.0;
    }

    public static Double calculateCash(List<Denomination> denominations){
        Double cash = 0.0;
        for(Denomination d : denominations){
            cash += d.getValue();
        }
        return cash;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getProductsSize() {
        return productsSize;
    }

    public void setProductsSize(Integer productsSize) {
        this.productsSize = productsSize;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public static void setVendingMachine(VendingMachine vendingMachine) {
        VendingMachine.vendingMachine = vendingMachine;
    }

    public Double getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(Double cashDesk) {
        this.cashDesk = cashDesk;
    }
}
