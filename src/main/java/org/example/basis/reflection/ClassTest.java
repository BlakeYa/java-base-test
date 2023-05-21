package org.example.basis.reflection;

public class ClassTest {

    Number n = new Double(123.456); // OK

    public static void main(String[] args) {
        Class<String> stringClass = String.class;

        System.out.println(stringClass.getName());

        String s = "Hello";
        Class<? extends String> ss = s.getClass();
        System.out.println(ss.toGenericString());
        System.out.println(ss.toString());

        Integer n = new Integer(123);

        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class

    }

}
