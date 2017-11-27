package com.hanbit.team2.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.InfoTipDAO;
import com.hanbit.team2.service.FileService;
import com.hanbit.team2.vo.FileVO;
import com.hanbit.team2.vo.InfoTipVO;


@Service
public class InfoTipService {
	
	@Autowired
	private InfoTipDAO infotipDAO;
	
	@Autowired
	private FileService fileService;
	
	public List<InfoTipVO> getInfotip (int no) {
		return infotipDAO.selectInfotip(no);
	}
	
	public void addAritcle(InfoTipVO infotipVO) {
		int no = infotipDAO.selectNextNo();
		infotipVO.setNo(no);
		
		infotipDAO.insertInfotip(infotipVO);
	}
	
	public void editArticle(InfoTipVO infotipVO) {
		infotipDAO.updateArticle(infotipVO);
	}
	
	@Transactional
	public void removeArticle(int no) {		
		infotipDAO.deleteArticle(no);
	}


}