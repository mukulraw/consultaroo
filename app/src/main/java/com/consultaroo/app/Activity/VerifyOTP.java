package com.consultaroo.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.consultaroo.app.R;

public class VerifyOTP extends AppCompatActivity implements View.OnClickListener {
Button mVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        mVerify = findViewById(R.id.bt_verify);
        mVerify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_verify){
            startActivity(new Intent(VerifyOTP.this, UserDetails.class));
        }
    }
}
