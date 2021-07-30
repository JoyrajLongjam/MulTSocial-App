package com.joyrajlongjam.MulTSocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button no;
        Button po;
        Button m;
        Button n;
        no=findViewById(R.id.no);
        po=findViewById(R.id.po);
        n=findViewById(R.id.n);
        m=findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start.this,MainActivity.class);
                startActivity(intent);

            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(start.this,News.class);
                startActivity(intent2);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(start.this,NoteActivity.class);
                startActivity(intent3);

            }
        });

        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(start.this,SignInActivity.class);
                startActivity(intent4);

            }
        });

    }
}