package me.hao0.graphql.practice.model;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
public class HttpResponse {

    private Integer code;

    private Object data;

    private String msg;

    private HttpResponse(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static HttpResponse ok(Object data){
        return new HttpResponse(200, data, null);
    }

    public static HttpResponse error(Integer code, String msg){
        return new HttpResponse(code, null, msg);
    }
}
