package com.pengxg.demo.observer.my;

import com.pengxg.demo.observer.my.abstracts.Abservable;

public class Game extends Abservable {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyAllObservers();
    }
}
