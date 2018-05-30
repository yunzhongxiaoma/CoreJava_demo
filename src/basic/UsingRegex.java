package basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式
 */
public class UsingRegex {
    public static void main(String[] args) {
        String regexSample = "\\w+";
        String inputString = "123";

        Pattern pattern = Pattern.compile(regexSample);
        Matcher matcher = pattern.matcher(inputString);

        System.out.println(matcher.matches());

    }
}
