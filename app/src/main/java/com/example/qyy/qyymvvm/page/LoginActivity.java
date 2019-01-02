package com.example.qyy.qyymvvm.page;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.qyy.qyymvvm.R;
import com.example.qyy.qyymvvm.base.BaseActivity;
import com.example.qyy.qyymvvm.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<LoginViewModel> {

    @Override
    public LoginViewModel getMviewModel() {
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewmodel(mviewModel);
        binding.setLifecycleOwner(this);  //databinding和livadata生命周期绑定
        isShowDialog(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment, LoginFragment.newInstance())
                    .commitNow();
        }

        mviewModel.getss("1234");
    }

}
