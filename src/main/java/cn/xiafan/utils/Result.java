package cn.xiafan.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Map<String, Object> map = new HashMap<>();

    public static Result fail() {
        Result result = new Result();
        result.setCode(500);
        result.setMessage("处理失败");
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("处理成功");
        return result;
    }

    public Result add(String key,Object value){
        this.getMap().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
