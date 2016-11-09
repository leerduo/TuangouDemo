package cn.chenfuduo.tuangoudemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private boolean isFirst = true;
    private SharedPreferences sp;
    private String isFisrtTime = "isFirst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences(isFisrtTime, MODE_PRIVATE);
        isFirst = sp.getBoolean(isFisrtTime, true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if (isFirst) {
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                    isFirst = false;
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean(isFisrtTime, SplashActivity.this.isFirst);
                    editor.commit();
                } else {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
