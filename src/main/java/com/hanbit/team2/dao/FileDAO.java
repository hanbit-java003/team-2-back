package com.hanbit.team2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team2.vo.FileVO;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession sqlSession;

	public FileVO selectFile(String fileId) {
		return sqlSession.selectOne("fileimg.selectFile", fileId);
	}

	public int insertFile(FileVO fileVO) {
		return sqlSession.insert("fileimg.insertFile", fileVO);
	}

	public int replaceFile(FileVO fileVO) {
		return sqlSession.insert("fileimg.replaceFile", fileVO);
	}

	public int deleteFile(String fileId) {
		return sqlSession.delete("fileimg.deleteFile", fileId);
	}

}