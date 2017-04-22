package com.example.shubhraj.dealskart;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FullScreenActitvity extends AppCompatActivity
{
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_actitvity);
        status = getIntent().getStringExtra("STATUS");
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("STATUS", status);
                startActivity(intent);
            }

        }, 1000L);
    }
}
