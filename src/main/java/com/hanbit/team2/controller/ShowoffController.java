package com.hanbit.team2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
}
