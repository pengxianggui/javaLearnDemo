package com.pengxg.demo.observer.my.abstracts;

/**
 * 观察者对象
 */
public interface Observer {

    /**
     * 目标发生变化时触发的行为
     * @param abservable
     */
    void action(Abservable abservable);
}
