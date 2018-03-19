package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestArrayList {
	public static void main(String[] args) {
		List<Object> a = new ArrayList();
		a.add(new Object());
		a.add(new Object());
		System.out.println("ArrayList:");
		System.out.println(a.size());
//		a.remove(1);
		a.removeAll(a);
		System.out.println(a.size());
	}
}
