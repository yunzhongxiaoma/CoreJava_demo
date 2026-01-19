package main.java.date;

import java.util.Calendar;
import java.util.Date;

public class TestTimeStampEffici {
    private static long _TEN_THOUSAND = 10000;
    /**
     * <pre>
     * 执行结果：
     *  133         System.currentTimeMillis();
     *  2372        Calendar.getInstance().getTimeInMillis();
     *  137
     *  Calendar.getInstance().getTimeInMillis() 这种方式速度最慢，这是因为Canlendar要处理时区问题会耗费较多的时间。
     * </pre>
     */
    public static void main(String[] args) {
        long times = 1000 * _TEN_THOUSAND;
        long t1 = System.currentTimeMillis();
        testSystem(times);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        testCalander(times);
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);

        testDate(times);
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }

    public static void testSystem(long times) {// use 188
        for (int i = 0; i < times; i++) {
            System.currentTimeMillis();
        }
    }

    public static void testCalander(long times) {// use 6299
        for (int i = 0; i < times; i++) {
            Calendar.getInstance().getTimeInMillis();
        }
    }

    public static void testDate(long times) {
        for (int i = 0; i < times; i++) {
            new Date().getTime();
        }
    }

}
