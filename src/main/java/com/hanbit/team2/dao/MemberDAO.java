package com.hanbit.team2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlsession;

	public int insertMember(MemberVO memberVO) {
		return sqlsession.insert("member.insertMember", memberVO);
	}

	public int countMember(String email) {
		return sqlsession.selectOne("member.countMember", email);
	}
}
