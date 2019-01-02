package com.example.qyy.qyymvvm.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BsRepository {
    private CompositeDisposable compositeDisposable;


    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void unDisposable() {
        if (compositeDisposable != null && compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }

    }
}
