package org.example.basis.date;

import java.text.NumberFormat;
import java.util.Locale;

public class Test{
    public static void main(String[] args) {
        int n = 123400;
        // 123400
        System.out.println(n);
        // 1e208
        System.out.println(Integer.toHexString(n));
        // $123,400.00
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE).format(n));


    }
}