package com.emosphere.emosphere.utils;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

//同一封装结果集,每个结果有基本的数据{
//   code:  200表示成功  500表示失败
//   message :  数据返回的信息
//   success :  成与否
//   可以使用put添加键值对


public class R extends HashMap<String, Object> {
    @Serial
    private static final long serialVersionUID = 1L;

    private static  final  Integer ERROR_CODE = 500;
    private static  final  Integer SUCCESS_CODE = 200;
    public R() {
        put("code", SUCCESS_CODE);
        put("message", "此次操作成功");
    }

    public static R error() {
        return error(ERROR_CODE, "未知异常，请联系管理员");
    }

    public static R error(String message) {
        return error(ERROR_CODE, message);
    }

    public static R error(int code, String message) {
        R r = new R();
        r.put("code", code);
        r.put("message", message);
        r.put("success",false);
        return r;
    }

    public static R ok(String message) {
        R r = new R();
        r.put("message", message);
        r.put("success",true);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R().put("success",true);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}


