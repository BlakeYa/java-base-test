package org.example.basis.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest{
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        System.out.println(map.get("apple")); // 123
        map.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map.get("apple")); // 789


        /**
         * 遍历
         */
        Set<String> strings = map.keySet();
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //遍历方式2
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key："+key + " value:"+value);
        }




    }
}
