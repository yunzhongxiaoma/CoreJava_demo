package loop;

public class TestFor {
    /**测试花括号内{}的i是否会影响（）的i
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
//            i = i+100; // 0 100 下一次
            System.out.println(i);
            System.out.println("下一次");
        }
    }
}
