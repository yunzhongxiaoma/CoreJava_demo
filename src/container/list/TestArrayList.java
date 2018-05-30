package container.list;

import java.util.ArrayList;
import java.util.List;


public class TestArrayList {
	public static void main(String[] args) {
	    testSize();
//	    testIndex();
	}
	
	public static void testSize() {
//	    List<Object> list = new ArrayList();
//		list.add(new Object());
//		list.add(new Object());
//		System.out.println(list.size());
////		a.remove(1);
//		list.removeAll(list);// 删除自己
//		System.out.println(list.size());
		
		/*测试null.size()*/
	    List<String> list3 = new ArrayList<String>();
	    System.out.println(list3.size());// 0
		List<String> list2 = null;
		System.out.println(list2.size());// java.lang.NullPointerException
	}
	
	public static void testIndex() {
	    List<String> list = new ArrayList<String>();
	    list.add("1");
	    list.add("2");
	    list.add("3");
	    list.remove(1);// 删一个，后面的元素补上来
	    System.out.println(list.get(1));
	}
}
