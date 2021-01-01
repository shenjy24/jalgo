package com.jonas.string;

public class GcdString {

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        return gcd(b, a % b);
    }
}
