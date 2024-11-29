package KeyValueStore.Atrributes;

public class BooleanAtr implements Attribute{

    private Boolean value;

    public BooleanAtr(Boolean value){
        this.value = value;
    }

    public String toString(){
        return (value)?"true":"false";
    }

    public static boolean isTrue(String value){
        try{
            Boolean b = Boolean.valueOf(value);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
