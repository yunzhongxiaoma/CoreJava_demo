package collection.list;

import java.util.LinkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Object> linkedList = new LinkedList<Object>();
		linkedList.add(new Object());
		linkedList.add(new Object());
		System.out.println("linkedList:");
		System.out.println(linkedList.size());
		linkedList.remove();
		linkedList.removeAll(linkedList);
		System.out.println(linkedList.size());
	}
}
