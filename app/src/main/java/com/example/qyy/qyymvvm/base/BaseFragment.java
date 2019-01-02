package com.example.qyy.qyymvvm.base;


import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qyy.qyymvvm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseFragment} factory method to
 * create an instance of this fragment.
 */
public abstract class BaseFragment<T extends BsViewModel> extends Fragment {

    protected T mViewModel;

    public abstract T getMviewModel();

    private ProgressDialog mDialog;

    /**
     * 网络请求是否弹框
     * 放在网络请求之前
     *
     * @param isShow
     */
    protected void isShowDialog(boolean isShow) {
        if (isShow && mViewModel != null) {
            mDialog = new ProgressDialog(getContext());
            mViewModel.isShowdialog.observe(this, new Observer<Boolean>() {
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


    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getMviewModel();
    }


}
