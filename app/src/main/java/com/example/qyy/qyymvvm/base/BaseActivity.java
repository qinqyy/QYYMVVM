package com.example.qyy.qyymvvm.base;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BsViewModel> extends AppCompatActivity {
    protected T mviewModel;

    public abstract T getMviewModel();

    private ProgressDialog mDialog;

    protected void isShowDialog(boolean isShowDialog) {
        if (isShowDialog && mviewModel != null) {
            mDialog = new ProgressDialog(this);
            mviewModel.isShowdialog.observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    if (aBoolean) {
                        if (!mDialog.isShowing()) {
                            mDialog.show();
                        }
                    } else {
                        if (mDialog.isShowing()) {
                            mDialog.dismiss();
                        }
                    }
                }
            });
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mviewModel = getMviewModel();
    }


}
