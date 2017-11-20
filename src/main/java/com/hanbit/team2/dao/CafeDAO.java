package com.hanbit.team2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeDAO {

	@Autowired
	private SqlSession sqlsession;
}
