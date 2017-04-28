package com.example.chen.oamanager.ui.usre.activity;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.oamanager.R;
import com.example.chen.oamanager.bean.HuiTianResponse;
import com.example.chen.oamanager.bean.LoginBean;
import com.example.chen.oamanager.bean.Meizhi;
import com.example.chen.oamanager.ui.usre.contract.LoginContract;
import com.example.chen.oamanager.ui.usre.model.LoginModel;
import com.example.chen.oamanager.ui.usre.presenter.LoginPresenter;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    @Bind(R.id.forget_pw_tv)
    TextView forgetPwTv;
    @Bind(R.id.close_iv)
    ImageView closeIv;
    @Bind(R.id.tv_modify_password)
    TextView tvModifyPassword;
    @Bind(R.id.editText_username)
    EditText editTextUsername;
    @Bind(R.id.editText_pw)
    EditText editTextPw;
    @Bind(R.id.login_bt)
    Button loginBt;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        SpannableStringBuilder builder = new SpannableStringBuilder(forgetPwTv.getText().toString());
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        ForegroundColorSpan mainColor = new ForegroundColorSpan(getResources().getColor(R.color.mainColor));
        builder.setSpan(mainColor, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgetPwTv.setText(builder);
    }


    @OnClick({R.id.close_iv, R.id.forget_pw_tv, R.id.tv_modify_password, R.id.login_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_iv:
                finish();
                break;
            case R.id.forget_pw_tv:
                startActivity(ForgetPassWordActivity.class);
                break;
            case R.id.tv_modify_password:
                startActivity(ModifyPasswordActivity.class);
                break;
            case R.id.login_bt: // 登陆
                String userName = editTextUsername.getText().toString().trim();
                String passWord = editTextPw.getText().toString().trim();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
                    ToastUitl.showShort("账号或密码不能为空");
                    return;
                }
                // 调用Presenter的登陆方法
                mPresenter.loginUser(userName, passWord);
                break;
        }
    }

    @Override
    public void showLoading(String title) {
        startProgressDialog(title);
    }

    @Override
    public void stopLoading() {
        stopProgressDialog();
    }

    @Override
    public void showErrorTip(String msg) {
        showShortToast(msg);
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        stopLoading();
    }

    @Override
    public void loginFail(String msg) {
        showShortToast(msg);
    }
}