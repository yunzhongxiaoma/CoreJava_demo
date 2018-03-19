package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	public static void main(String[] args) {
//		Date create_time = rs.getDate("create_time");//开始时间2017-12-27 17:40:09
		DateFormat format= new SimpleDateFormat("yyyy年MM月dd日");	
//		String start = format.format(create_time);	//结果2017年12月27日
	}
}
