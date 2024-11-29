package KeyValueStore.Atrributes;

public class IntegerAtr implements Attribute{

    private Integer value;

    public IntegerAtr(Integer value){
        this.value = value;
    }

    public String toString(){
        return String.valueOf(value);
    }

    public static boolean isTrue(String value){
        try{
            Integer i = Integer.valueOf(value);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
