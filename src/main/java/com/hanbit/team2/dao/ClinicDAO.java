package com.hanbit.team2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.ClinicVO;

@Repository
public class ClinicDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<AreaVO> selectArea() {
		return sqlsession.selectList("clinic.selectArea");
	}
	
	public List<ClinicVO> selectClinicList(String areaId) {
		return sqlsession.selectList("clinic.selectClinicList", areaId);
	}
	
	public ClinicVO selectClinic(String id) {
		return sqlsession.selectOne("clinic.selectClinic", id);
	}
}
