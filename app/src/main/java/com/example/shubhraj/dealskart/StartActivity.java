package com.example.shubhraj.dealskart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity
{
    private ImageView buyer, seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        buyer = (ImageView) findViewById(R.id.buyer);
        seller = (ImageView) findViewById(R.id.seller);
        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FullScreenActitvity.class);
                intent.putExtra("STATUS", "BUYER");
                startActivity(intent);
            }
        });

        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FullScreenActitvity.class);
                intent.putExtra("STATUS", "SELLER");
                startActivity(intent);
            }
        });
    }
}
