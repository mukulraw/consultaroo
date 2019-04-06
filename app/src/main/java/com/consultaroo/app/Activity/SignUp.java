package com.consultaroo.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.consultaroo.app.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Button mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mSignUp = findViewById(R.id.bt_signup);
        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_signup){
            startActivity(new Intent(SignUp.this, VerifyOTP.class));
        }
    }
}
