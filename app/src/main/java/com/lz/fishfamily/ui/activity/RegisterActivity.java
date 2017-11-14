package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.InputType;
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
import com.lz.library.utils.ToastUtils;
import com.lz.fishfamily.utils.Utils;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultConsumer;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 注册界面 or 找回密码
 *     version: 1.0
 * </pre>
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.et_phone_number)
    EditText et_phone_number;

    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @BindView(R.id.et_validate_code)
    EditText et_validate_code;

    @BindView(R.id.tv_next)
    TextView tv_next;

    @BindView(R.id.tv_send_validate_code)
    TextView tv_send_validate_code;

    //Register or FindPwd
    String mType;


    @Override
    protected void initViewsAndEvents() {
        mType = getIntent().getStringExtra("type");
        tv_next.setText(mType.equals("register") ? "下一步" : "找回密码");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_register;
    }


    @OnClick({R.id.tv_login, R.id.tv_send_validate_code, R.id.tv_next, R.id.iv_show_pwd})
    public void onClick(View view) {
        if (view.getId() == R.id.tv_login) {
            finish();
        } else if (view.getId() == R.id.tv_next) {
            if (Utils.INSTANCE.isEmpty(new String[]{"请输入手机号", "请输入密码", "请输入验证码"}, et_phone_number, et_pwd, et_validate_code)) {
                if (mType.equals("register"))
                    register();
                else
                    findPwd();
            }
        } else if (view.getId() == R.id.iv_show_pwd) {
            if (et_pwd.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD)
                et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            else
                et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            if (Utils.INSTANCE.isEmpty(new String[]{"请输入手机号"}, et_phone_number)) {
                sendValidateCode();
            }
        }
    }

    /**
     * 找回密码
     */
    private void findPwd() {
        showLoading();
        String tel = et_phone_number.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        String validateCode = et_validate_code.getText().toString().trim();
        Api.create(LoginApi.class).findPwd(tel, pwd, validateCode)
                .compose(bindToLifecycle())
                .map(new HandlerApiResultFunction(this))
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> showSuccess())
                .subscribe(s -> {
                    ToastUtils.showToast("密码修改成功");
                    MainActivity.toActivity(RegisterActivity.this);
                }, new HandlerApiResultConsumer());
    }

    /**
     * 注册
     */
    private void register() {
        showLoading();
        String tel = et_phone_number.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        String validateCode = et_validate_code.getText().toString().trim();
        Api.create(LoginApi.class).register(tel, pwd, validateCode)
                .compose(bindToLifecycle())
                .map(new HandlerApiResultFunction<>(this))
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> showSuccess())
                .subscribe(s -> {
                    ToastUtils.showToast("注册成功");
                    CacheUtils.saveToken(s.getToken());
                    CacheUtils.saveUserId(s.getUserInfo_ID());
                    EventBus.getDefault().post(new LoginEvent(LoginEvent.EVENT_TYPE_GET_USER_INFO));
                    CompleteProfileActivity.toActivity(RegisterActivity.this, s.getUserInfo_ID());
                }, new HandlerApiResultConsumer());
    }

    /**
     * 发送验证码
     */
    private void sendValidateCode() {
        showLoading();
        String tel = et_phone_number.getText().toString().trim();
        Api.create(LoginApi.class).sendValidateCode(tel)
                .compose(bindToLifecycle())
                .map(new HandlerApiResultFunction<>(this))
                .doFinally(() -> showSuccess())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    ToastUtils.showToast("验证码已发送,注意查收");
                    startCountDown();
                }, new HandlerApiResultConsumer());

    }

    /**
     * 开始倒计时
     */
    private void startCountDown() {
        final int count = 60;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count + 1)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .map(aLong -> count - aLong)
                .doOnSubscribe(disposable -> tv_send_validate_code.setEnabled(false))
                .doFinally(() -> {
                    tv_send_validate_code.setEnabled(true);
                    tv_send_validate_code.setText("发送验证码");
                })
                .subscribe(aLong -> {
                    tv_send_validate_code.setText(aLong + "秒后重发");
                });
    }

    public static void toActivity(Context context, String type) {
        Intent intent = new Intent(context, RegisterActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    public static void toRegisterActivity(Context context) {
        toActivity(context, "register");
    }

    public static void toFindPwdActivity(Context context) {
        toActivity(context, "findPwd");
    }

}
