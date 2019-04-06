package com.consultaroo.app;

import android.content.Intent;
import android.service.chooser.ChooserTargetService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.consultaroo.app.Activity.SignIn;
import com.consultaroo.consultaroo.Hire;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.ZopimChatActivity;

public class ChooseOption extends AppCompatActivity implements View.OnClickListener {
Button mHire, mWork , chat;

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);

        ZopimChat.init("3wWoC8VwfEuzdVo2XjOMyMSCUyfH0rAT");

        mHire = findViewById(R.id.hire);
        mWork = findViewById(R.id.work);
        chat = findViewById(R.id.chat);

        mHire.setOnClickListener(this);
        mWork.setOnClickListener(this);
      //  imageview=findViewById(R.id.imageview);


/*
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Chat.class);
                startActivity(intent);



            }
        });
*/

chat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        VisitorInfo visitorData = new VisitorInfo.Builder()
                .name("New Visitor")
                .email("visitor@example.com")
                .phoneNumber("0123456789")
                .build();

        ZopimChat.setVisitorInfo(visitorData);

        startActivity(new Intent(ChooseOption.this , ZopimChatActivity.class));

    }
});

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.hire){
            Intent intent = new Intent(ChooseOption.this , Hire.class);
            intent.putExtra("title" , "For hire");
            intent.putExtra("url" , "http://nationproducts.in/consultaroo/want-to-hire");
            startActivity(intent);

            //startActivity(new Intent(ChooseOption.this, SignIn.class));
        }
        else if (v.getId()==R.id.work){
            Intent intent = new Intent(ChooseOption.this , Hire.class);
            intent.putExtra("title" , "For work");
            intent.putExtra("url" , "http://nationproducts.in/consultaroo/want-to-work");
            startActivity(intent);
            //startActivity(new Intent(ChooseOption.this, SignIn.class));
        }
    }
}
