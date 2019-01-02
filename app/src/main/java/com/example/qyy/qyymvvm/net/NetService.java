package com.example.qyy.qyymvvm.net;

import com.example.qyy.qyymvvm.net.netobserver.ParentBean;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetService {

    /**
     * 获取配送员
     */
    @FormUrlEncoded
    @POST("HandsetOrder/site_staff")
    Observable<ParentBean<JsonObject>> setuiuiu(
            @Field("order_id") String orderid);

    /**
     * 打印数据
     */

    @FormUrlEncoded
    @POST("HandsetOrder/print_data")
    Observable<ParentBean<JsonObject>> getOrderPrint(
            @Field("order_id") String orderid,
            @Field("user_id") String userid
    );
}
