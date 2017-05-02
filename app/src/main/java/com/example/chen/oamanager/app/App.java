package com.example.chen.oamanager.app;

import com.jaydenxiao.common.BuildConfig;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.SPUtils;

/**
 * Created by Chen on 2017/4/17.
 */

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
        // 得到保存请求参数信息
        initSPData();
    }

    private void initSPData() {
        // 将请求参数信息存入到本地
        Constans.m = SPUtils.getSharedStringData(App.getAppContext(), Constans.M);
        Constans.n = SPUtils.getSharedStringData(App.getAppContext(), Constans.N);
        Constans.t = SPUtils.getSharedStringData(App.getAppContext(), Constans.T);
        Constans.k = SPUtils.getSharedStringData(App.getAppContext(), Constans.K);
        // 时间戳保存到本地
        Constans.expire = SPUtils.getSharedLongData(App.getAppContext(), Constans.EXPIRE_TIME);
    }
}
