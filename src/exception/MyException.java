package exception;

import date.DateFormatTest;

public class MyException {
    public static void main(String[] args) {
//         1.  java.lang.ClassCastException
        Object aString = new String("4");
        System.out.println(Integer.parseInt((String) aString));
//        System.out.println((Integer)aString);
        
//         2.  NumberFormatException: 数字格式异常。
//        System.out.println(Integer.parseInt("it"));

    
    }
}
