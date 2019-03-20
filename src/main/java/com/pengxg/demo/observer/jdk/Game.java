package com.pengxg.demo.observer.jdk;

import java.util.Observable;

public class Game extends Observable {
    private String result; // 成功或失败

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        setChanged();
        notifyObservers();
    }
}
