package Random;

import java.io.Serializable;

public class Rohith implements Serializable {
    private static final Long serialVersionUID = 2L;

    private String name;
    private String age;

    public Rohith(String name, String age){
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println(name+" "+age);
    }
}
