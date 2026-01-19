package main.java.util.scanner;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class TestScanner02_regex {
    public static void main(String[] args) {
//        String input = "1 , 2 fish red fish blue fish";
        String input = "1 , 2 fish red fish blue fish";
//        String input = "1 , 2 fish red fish blue fish";
        Scanner s = new Scanner(input);
        s.findInLine("(\\d+) , (\\d+) fish (\\w+) fish (\\w+)");
        MatchResult result = s.match();
        for (int i=1; i<=result.groupCount(); i++)
            System.out.println(result.group(i));
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
