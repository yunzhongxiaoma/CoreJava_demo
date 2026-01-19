package main.java.container.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        
        /**
         * size
         */
        hashMap.put(null, null);// 也算一个空间
        hashMap.put(null, null);// 也算一个空间
        hashMap.put("second", 2);
        hashMap.put("second", 2);// 替换掉重复的，总空间还是2
        int size = hashMap.size();
        System.out.println(size); //2
        
        
        /**
         *  遍历
         */
        Set<Entry<String, Integer>> entrySet = hashMap.entrySet();// 键值
        System.out.println(entrySet);
        
        Set<String> keySet = hashMap.keySet(); // 键
        System.out.println(keySet);
        
        Collection<Integer> values = hashMap.values();// 值
        System.out.println(values);
        
    }
}
