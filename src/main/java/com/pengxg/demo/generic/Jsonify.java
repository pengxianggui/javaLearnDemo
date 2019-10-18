package com.pengxg.demo.generic;

import cn.hutool.json.JSON;

// 泛型接口
public interface Jsonify<T> {
    JSON toJSON(T data);
}
