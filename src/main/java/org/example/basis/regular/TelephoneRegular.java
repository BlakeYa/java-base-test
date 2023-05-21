package org.example.basis.regular;


import org.junit.jupiter.api.Test;

/**
* @Description:    测试手机号
* @Author:         zzq
* @CreateDate:     2020/9/2
*/
public class TelephoneRegular {

    @Test
    public void isValidMobileNumber() {
        String s = "81192530125";

        // 是否是11位？
        if (s.length() != 11) {
            System.out.println(false);
        }
        // 每一位都是0~9：
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println(false);
            }
        }
        System.out.println(true);

        boolean matches = s.matches("\\d{11}]");
    }



}
