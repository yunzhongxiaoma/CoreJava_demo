package main.java.date;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
//        testSystemStaticMethod();
        System.out.println(new Date());
    }
    
    public static void testSystemStaticMethod() {
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }
}
