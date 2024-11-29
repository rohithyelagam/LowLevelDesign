package VendingMachine.Models;

import VendingMachine.Enums.CashType;

public class Denomination {
    private CashType type;
    private Double value;

    public Denomination(CashType type, Double value){
        this.type = type;
        this.value = value;
    }

    public CashType getType() {
        return type;
    }

    public void setType(CashType type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
