package main.java.util;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    /**
     * ^ 表示匹配字符串的开头。
     * 1 表示匹配数字 1。
     * [3456789] 表示匹配数字 3、4、5、6、7、8、9 中的任意一个。
     * \\d 表示匹配任意数字。
     * {9} 表示前面的元素重复出现 9 次。
     * $ 表示匹配字符串的结尾。
     * 综合起来，该正则表达式用于匹配以数字 1 开头，后面跟着任意数字 3、4、5、6、7、8、9，然后再跟着任意 9 个数字的字符串。这符合中国大陆手机号的格式要求，即以 1 开头，总共 11 位数字。
     */
    private static final String PHONE_NUMBER_REGEX = "^1[3456789]\\d{9}$";

    /**
     * 校验手机号是否有效
     * @param phoneNumber 手机号
     * @return true表示手机号有效，false表示手机号无效
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }
}