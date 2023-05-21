package org.example.basis.collection.map;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {

    Map<String, Person> map = new HashMap<>();
        map.put("a", new Person("Xiao Ming"));
        map.put("b", new Person("Xiao Hong"));
        map.put("c", new Person("Xiao Jun"));

        System.out.println(map.get("a"));
        System.out.println(map.get("x"));
    }
}
