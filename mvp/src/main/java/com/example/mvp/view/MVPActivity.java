package com.example.mvp.view;

import android.util.ArrayMap;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.base.arouter.ARouterConstant;
import com.example.commonlibrary.util.LogUtil;
import com.example.mvp.R;
import com.example.mvp.databinding.ActivityMvpBinding;
import com.example.mvp.bean.SnapHelperBean;
import com.example.mvp.presenter.MVPPresenter;
import com.example.mvp.presenter.contract.MVPBannerContract;
import com.example.mvp.util.AppSingle;
import com.example.mvp.view.adapter.SnapHelperAdapter;

import java.util.ArrayList;
import java.util.List;


@Route(path = ARouterConstant.MVP)
public class MVPActivity extends BaseActivity<ActivityMvpBinding> implements MVPBannerContract.MVPView {

    MVPPresenter mMVPPresenter;

    @Autowired(name = "age")
    int age;

    @Override
    protected ActivityMvpBinding getViewBinding() {
        return ActivityMvpBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        mMVPPresenter = new MVPPresenter(this);
        Binding.mvpResult.setText(String.valueOf(age));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    public void getData(View view) {
        mMVPPresenter.MVPGetDate();
    }

    @Override
    public void success(String result) {
        runOnUiThread(() -> Binding.mvpResult.setText(result));
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}