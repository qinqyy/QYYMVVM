package com.example.qyy.qyymvvm.net.netobserver;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends DisposableObserver<ParentBean<T>> {
    private int errorCode = -1;
    private String errorMsg = "未知的错误！";


    public abstract void onSuccess(T t);

    public abstract void onFailure(int code, String str);

    @Override
    public void onNext(ParentBean<T> tParentBean) {
        if (tParentBean.isResult()) {
            onSuccess(tParentBean.getData());
        } else {
            onFailure(tParentBean.getCode(), tParentBean.getMsg());
        }
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            errorCode = httpException.code();
            errorMsg = httpException.getMessage();
            // getErrorMsg(httpException);
        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {
            errorMsg = "数据解析错误";
        } else if (t instanceof SocketTimeoutException) {  //VPN open
            errorMsg = "服务器响应超时";
        } else if (t instanceof ConnectException) {
            errorMsg = "网络连接异常，请检查网络";
        } else if (t instanceof RuntimeException) {
            errorMsg = "运行时错误";
        } else if (t instanceof UnknownHostException) {
            errorMsg = "无法解析主机，请检查网络连接";
        } else if (t instanceof UnknownServiceException) {
            errorMsg = "未知的服务器错误";
        } else if (t instanceof IOException) {  //飞行模式等
            errorMsg = "没有网络，请检查网络连接";
        }
        onFailure(errorCode, t.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
