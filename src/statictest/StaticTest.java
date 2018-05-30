package statictest;

public class StaticTest {
    static int a = 3;
    int b = 4;
    static {
        System.out.println(a);
        // 下面的是错的:Cannot make a static reference to the non-static field b
        // System.out.println(b);
    }
}
