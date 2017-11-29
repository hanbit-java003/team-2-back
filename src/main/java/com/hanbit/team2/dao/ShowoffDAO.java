package com.hanbit.team2.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.ShowoffVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ShowoffDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<ShowoffVO> selectShowoffList() {
		return sqlSession.selectList("showoff.selectShowoffList");
	}

	public List<ShowoffVO> selectShowoff (int no) {
		return sqlSession.selectList("showoff.selectShowoff", no);
	}

	public int selectNextNo() {
		return sqlSession.selectOne("showoff.selectNextNo");
	}

	public int deleteArticle(int no) {
		return sqlSession.delete("showoff.deleteArticle", no);
	}

	public int updateArticle (ShowoffVO showoffVO) {
		return sqlSession.selectOne("showoff.updateArticle", showoffVO);
	}

	public int insertShowoff (ShowoffVO showoffVO) {
		return sqlSession.insert("showoff.insertShowoff", showoffVO);
	}

}
