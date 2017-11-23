package com.hanbit.team2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.CafeVO;
import com.hanbit.team2.vo.ImagesVO;
import com.hanbit.team2.vo.InfoVO;
import com.hanbit.team2.vo.LocationVO;
import com.hanbit.team2.vo.TrafficVO;

@Repository
public class CafeDAO {

	@Autowired
	private SqlSession sqlsession;

	public CafeVO selectCafe(String id) {
		return sqlsession.selectOne("cafe.selectCafe", id);
	}

	public List<ImagesVO> selectImage(String id) {
		return sqlsession.selectList("cafe.selectImages", id);
	}

	public List<InfoVO> selectInfo(String id) {
		return sqlsession.selectList("cafe.selectInfo", id);
	}

	public LocationVO selectLocation(String id) {
		return sqlsession.selectOne("cafe.selectLocation", id);
	}

	public TrafficVO selectTraffic(String id) {
		return sqlsession.selectOne("cafe.selectTraffic", id);
	}

	public List<AreaVO> selectArea() {
		return sqlsession.selectList("cafe.selectArea");
	}

	public List<CafeVO> selectCafeList(String areaId) {
		return sqlsession.selectList("cafe.selectCafeList", areaId);
	}
}
