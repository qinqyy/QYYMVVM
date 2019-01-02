package com.example.qyy.qyymvvm.page;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.qyy.qyymvvm.base.BsViewModel;

public class LoginViewModel extends BsViewModel<LoginRepository> {
    public MutableLiveData<String> str = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public LoginRepository getmRepository() {
        return new LoginRepository();
    }

    public void getss(String userid) {
        mRepository.get(userid, str, isShowdialog);

    }

}
