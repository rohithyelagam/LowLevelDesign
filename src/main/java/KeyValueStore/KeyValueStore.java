package KeyValueStore;

import KeyValueStore.Atrributes.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static KeyValueStore.Atrributes.AttributeType.*;

public class KeyValueStore {

    private static KeyValueStore keyValueStore;
    private Map<String,Map<String, Attribute>> db;
    private Map<String,AttributeType> keySignature;

    private KeyValueStore(){
        db = new HashMap<>();
        keySignature = new HashMap<>();
    }

    public static synchronized KeyValueStore getInstance(){
        if(keyValueStore==null){
            keyValueStore = new KeyValueStore();
        }
        return keyValueStore;
    }

    public Map<String, Attribute> get(String key){
        return db.get(key);
    }

    public List<String> search(String attributeKey, String attributeValue){

        List<String> keys = new ArrayList<>();

        for(Map.Entry<String,Map<String, Attribute>> m : db.entrySet()){
            for(Map.Entry<String, Attribute> attr : m.getValue().entrySet()){
                if(attr.getKey().equals(attributeKey) && attr.getValue().toString().equals(attributeValue)){
                    keys.add(m.getKey());
                    break;
                }
            }
        }
        return keys;
    }

    public synchronized void put(String key, List<Pair<String, String>> valueList) throws Exception{

        Map<String,Attribute> values = new HashMap<>();

        for(Pair<String, String> p : valueList){
            String attrKey = p.getKey();
            String attrVal = p.getValue();
            AttributeType currType = getType(attrVal).getValue();

            if(keySignature.get(attrKey)!=null && !keySignature.get(attrKey).equals(currType)){
                throw new Exception("Data Type Error");
            }
            keySignature.put(attrKey, currType);

            switch (currType){
                case DOUBLE -> values.put(attrKey, new DoubleAtr(Double.valueOf(attrVal)));
                case BOOLEAN -> values.put(attrKey, new BooleanAtr(Boolean.valueOf(attrVal)));
                case INTEGER -> values.put(attrKey, new IntegerAtr(Integer.valueOf(attrVal)));
                case STRING -> values.put(attrKey, new StringAtr(attrVal));
            }
        }

        db.put(key, values);
    }

    public synchronized void delete(String key){
        if(db.get(key)!=null){
            db.remove(key);
        }
    }

    public List<String> keys(){
        List<String> keys = new ArrayList<>();
        for(Map.Entry<String,Map<String, Attribute>> m : db.entrySet()){
            keys.add(m.getKey());
        }
        return keys;
    }

    public Pair<String, AttributeType> getType(String attrVal){
        try{
            Integer i = Integer.valueOf(attrVal);
            return Pair.of(attrVal, INTEGER);
        }catch (Exception e){
        }

        try{
            Double d = Double.valueOf(attrVal);
            return Pair.of(attrVal, DOUBLE);
        }catch (Exception e){
        }
        if(attrVal.equals("true") || attrVal.equals("false")){
            return Pair.of(attrVal, BOOLEAN);
        }

        return Pair.of(attrVal, STRING);
    }

}
