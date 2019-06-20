package com.pengxg.demo.regular;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

public class RegularTest {

    @Test
    public void test() {
        String dateStr = "19-31-2019";
//        System.out.println(dateStr.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d"));
        System.out.println(dateStr.matches(""));


        System.out.println(NumberUtil.isNumber(null));
    }
}
