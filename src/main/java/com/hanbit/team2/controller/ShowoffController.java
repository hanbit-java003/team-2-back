package com.hanbit.team2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanbit.team2.service.FileService;
import com.hanbit.team2.service.ShowoffService;
import com.hanbit.team2.vo.FileVO;
import com.hanbit.team2.vo.ShowoffVO;

@RestController
@RequestMapping("/api/showoff")
public class ShowoffController {

	@Autowired
	private ShowoffService showoffService;

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping("/")
	public List<ShowoffVO> getShowOffList () {
		return showoffService.getShowoffList();
	}

	@RequestMapping("/{no}")
	public List<ShowoffVO> getShowOffDetail (@PathVariable("no") int no) {
		return showoffService.getShowoff(no);
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Map save(@RequestParam("model") String model,
			@RequestParam("photos") List<MultipartFile> photos,
			MultipartRequest request) throws Exception {

		ShowoffVO showoffVO = mapper.readValue(model, ShowoffVO.class);

		showoffService.addAritcle(showoffVO, photos);

		Map result = new HashMap();
		result.put("status", "ok");

		return result;

	}


//	public Map save(@RequestParam("title") String title,
//			@RequestParam("nickname") String nickname,
//			@RequestParam("cont") String cont,
//			HttpServletRequest request,
//			MultipartFile image) throws Exception {
//
//		ShowoffVO showoffVO = new ShowoffVO();
//		showoffVO.setTitle(title);
//		showoffVO.setNickname(nickname);
//		showoffVO.setCont(cont);
//		showoffVO.setFileimg(image);
//
//		if (StringUtils.isEmpty(request.getParameter("no"))) {
//			showoffService.addAritcle(showoffVO, image);
//		}
//		else {
//			int no = Integer.parseInt(request.getParameter("no"));
//			showoffVO.setNo(no);
//
//			showoffService.editArticle(showoffVO);
//		}
//
//		Map result = new HashMap();
//		result.put("status", "ok");
//		return result;
//	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map delete(@RequestParam("no") int no) {

		showoffService.removeArticle(no);

		Map result = new HashMap();
		result.put("status", "ok");
		return result;
	}

}