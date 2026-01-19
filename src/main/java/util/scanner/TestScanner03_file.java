package main.java.util.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanner03_file {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("myNumbers"));
        while (sc.hasNextLong()) {
            long aLong = sc.nextLong();
            System.out.println(aLong);
        }
    }
}

/**
 * 输出结果：
 * 
 */
