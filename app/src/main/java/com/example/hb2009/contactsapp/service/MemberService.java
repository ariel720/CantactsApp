package com.example.hb2009.contactsapp.service;

import com.example.hb2009.contactsapp.domain.Member;

import java.util.List;

/**
 * Created by hb2009 on 2017-06-03.
 */

public interface MemberService {
    public void createMember(Member member);
    public Member getMember(int seq);
    public void removeMember(Member member);
    public void modifyMember(int seq);
    public int countMembers();
    public List<Member> getMembers(int total);
}
