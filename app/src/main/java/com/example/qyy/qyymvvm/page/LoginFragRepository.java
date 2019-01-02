package com.example.qyy.qyymvvm.page;

import android.arch.lifecycle.MutableLiveData;

import com.example.qyy.qyymvvm.base.BsRepository;
import com.example.qyy.qyymvvm.net.ApiRequestor;
import com.example.qyy.qyymvvm.net.netobserver.BaseObserver;
import com.google.gson.JsonObject;

public class LoginFragRepository extends BsRepository {
    public void get(String orderid, String userid, final MutableLiveData<String> str, final MutableLiveData<Boolean> isshow) {
        isshow.setValue(true);
        BaseObserver<JsonObject> loginobserver = new BaseObserver<JsonObject>() {
            @Override
            public void onSuccess(JsonObject jsonObject) {
                str.setValue(jsonObject.toString());
                isshow.setValue(false);
            }

            @Override
            public void onFailure(int code, String strq) {
                str.setValue(strq);
                isshow.setValue(false);
            }
        };
        ApiRequestor.getOrderPrint(orderid, userid).subscribe(loginobserver);
        addDisposable(loginobserver);
    }
}
