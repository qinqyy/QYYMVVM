package com.example.qyy.qyymvvm.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public abstract class BsViewModel<T extends BsRepository> extends AndroidViewModel {
    protected T mRepository;

    public MutableLiveData<Boolean> isShowdialog = new MutableLiveData<>();

    public BsViewModel(@NonNull Application application) {
        super(application);
        mRepository = getmRepository();
    }

    public abstract T getmRepository();

    @Override
    protected void onCleared() {
        super.onCleared();
        mRepository.unDisposable();
    }

}
