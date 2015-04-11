package com.sprhib.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Member;
@Transactional
public interface MemberDAO {
	
	public int addMember(Member member);
	public void updateMember(Member member);
	public Member getMember(int id);
	public void deleteMember(int id);
	public List<Member> getMembers();

}
