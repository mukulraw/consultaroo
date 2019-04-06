package com.consultaroo.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyProfessional extends AppCompatActivity {


    ImageView profess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_professional);

        profess=findViewById(R.id.profess);
        profess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Chatlist.class);
                startActivity(intent);


            }
        });


    }
}
