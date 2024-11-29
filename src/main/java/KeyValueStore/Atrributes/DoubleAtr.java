package KeyValueStore.Atrributes;

public class DoubleAtr implements Attribute{

    private Double value;

    public DoubleAtr(Double value){
        this.value = value;
    }

    public String toString(){
        return String.valueOf(value);
    }

    public static boolean isTrue(String value){
        try{
            Double d = Double.valueOf(value);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
