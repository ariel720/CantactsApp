package com.example.hb2009.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hb2009.contactsapp.dao.MemberDAO;
import com.example.hb2009.contactsapp.presentation.MemberList;
import com.example.hb2009.contactsapp.presentation.MemberRegister;
import com.example.hb2009.contactsapp.service.MemberService;
import com.example.hb2009.contactsapp.service.MemberServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView(){
        final Context conext = MainActivity.this;

        final MemberService service = new MemberServiceImpl(conext);
        //service.createDB(conext);

        findViewById(R.id.btn_join).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemberRegister.class));
            }
        });


        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_email  = (EditText) findViewById(R.id.et_email);
                EditText et_password  = (EditText) findViewById(R.id.et_password);

                if(et_email.getText().toString().equals("") && et_password.getText().toString().equals("")){
                    Toast.makeText(conext,"비어있어요",Toast.LENGTH_SHORT).show();

                }else if(service.existMember(et_email.getText().toString(),et_password.getText().toString()).equals("1")){
                    Toast.makeText(conext,"로그인성공",Toast.LENGTH_SHORT).show();
                    //세션담기

                    //페이지이동
                    startActivity(new Intent(MainActivity.this, MemberList.class));
                }else {
                    Toast.makeText(conext,"없는아이디",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }





}
