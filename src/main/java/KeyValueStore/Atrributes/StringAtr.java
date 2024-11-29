package KeyValueStore.Atrributes;

public class StringAtr implements Attribute{

    private String value;

    public StringAtr(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }

    public static boolean isTrue(String value){
        if(DoubleAtr.isTrue(value) || IntegerAtr.isTrue(value) || BooleanAtr.isTrue(value))return false;
        return true;
    }

}
