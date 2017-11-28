package com.hanbit.team2.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.ShowoffDAO;
import com.hanbit.team2.service.FileService;
import com.hanbit.team2.vo.FileVO;
import com.hanbit.team2.vo.ShowoffVO;


@Service
public class ShowoffService {

	@Autowired
	private ShowoffDAO showoffDAO;

	@Autowired
	private FileService fileService;

	public List<ShowoffVO> getShowoff (int no) {
		return showoffDAO.selectShowoff(no);
	}

	public void addAritcle(ShowoffVO showoffVO, MultipartFile image) throws IOException {
		int no = showoffDAO.selectNextNo();
		showoffVO.setNo(no);

		FileVO fileVO = new FileVO();

		String fileId = "showoff-" + showoffVO.getNo() + showoffVO.getDate();
		fileVO.setFileId(fileId);

		String fileExt = FilenameUtils.getExtension(image.getOriginalFilename());
		String fileName = showoffVO.getNo() + showoffVO.getDate() + "." + fileExt;
		fileVO.setFileName(fileName);
		fileVO.setFilePath("/hanbit/webpack/animalgo/team-2-front/src/img/showoff" + fileName);

		fileVO.setContentType(image.getContentType());
		fileVO.setContentLength(image.getSize());

		fileService.modifyFile(fileVO, image.getInputStream(), 200);

		showoffDAO.insertShowoff(showoffVO);
	}

	public void editArticle(ShowoffVO showoffVO) {
		showoffDAO.updateArticle(showoffVO);
	}

	@Transactional
	public void removeArticle(int no) {
		showoffDAO.deleteArticle(no);
	}


}