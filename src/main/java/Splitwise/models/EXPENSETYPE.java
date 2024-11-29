package Splitwise.models;

public enum EXPENSETYPE {
    EQUAL, EXACT, PERCENT;

    public static EXPENSETYPE getType(String s){
        switch (s){
            case "EQUAL":
                return EQUAL;
            case "EXACT":
                return EXACT;
            default:
                return PERCENT;
        }
    }
}
