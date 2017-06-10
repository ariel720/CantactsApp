package com.example.hb2009.contactsapp.service;

import android.content.Context;

import com.example.hb2009.contactsapp.domain.Member;

import java.util.List;

/**
 * Created by hb2009 on 2017-06-03.
 */

public interface MemberService {

   // public void createDB(Context context);

    public void createMember(Member member);
    public Member getMember(int seq);
    public void removeMember(Member member);
    public void modifyMember(int seq);
    public String existMember(String email,String password);
    public int countMembers();
    public List<Member> getMembers();
}
