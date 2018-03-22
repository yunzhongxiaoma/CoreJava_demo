package collection.set;

import java.util.HashSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("hello");
        System.out.println(hashSet);
    }
}
