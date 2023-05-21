package org.example.basis.constructor;

public class Constructor01 {
    public Constructor01(){};

    String a;
    int b;
     public Constructor01(String a,int b){
         this.a=a;
         this.b=b;
     }
    public Constructor01(String a){
        this.a=a + "你0";

    }

    @Override
    public String toString() {
        return "Constructor01{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
    Constructor01 constructor01 = new Constructor01("2");

        System.out.println(constructor01.toString());
    }
}
