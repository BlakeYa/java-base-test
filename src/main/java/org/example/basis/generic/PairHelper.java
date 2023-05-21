package org.example.basis.generic;

public class PairHelper {
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    public static void main(String[] args) {
        System.out.println(PairHelper.add(new Pair<Number>(1,2)));

        Pair<Number> p = new Pair<>(22,33);
        int add =  add(p);
        System.out.println(add);
    }
}