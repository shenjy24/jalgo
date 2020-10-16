package com.jonas.number;

/**
 * @author shenjy
 * @date 2020/10/16
 * @description 最大公约数
 */
public class GreatestCommonDivisor {

    public int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        return gcd(b, a % b);
    }

}
