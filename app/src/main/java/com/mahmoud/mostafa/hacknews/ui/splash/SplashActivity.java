package com.mahmoud.mostafa.hacknews.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mahmoud.mostafa.hacknews.R;
import com.mahmoud.mostafa.hacknews.base.BaseActivity;
import com.mahmoud.mostafa.hacknews.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goNext();
    }

    private void goNext() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

}
