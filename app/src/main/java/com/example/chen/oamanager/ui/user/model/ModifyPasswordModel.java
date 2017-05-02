package com.example.chen.oamanager.ui.user.model;

import com.example.chen.oamanager.api.Api;
import com.example.chen.oamanager.app.App;
import com.example.chen.oamanager.app.Constans;
import com.example.chen.oamanager.bean.HuiTianResponse;
import com.example.chen.oamanager.ui.user.contract.ModifyPasswordContract;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.SPUtils;

import rx.Observable;


/**
 * 2017-05-02 上午11:31
 *
 * @author koumanwei
 * @version 1.0
 */

public class ModifyPasswordModel implements ModifyPasswordContract.Model {
    @Override
    public Observable<HuiTianResponse<String>> changePassword(String oldPassword, String newPassword) {
        String username = SPUtils.getSharedStringData(App.getAppContext(), Constans.USERNAME);
        return Api.getDefault().changePassword(Api.getCacheControl(), Constans.m, Constans.n, Constans.t,Constans.k, username, oldPassword, newPassword)
                .compose(RxSchedulers.<HuiTianResponse<String>>io_main());
    }
}
