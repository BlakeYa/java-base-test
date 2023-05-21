package org.example.basis.stirng.stringBuilder;

public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(1024);
        sb.append("Mr ")
                .append("Bob")
                .append("!")
                //插入
                .insert(0, "Hello, ");

        System.out.println(sb);

        //仿照StringBuilder做的链式累加器
        Adder adder = new Adder();
        adder.add(3)
                .add(4).add(6).inc();
        System.out.println(adder.value());


    }

}

/**
 * 自己做的累加器
 */
class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}

