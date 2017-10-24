package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.api.Api;
import com.lz.fishfamily.api.LoginApi;
import com.lz.fishfamily.ui.MainActivity;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.CacheUtils;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultCosumer;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction;
import com.lz.library.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/07
 *     desc   : 登录界面
 *     version: 1.0
 * </pre>
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_phone_number)
    EditText et_login_phone_number;

    @BindView(R.id.et_pwd)
    EditText et_login_pwd;

    @BindView(R.id.tv_register)
    TextView tv_register;

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tv_login, R.id.tv_register, R.id.tv_forget_pwd})
    public void onLoginClick(View view) {
        if (view.getId() == R.id.tv_login) {
            if (validate()) login();
        } else if (view.getId() == R.id.tv_register) {
//            CompleteProfileActivity.toActivity(view.getContext(), CacheUtils.getUserId());
            RegisterActivity.toRegisterActivity(view.getContext());
        } else {
            RegisterActivity.toFindPwdActivity(view.getContext());
        }

    }

    private void login() {
        showLoadingDialog();
        String phoneNumber = et_login_phone_number.getText().toString().trim();
        String pwd = et_login_pwd.getText().toString().trim();
        Api.create(LoginApi.class)
                .login(phoneNumber, pwd)
                .compose(bindToLifecycle())
                .map(new HandlerApiResultFunction<>())
                .doFinally(() -> hidLoadingDialog())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    CacheUtils.saveToken(s.getToken());
                    CacheUtils.saveUserId(s.getUserInfo_ID());
                    ToastUtils.showToast("登录成功");
                    EventBus.getDefault().post(new LoginEvent(LoginEvent.EVENT_TYPE_GET_USER_INFO));
                    MainActivity.toActivity(LoginActivity.this);
                }, new HandlerApiResultCosumer());
    }

    private boolean validate() {
        if (TextUtils.isEmpty(et_login_phone_number.getText().toString().trim())) {
            ToastUtils.showToast("手机号不能为空");
            return false;
        } else if (TextUtils.isEmpty(et_login_pwd.getText().toString().trim())) {
            ToastUtils.showToast("密码不能为空");
            return false;
        }
        return true;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
