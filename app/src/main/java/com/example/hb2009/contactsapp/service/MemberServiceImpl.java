package com.example.hb2009.contactsapp.service;

import android.content.Context;

import com.example.hb2009.contactsapp.dao.MemberDAO;
import com.example.hb2009.contactsapp.domain.Member;

import java.util.List;

/**
 * Created by hb2009 on 2017-06-03.
 */

public class MemberServiceImpl implements MemberService {

    MemberDAO memberDAO;

    @Override
    public void createDB(Context context) {
        memberDAO = new MemberDAO(context);
    }

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
    public int countMembers() {
        return 0;
    }

    @Override
    public List<Member> getMembers(int total) {
        return null;
    }
}
