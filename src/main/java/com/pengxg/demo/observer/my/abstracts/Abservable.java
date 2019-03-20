package com.pengxg.demo.observer.my.abstracts;

import java.util.ArrayList;
import java.util.List;

/**
 * 可观察的对象
 */
public class Abservable {
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 注册观察者
     * @param observer
     */
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            return;
        }
        System.out.println(observer.toString() + "已经注册过了, 无需重复注册。");
    }

    public void cancelObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.action(this);
        }
    }
}
