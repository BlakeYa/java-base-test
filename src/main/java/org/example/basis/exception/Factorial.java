package org.example.basis.exception;


import org.junit.jupiter.api.Test;

public class Factorial {
    public static long fact(long n) {
        if (n < 0) {
            System.out.println("throw new IllegalArgumentException()");
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }

    @Test
    public void test() {
        Factorial.fact(1);
    }


}


