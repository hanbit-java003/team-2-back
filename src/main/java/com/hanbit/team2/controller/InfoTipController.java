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
import com.hanbit.team2.service.InfoTipService;
import com.hanbit.team2.vo.InfoTipVO;
import com.hanbit.team2.service.FileService;
import com.hanbit.team2.vo.FileVO;

@RestController
@RequestMapping("/api/infotip")
public class InfoTipController {

	@Autowired
	private InfoTipService infotipService;

	@Autowired
	private FileService fileService;

	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping("/list")
	public List<InfoTipVO> getInfotip (@RequestParam("no") int no) {
		return infotipService.getInfotip(no);
	}
	
	@RequestMapping("/detail")
	public List<InfoTipVO> getInfotipDetail (@RequestParam("no") int no) {
		return infotipService.getInfotip(no);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Map save(@RequestParam("title") String title,
			@RequestParam("nickname") String nickname,
			@RequestParam("cont") String cont,
			HttpServletRequest request) {
		
		InfoTipVO infotipVO = new InfoTipVO();
		infotipVO.setTitle(title);
		infotipVO.setNickname(nickname);
		infotipVO.setCont(cont);
		
		if (StringUtils.isEmpty(request.getParameter("no"))) {
			infotipService.addAritcle(infotipVO);
		}
		else {
			int no = Integer.parseInt(request.getParameter("no"));
			infotipVO.setNo(no);
			
			infotipService.editArticle(infotipVO);
		}
		
		Map result = new HashMap();
		result.put("status", "ok");
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map delete(@RequestParam("no") int no) {
		
		infotipService.removeArticle(no);
		
		Map result = new HashMap();
		result.put("status", "ok");
		return result;
	}

}