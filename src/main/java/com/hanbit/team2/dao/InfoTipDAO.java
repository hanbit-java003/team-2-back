package com.hanbit.team2.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.InfoTipVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class InfoTipDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<InfoTipVO> selectInfotip (int no) {
		return sqlSession.selectList("infotip.selectInfotip", no);
	}
	
	public int selectNextNo() {
		return sqlSession.selectOne("infotip.selectNextNo");
	}
	
	public int deleteArticle(int no) {
		return sqlSession.delete("infotip.deleteArticle", no);
	}
	
	public int updateArticle (InfoTipVO infotipVO) {
		return sqlSession.selectOne("infotip.updateArticle", infotipVO);
	}
	
	public int insertInfotip (InfoTipVO infotipVO) {
		return sqlSession.insert("infotip.insertInfotip", infotipVO);
	}



}
