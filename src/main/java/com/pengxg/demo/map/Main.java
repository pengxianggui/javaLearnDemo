package com.pengxg.demo.map;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class Main {
    public static void main(String... args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("duration", "3");
        jsonObject.put("entry", new JSONObject());
        jsonObject.put("requestFiles", new JSONObject(){
            {
                put("key2-1", "value2-1");
                put("entry", new JSONObject() {
                    {
                        put("key2-2", "value2-2");
                        put("entry", new JSONObject(){
                            {
                                put("key3-1", "value3-1");
                                put("entry", new JSONObject() {
                                    {
                                        put("key3-2", "key3-2");
                                        put("key3-3", "key3-3");
                                    }
                                });
                                put("entry1", "entry1");
                                put("entry2", "entry2");
                            }
                        });
                    }
                });
            }
        });
        jsonObject.put("arr", new JSONArray() {
            {
                put(new JSONObject() {
                    {
                        put("map", "map");
                        put("test1", "map");
                        put("entry", new JSONObject() {
                            {
                                put("xxx", "xxx");
                                put("entry", "entry");
                            }
                        });
                    }
                });
            }
        });
        jsonObject.put("arr1", new JSONArray() {
            {
                put(new JSONObject() {
                    {
                        put("map", "map");
                        put("test1", "map");
                        put("entry", new JSONObject() {
                            {
                                put("xxx", "xxx");
                                put("entry", "entry");
                            }
                        });
                    }
                });
            }
        });
        jsonObject.put("entry", new JSONObject(){
            {
                put("key3", "value3");
                put("key4", "value4");
            }
        });
        System.out.println(jsonObject.toString());
        System.out.println("===============================");
//        System.out.println(execute(jsonObject).toString());

        floating(jsonObject, null, null);
        System.out.println(jsonObject);
    }

    /**
     * 传入一个JSONObject，判断key为"entry"的value, 若该value时一个JSONObject, 则将其中的key:value都拿到外层去。如：
     * {
     *     key1: value1,
     *     entry: {
     *         key2: value2,
     *         key3: value3,
     *         entry: entryValue
     *     }
     * }
     * 则返回值为：
     * {
     *     key1: value1,
     *     key2: value2,
     *     key3: value,
     *     entry: entryValue
     * }
     * @param jsonObject
     * @return
     */
    public static JSONObject execute(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }

        JSONObject json = new JSONObject(jsonObject.toString());
        for (Object key : json.keySet()) {
            String keyStr = String.valueOf(key);
            Object value = jsonObject.get(keyStr);
            if (value != null && value instanceof JSONObject) {
                JSONObject subJSON = execute((JSONObject) value);
                if (keyStr.equals("entry")) {
                    for (Object subKey : subJSON.keySet()) {
                        if (subKey != null) {
                            jsonObject.put(String.valueOf(subKey), subJSON.get(String.valueOf(subKey)));
                        }
                    }
                    jsonObject.remove("entry");
                }
            }
        }
        return jsonObject;
    }

    public static void floating(JSONObject sonJson, String K, JSONObject parentJson) {

        if (sonJson == null) return;

        JSONObject json = new JSONObject(sonJson.toString());
        Iterator itor = json.keys();
        while (itor.hasNext()) {
            String keyStr = String.valueOf(itor.next());
            Object value = sonJson.get(keyStr);
            if (value instanceof JSONObject) {
                floating((JSONObject) value, keyStr, sonJson);
            }
            if (value instanceof JSONArray) {
                JSONArray array = (JSONArray) value;
                for (int i = 0; i < array.length(); i++) {
                    if (array.get(i) instanceof JSONObject) {
                        floating((JSONObject) array.get(i), null, null);
                    }
                }
            }
            
        }

        if (K != null && K.equals("entry")) {
            parentJson.remove(K);
            for (Object key : sonJson.keySet()) {
                parentJson.put(String.valueOf(key), sonJson.get(String.valueOf(key)));
            }
        }

    }
}
