package com.yd.common.utils;
public class RandomNumberGenerator {
	public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
             random = random + 0.1;
        } for (int i = 0; i < length; i++) {
             num = num * 10;
        }
        return (int) ((random * num));
 }

	public static void main(String[] args) {
		int str = RandomNumberGenerator.buildRandom(6);
		System.out.println(str);
	}
}
