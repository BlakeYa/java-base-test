package org.example.basis.Stream;

import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b");

        Stream<byte[]> stream = strings.stream().map(String::getBytes);

        System.out.println(stream);

        Stream<String> stringStream = Arrays.stream(new String[]{"2020-04-01", "2020-04-02", "2020-04-03", "2020-04-04"});
        stringStream.map(LocalDate::parse).forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);

        int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> a + b);
        System.out.println(sum); // 15


        //将字符串格式的东西转换成 k-v
        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> reduce = props.stream().map(k -> {
            String[] split = k.split("\\=", 2);
            Map a = (Map) new HashMap().put(split[0], split[1]);
            return a;
        }).reduce(new HashMap<String, String>(), (a, b) -> {
            a.putAll(b);
            return a;
        });

        System.out.println(JSON.toJSONString(reduce));


        reduce.forEach((k,v)->{
            System.out.println("key:"+k +" value:"+v);
        });


        //将java对象 转换成 json
        String   javaString = "demandId=2000081415502267084765";
        String[] split = javaString.split("\\=");
        Arrays.asList(split).stream().forEach((k)->{
            System.out.println(k);
        });

        String[] split1 = javaString.split("\\=", 2);
        System.out.println(split1);


    }
}
