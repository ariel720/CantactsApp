package com.example.hb2009.contactsapp.service;

import android.content.Context;
import android.util.Log;

import com.example.hb2009.contactsapp.dao.MemberDAO;
import com.example.hb2009.contactsapp.domain.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2009 on 2017-06-03.
 */

public class MemberServiceImpl implements MemberService {

    MemberDAO memberDAO;

    public MemberServiceImpl(Context context) {
        this.memberDAO = new MemberDAO(context);
    }

    /*@Override
    public void createDB(Context context)
    {
        memberDAO = new MemberDAO(context);
    }*/

    @Override
    public void createMember(Member member) {

    }

    @Override
    public Member getMember(int seq) {
        return null;
    }

    @Override
    public void removeMember(Member member) {

    }

    @Override
    public void modifyMember(int seq) {

    }

    @Override
    public String existMember(String email,String password) {
       return memberDAO.existeMember(email,password);
    }

    @Override
    public int countMembers() {
        return 0;
    }

    @Override
    public List<Member> getMembers() {
        Log.d("memberimpl","test");
        final ArrayList<Member> list =(ArrayList<Member>)memberDAO.getMembers();
        Log.d("memberimpl",list.get(3).toString());
        return list;
    }
}
