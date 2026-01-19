package main.java.util.scanner;

import java.util.Scanner;

public class TestScanner01_regex {
    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close(); 
    }
}

/**
 * 输出结果：
 * 1
 * 2
 * red
 * blue
 */
