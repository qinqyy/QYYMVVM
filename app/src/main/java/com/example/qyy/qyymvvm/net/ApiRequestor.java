package com.example.qyy.qyymvvm.net;

import com.example.qyy.qyymvvm.net.netobserver.ParentBean;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiRequestor {
    private static NetService API() {
        return NetSingleHelper.getNetService();
    }

    /**
     * 订单没个状态总数
     *
     * @return
     */
    public static Observable<ParentBean<JsonObject>> getOrderTypeNum(String userid) {
        return API().setuiuiu(userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 打印数据
     */
    public static Observable<ParentBean<JsonObject>> getOrderPrint(String orderid, String userid) {
        return API().getOrderPrint(orderid, userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
