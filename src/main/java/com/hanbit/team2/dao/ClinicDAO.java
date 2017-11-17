package com.hanbit.team2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.ClinicVO;

@Repository
public class ClinicDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ClinicVO selectClinic(String id) {
		return sqlSession.selectOne("clinic.selectClinic", id);
	}
}
