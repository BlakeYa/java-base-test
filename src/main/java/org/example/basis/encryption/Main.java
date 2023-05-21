package org.example.basis.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "我喜欢你!";
        String s1 = "AaAaAa!";
        String s2 = "BBAaBB!";

        String encoded = null;
        try {
            encoded = URLEncoder.encode(s, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(encoded);

        System.out.println(URLDecoder.decode("%E6%88%91%E5%96%9C%E6%AC%A2%E4%BD%A0%21", String.valueOf(StandardCharsets.UTF_8)));

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // 反复调用update输入数据:
            md.update("Hello".getBytes("UTF-8"));
            md.update("World".getBytes("UTF-8"));
            byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
            System.out.println(new BigInteger(1, result).toString(16));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}