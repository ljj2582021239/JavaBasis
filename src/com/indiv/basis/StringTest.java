package com.indiv.basis;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("2");
        String s2 = "2";
        String s1 = s.intern();

        System.out.println(s+" "+s1);

        System.out.println(s2==s1);
//        System.out.println(s==s1);
    }
}
