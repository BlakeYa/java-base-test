package org.example.basis.collection.list;

import java.util.Arrays;
import java.util.List;


public class EqualsTest{
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
            new Person("Xiao", "Ming", 18),
            new Person("Xiao", "Hong", 25),
            new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));


        //这里主要是要看 有没有重新 equals 方法，如果重写如下：就测试成功，否则失败。
        /*@Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName);
        }*/
        System.out.println(exist ? "测试成功!" : "测试失败!");


        /**
         * Java标准库提供的String、Integer等已经覆写了equals()方法,所以下面返回true
         */
        List<String> list2 = Arrays.asList("A", "B", "C");
        System.out.println(list2.contains(new String("C"))); // true
        System.out.println(list2.indexOf(new String("C"))); // 2
    }

}
