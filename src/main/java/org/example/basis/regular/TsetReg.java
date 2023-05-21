package org.example.basis.regular;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class TsetReg{
    public static void main(String[] args) throws Exception {
        Set<Long> pidList = new HashSet<>();
        pidList.add(129329392L);
        pidList.add(129324322L);

        System.out.println("采购任务不存在,任务ID："+ JSON.toJSONString(pidList));


        String re = "\\d";
        for (String s : Arrays.asList("010-12345678", "0209999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                continue;
            }
        }
        for (String s : Arrays.asList("01012345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}