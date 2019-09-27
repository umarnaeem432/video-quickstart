package com.twilio.video.quickstart.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.twilio.video.quickstart.R;

public class ReceiveCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_call);

        FloatingActionButton accept = findViewById(R.id.accept);
        FloatingActionButton cancel = findViewById(R.id.cancel);

        accept.setOnClickListener(v -> {
            Intent intent = new Intent(ReceiveCall.this, VideoActivity.class);


            startActivity(intent);
        });

        cancel.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

    }
}
