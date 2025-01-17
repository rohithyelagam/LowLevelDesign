package Random;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

public class Driver {

    private Driver driver;

    public Driver(Driver driver){
        this.driver = driver;
    }

    static class customExveption extends Exception{
        public customExveption(String message){
            super(message);
        }
    }

    class Cool {
        public Integer test;
    }

    static class Test{
        public Integer cool;
        public Test(Integer integer){
            this.cool = integer;
        }
    }

    public static void testing(String... arr) throws customExveption {


        if(arr.length == 1){
            throw new customExveption("New Custom Exception");
        }

    }

    static class NewRunable implements Runnable{
        public void run(){
            System.out.println("Thread is running");
        }
    }

    static class NewThread extends Thread{
        public void start(){
            System.out.println("Cool buddy");
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new NewRunable());

        t1.start();

        Thread t2 = new NewThread();

        t2.start();

    }
}
