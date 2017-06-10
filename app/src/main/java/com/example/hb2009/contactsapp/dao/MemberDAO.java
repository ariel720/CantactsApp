package com.example.hb2009.contactsapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hb2009.contactsapp.domain.Member;

import java.util.List;

import static com.example.hb2009.contactsapp.domain.Constants.DB_NAME;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_ADDRESS;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_EMAIL;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_NAME;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_PASSWORD;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_PHONE;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_PHOTO;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_SEQ;
import static com.example.hb2009.contactsapp.domain.Constants.MEMBER_TABLE;

/**
 * Created by hb2009 on 2017-06-03.
 */

public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context,DB_NAME , null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      /*  String sql = "CREATE TABLE IF NOT EXIST Member\n" +
                "     (\n" +
                "     "+MEMBER_SEQ+" INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                "     name TEXT,\n" +
                "     password TEXT,\n" +
                "     email TEXT,\n" +
                "    phone TEXT,\n" +
                "    address TEXT,\n" +
                "    photo TEXT\n" +
                "     );";

        db.execSQL(sql);*/


        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT)",
                MEMBER_TABLE,MEMBER_SEQ,MEMBER_NAME,MEMBER_PASSWORD,MEMBER_PHONE,MEMBER_EMAIL,MEMBER_ADDRESS,MEMBER_PHOTO
                ));

        /*String sql2 = "INSERT INTO Member(name,password,email,phone,address,photo) VALUES(\"ariel\",\"ariel\",\"ariel720@naver.com\",\"01012345678\".\"김포\",\"profileimg\");\n" +
                "\n";

        for(i = 0 ; i<9 ; i++){
            db.execSQL("INSERT INTO "+MEMBER_TABLE+"(name,password,email,phone,address,photo) VALUES(\"ariel\""+i+",\"ariel\",\"ariel720@naver.com\",\"01012345678\".\"김포\",\"profileimg\");\n" +
                    "\n");
        }*/
   Log.d("여기","테이블생성");
     /*   int i = 0;
        for(i = 0 ; i<9 ; i++){
            db.execSQL(String.format(
                    "INSERT INTO "+MEMBER_TABLE+"(%s,%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s','%s','%s')",
                    MEMBER_NAME,MEMBER_PASSWORD,MEMBER_EMAIL,MEMBER_PHONE,MEMBER_ADDRESS,MEMBER_PHOTO,"ariel"+i,"ariel","ariel"+i+"@naver.com","01012341234","kimpo","profileimg"
            ));
        }
     Log.d("또여기","9개 생성");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertMember(Member member){

    };
    public Member selectMember(int seq){
        Member member = new Member();
        return member;
    };
    public void deleteMember(Member member){

    };
    public void updateMember(int seq){


    };
    public int countMember(){

        return 0;

    };
    public List<Member> getMembers(int total){

        return null;

    };

}
