package com.pengxg.demo.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Audience implements Observer {

    private String username;

    public Audience(String username) {
        this.username = username;
    }

    public void update(Observable o, Object arg) {
        Game game = (Game) o;
        if (game.getResult().equals("win")) {
            System.out.println(username + "开始欢呼...");
        } else if (game.getResult().equals("fail")) {
            System.out.println(username + "开始哀嚎...");
        } else {
            System.out.println(username + "不知所措...");
        }
    }
}
