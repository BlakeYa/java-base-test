package org.example.basis.collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key); //根据首字母进行排序
        }
        // apple, orange, pear

        Map<Person1,Integer> personMap = new TreeMap<>(new Comparator<Person1>() {
            @Override
            public int compare(Person1 o1, Person1 o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        personMap.put(new Person1("Tom"), 1);
        personMap.put(new Person1("Bob"), 2);
        personMap.put(new Person1("Lily"), 3);

        for (Person1 person : personMap.keySet()) {
            System.out.println(person);  // Person1{name='Bob'}    Person1{name='Lily'}   Person1{name='Tom'}
        }

        System.out.println(personMap.get(new Person1("Bob"))); // 2
    }
}

class Person1 {
    public String name;
    Person1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}
