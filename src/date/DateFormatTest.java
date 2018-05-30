package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {
        StringToDate();
        // test3();
        // StringToDateDefault();
//        testNull();
    }

    
    
    /**
     * 2011-07-09
     */
    public static void StringToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        String s = "2011-07-09 xdddddds";// "2011/07/09"
        Date date;
        try {
            date = formatter.parse(s);
            System.out.println(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Mon Aug 15 11:24:39 CST 2016
     */
    public static void StringToDateDefault() {
        String datestr = "Mon Aug 15 11:24:39 CST 2016";// Date的默认格式显示
        Date date;
        try {
            date = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(datestr);
            // 格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sDate = sdf.format(date);
            System.out.println(sDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test1() {
        // Date create_time = rs.getDate("create_time");//开始时间2017-12-27 17:40:09
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        // String start = format.format(create_time); //结果2017年12月27日
    }

    /**
     * spring帮助格式化
     * 格式化02 May 2018 - 02:10出错
     */
    public static void test3() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 待转换String格式
        formatter.setLenient(false);
        Date outap_outdate;
        try {
            outap_outdate = formatter.parse("02 May 2018 -  02:10");
            System.out.println(outap_outdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    public static void testNull() {
        Date d = null;
        System.out.println(d);// 运行结果：null
        // System.out.println(null);// 编译出错
    }
}
