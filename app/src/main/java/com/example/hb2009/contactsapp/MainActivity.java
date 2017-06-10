package com.example.hb2009.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hb2009.contactsapp.dao.MemberDAO;
import com.example.hb2009.contactsapp.presentation.MemberList;
import com.example.hb2009.contactsapp.service.MemberService;
import com.example.hb2009.contactsapp.service.MemberServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context conext = MainActivity.this;

        MemberService service = new MemberServiceImpl();
        service.createDB(conext);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemberList.class));
            }
        });
    }
}
