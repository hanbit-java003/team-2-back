package com.hanbit.team2.service;

import java.io.IOException;
import java.util.ArrayList;
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

	public List<ShowoffVO> getShowoffList () {
		return showoffDAO.selectShowoffList();
	}

	public List<ShowoffVO> getShowoff(int no) {
		return showoffDAO.selectShowoff(no);
	}

	@SuppressWarnings("null")
	public void addAritcle(ShowoffVO showoffVO, List<MultipartFile> photos) throws IOException {
		int no = showoffDAO.selectNextNo();
		showoffVO.setNo(no);

		List<String> imgList = new ArrayList();

		for (int i=0; i<photos.size(); i++) {
			MultipartFile image = photos.get(i);

			String fileName = showoffVO.getTitle() + "_";
			String fileExt = FilenameUtils.getExtension(image.getOriginalFilename());
			String fileId = "showoff-" + no + fileName;
			String filePath = "/hanbit/webpack/animalgo/team-2-front/src/img/showoff" + fileName + "." + fileExt;

			FileVO fileVO = new FileVO();
			fileVO.setFileId(fileId);
			fileVO.setFileName(image.getOriginalFilename());
			fileVO.setFilePath(filePath);
			fileVO.setContentType(image.getContentType());
			fileVO.setContentLength(image.getSize());

			fileService.addFile(fileVO, image.getInputStream());
			String fileUrl = "/api/file" + fileId;
			imgList.add(fileUrl);
		}

		showoffVO.setFileimg(imgList);
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