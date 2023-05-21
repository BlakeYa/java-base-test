package org.example.basis.collection.iterator;

import java.util.*;
import java.util.stream.Collectors;

/**
* @Description:    Java编译器并不知道如何遍历List。
 * 上述代码能够编译通过，只是因为编译器把for each循环通过Iterator改写为了普通的for循环：
* @Author:         zzq
* @CreateDate:     2020/8/25
*/
public class Test {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Apple", "Orange", "Pear");

        for (String s : list1) {
            System.out.println(s);
        }

        //增强for循环底层原理： 实际上就是一个迭代器遍历
        for (Iterator<String> iterator = list1.iterator(); iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }


        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        // 排序前:
        System.out.println(list);
        Collections.sort(list);
        // 排序后:
        System.out.println(list);

        //Collections提供了洗牌算法，即传入一个有序的List,可以随机打乱List内部元素的顺序,效果相当于让计算机洗牌
        // 洗牌前:
        System.out.println(list);
        Collections.shuffle(list);
        // 洗牌后:
        System.out.println(list);

        Set<String> collect = Collections.unmodifiableCollection(
                list).stream().collect(Collectors.toSet());

    }
}
