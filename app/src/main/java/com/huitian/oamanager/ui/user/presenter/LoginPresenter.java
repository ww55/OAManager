package com.huitian.oamanager.ui.user.presenter;

import com.huitian.oamanager.bean.HuiTianResponse;
import com.huitian.oamanager.bean.LoginBean;
import com.huitian.oamanager.ui.user.contract.LoginContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

/**
 * Created by Chen on 2017/4/27.
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void loginUser(String userName, String passWord,String keyStr) {
        mRxManage.add(mModel.getLogin(userName, passWord,keyStr).subscribe(new RxSubscriber<HuiTianResponse<LoginBean>>(mContext, false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("正在登陆");
            }

            @Override
            protected void _onNext(HuiTianResponse<LoginBean> response) {
                if (response.getState() == 1) { // 登陆成功
                    // 调用View层登陆成功方法
                    mView.loginSuccess(response.getData());
                } else { // 登陆失败,返回错误信息
                    mView.loginFail(response.getMessage());
                }
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                // 错误
                mView.showErrorTip(message);
                mView.stopLoading();
            }
        }));
    }
}
