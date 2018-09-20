package stac.warmpot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import stac.warmpot.R;


public class SplashActivity extends AppCompatActivity {
    String token;
    int login;
    int kakao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        token=pref.getString("token","def");
        login=pref.getInt("login",0);
        kakao=pref.getInt("kakao",0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(token!="def" && login==1){
                    Toast.makeText(SplashActivity.this, "자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(SplashActivity.this,connect.class);
                    startActivity(intent);
                    finish();
                }
                else if(kakao==1){
                    Toast.makeText(SplashActivity.this, "카카오톡 자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(SplashActivity.this,connect.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashActivity.this, RegisterSelectActivity.class);

                    startActivity(intent);
                    finish();
                }


            }
        }, 1000);
    }

}
