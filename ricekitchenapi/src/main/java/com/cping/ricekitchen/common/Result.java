package com.cping.ricekitchen.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result success(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result success(Object data) {
        return success(200, "success", data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result fail(String msg,Object data) {
        return success(400, msg, data);
    }
    public static Result fail(String msg) {
        return success(400, msg, null);
    }
}
