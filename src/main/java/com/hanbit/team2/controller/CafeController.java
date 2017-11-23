package com.hanbit.team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.service.CafeService;
import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.CafeVO;

@RestController
@RequestMapping("/api/cafe")
public class CafeController {

	@Autowired
	private CafeService cafeService;

	@RequestMapping("/{cafeId}")
	public CafeVO getCafe(@PathVariable("cafeId") String cafeId) {
		return cafeService.getCafe(cafeId);
	}

	@RequestMapping("/area")
	public List<AreaVO> listArea() {
		return cafeService.listArea();
	}

	@RequestMapping("/list")
	public List<CafeVO> listCafe(@RequestParam("areaId") String areaId) {
		return cafeService.listCafe(areaId);
	}
}
