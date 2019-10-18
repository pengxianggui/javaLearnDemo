package com.pengxg.demo.generic;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;

// 泛型类 示例, 实现泛型接口Jsonify
public class DataContainer<E> implements Jsonify<E> {
    private E data;

    // 并不是泛型方法
    public E getData() {
        return data;
    }

    // 并不是泛型方法
    public void setData(E data) {
        this.data = data;
    }

    public JSON toJSON(E data) {
        return new JSONObject(data);
    }


    /*
     * 泛型方法, public 和 返回类型声明String之间的<T> 表明了这是一个泛型方法。因此getData和setData并不是泛型方法。
     * 需要特别区分的是, 这里的泛型参数T与类中声明的泛型参数没有关系, 这里也可以改为E。
     */
    public <T> String toString (T ele) {
        return ele.toString();
    }

}
