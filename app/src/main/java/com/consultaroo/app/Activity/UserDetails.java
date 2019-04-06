package com.consultaroo.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.consultaroo.app.Projectone;
import com.consultaroo.app.R;

public class UserDetails extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        submit = findViewById(R.id.bt_signup);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UserDetails.this , Projectone.class);
                startActivity(intent);
                finishAffinity();

            }
        });

    }
}
