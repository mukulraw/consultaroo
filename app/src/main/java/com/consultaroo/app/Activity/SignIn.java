package com.consultaroo.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.consultaroo.app.R;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
TextView mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSignUp = findViewById(R.id.signup);
        mSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.signup){
            startActivity(new Intent(SignIn.this, SignUp.class));
        }
    }
}
