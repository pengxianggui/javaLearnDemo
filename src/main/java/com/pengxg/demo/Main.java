package com.pengxg.demo;

import org.junit.Test;

public class Main {

    @Test
    public void test() {
        int cap = 17;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println ((n < 0) ? 1 : n + 1);
    }
}
