package com.pengxg.demo.observer;

import com.pengxg.demo.observer.jdk.Game;
import com.pengxg.demo.observer.my.Audience;
import org.junit.Test;

public class Main {

    @Test
    public void testMy () {
        com.pengxg.demo.observer.my.Game game = new com.pengxg.demo.observer.my.Game();
        Audience zhangsan = new Audience("张三");
        Audience lisi = new Audience("李四");
        Audience wangwu = new Audience("王五");
        game.registerObserver(zhangsan);
        game.registerObserver(lisi);
        game.registerObserver(wangwu);
        game.setResult("win");
        game.setResult("fail");
        game.setResult("xxx");
    }

    @Test
    public void testJdk() {
        Game game = new Game();
        com.pengxg.demo.observer.jdk.Audience zhangsan = new com.pengxg.demo.observer.jdk.Audience("张三");
        com.pengxg.demo.observer.jdk.Audience lisi = new com.pengxg.demo.observer.jdk.Audience("李四");
        com.pengxg.demo.observer.jdk.Audience wangwu = new com.pengxg.demo.observer.jdk.Audience("王五");
        game.addObserver(zhangsan);
        game.addObserver(lisi);
        game.addObserver(wangwu);
        game.setResult("win");
        game.setResult("fail");
        game.setResult("xxx");
    }

}
