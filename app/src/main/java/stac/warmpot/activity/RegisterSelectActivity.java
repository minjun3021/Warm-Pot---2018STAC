package stac.warmpot.activity;


import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;


import stac.warmpot.BackPressCloseHandler;
import stac.warmpot.R;


public class RegisterSelectActivity extends AppCompatActivity {
    Button resbutton;
    TextView already;
    private SessionCallback callback;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);


        callback = new SessionCallback();

        Session.getCurrentSession().addCallback(callback);

        backPressCloseHandler = new BackPressCloseHandler(this);
        resbutton = findViewById(R.id.rs_btn);
        already = findViewById(R.id.rs_already);
        already.setText(R.string.register_select_text);
        resbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSelectActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSelectActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    public void requestMe() {
        UserManagement.getInstance().me(new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(MeV2Response result) {
                // TODO 나중에 서버 연동할떄 서버에 보낼 access_token값
                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                String access_token = Session.getCurrentSession().getTokenInfo().getAccessToken();

                Log.e("token", access_token);
                Log.e("user",result.getNickname());
                Toast.makeText(RegisterSelectActivity.this, result.getNickname()+"님 로그인 되었습니다.", Toast.LENGTH_SHORT).show();

                editor.putString("kakaoname",result.getNickname());
                editor.putInt("login", 0);
                editor.putInt("kakao", 1);
                editor.putString("kakaotoken", access_token);
                editor.commit();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(RegisterSelectActivity.this, connect.class);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);


            }
        });
    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();

        //super.onBackPressed();

    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            Log.i("KAKAO", "Session Opened");
            requestMe();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Logger.e(exception);
            }
        }

    }


}
