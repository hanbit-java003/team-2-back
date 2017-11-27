package com.hanbit.team2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanbit.team2.service.ShowoffService;
import com.hanbit.team2.vo.ShowoffVO;
import com.hanbit.team2.service.FileService;
import com.hanbit.team2.vo.FileVO;

@RestController
@RequestMapping("/api/showoff")
public class ShowoffController {

	@Autowired
	private ShowoffService showoffService;

	@Autowired
	private FileService fileService;

	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping("/list")
	public List<ShowoffVO> getShowOff (@RequestParam("no") int no) {
		return showoffService.getShowoff(no);
	}
	
	@RequestMapping("/detail")
	public List<ShowoffVO> getShowOffDetail (@RequestParam("no") int no) {
		return showoffService.getShowoff(no);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Map save(@RequestParam("title") String title,
			@RequestParam("nickname") String nickname,
			@RequestParam("cont") String cont,
			HttpServletRequest request) {
		
		ShowoffVO showoffVO = new ShowoffVO();
		showoffVO.setTitle(title);
		showoffVO.setNickname(nickname);
		showoffVO.setCont(cont);
		
		if (StringUtils.isEmpty(request.getParameter("no"))) {
			showoffService.addAritcle(showoffVO);
		}
		else {
			int no = Integer.parseInt(request.getParameter("no"));
			showoffVO.setNo(no);
			
			showoffService.editArticle(showoffVO);
		}
		
		Map result = new HashMap();
		result.put("status", "ok");
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map delete(@RequestParam("no") int no) {
		
		showoffService.removeArticle(no);
		
		Map result = new HashMap();
		result.put("status", "ok");
		return result;
	}

}