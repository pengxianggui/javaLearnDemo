package com.pengxg.demo.math;

import java.util.Scanner;

public class PrimeNum {

    /**
     * 传入一个整数，判断是否为素数
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            System.out.println("素数必须大于1");
            return false;
        }
        int i = 2;
        while (i < num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要判断的正整数：");
        int value = scanner.nextInt();
        System.out.println(isPrime(value) ? "是素数" : "不是素数");
    }
}
