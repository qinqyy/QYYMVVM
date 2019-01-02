package com.example.qyy.qyymvvm.page;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.qyy.qyymvvm.base.BsViewModel;

public class LoginFragViewModel extends BsViewModel<LoginFragRepository> {
    public MutableLiveData<String> str = new MutableLiveData<>();

    public LoginFragViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public LoginFragRepository getmRepository() {
        return new LoginFragRepository();
    }

    public void get(String orderid, String userid) {
        mRepository.get(orderid, userid, str, isShowdialog);
    }
}
