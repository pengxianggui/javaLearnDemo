package com.pengxg.demo.observer.my;

import com.pengxg.demo.observer.my.abstracts.Abservable;
import com.pengxg.demo.observer.my.abstracts.Observer;

public class Audience implements Observer {

    private String username;

    public Audience(String username) {
        this.username = username;
    }

    public void action(Abservable abservable) {
        Game game = (Game) abservable;
        if (game.getResult().equals("win")) {
            System.out.println(username + "开始欢呼...");
        } else if (game.getResult().equals("fail")) {
            System.out.println(username + "开始哀嚎...");
        } else {
            System.out.println(username + "不知所措...");
        }
    }
}
