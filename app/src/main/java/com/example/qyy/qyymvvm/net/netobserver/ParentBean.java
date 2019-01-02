package com.example.qyy.qyymvvm.net.netobserver;

import com.google.gson.annotations.SerializedName;

/**
 * 请求响应父类bean
 * Created by on 07,八月,2017
 *
 * @author : qinyongyi; NST company; qinyongyi@nst168.com
 */

public class ParentBean<T> {

    /**
     * code : 返回码
     * description : 描述
     * resultMap : {}
     * success : 是否请求成功
     */

    private int code;
    private String msg;
    @SerializedName("data")
    private T data;
    private boolean result;
    private String executed;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }
}
