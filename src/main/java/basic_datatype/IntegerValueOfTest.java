package main.java.basic_datatype;

public class IntegerValueOfTest {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("-1") - 1);
        
        // java.lang.NumberFormatException: null
        // System.out.println(Integer.valueOf(null));
        
        //  java.lang.NumberFormatException: For input string: ""
        System.out.println(Integer.valueOf(""));
        
    }
}
