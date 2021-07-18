package com.dds;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.dds.core.MainActivity;
import com.dds.core.base.BaseActivity;
import com.dds.core.consts.Urls;
import com.dds.core.socket.IUserState;
import com.dds.core.socket.SocketManager;
import com.dds.webrtc.R;

public class LauncherActivity extends BaseActivity implements IUserState {
    private Toolbar toolbar;
    //private EditText etUser;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        initView();
        java();//自动化成功案例

        if (SocketManager.getInstance().getUserState() == 1) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        //etUser = findViewById(R.id.et_user);
        button8 = findViewById(R.id.button8);

        //etUser.setText(App.getInstance().getUsername());
    }

    public void java() {
        String username = "ARGLASS";

        /*

        //etUser.setText("ARGLASS", TextView.BufferType.EDITABLE);

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "再次点击以默认ARGLASS登陆", Toast.LENGTH_LONG).show();
            return;
        }

         */
        // 设置用户名
        App.getInstance().setUsername(username);
        // 添加登录回调
        SocketManager.getInstance().addUserStateCallback(this);
        // 连接socket:登录
        SocketManager.getInstance().connect(Urls.WS, username, 0);


    }

    @Override
    public void userLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void userLogout() {

    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }

    }
}
