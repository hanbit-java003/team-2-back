package com.hanbit.team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.service.ClinicService;
import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.ClinicVO;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@RequestMapping("/area")
	public List<AreaVO> listArea() {
		return clinicService.listArea();
	}

	@RequestMapping("/list")
	public List<ClinicVO> listClinic(@RequestParam("areaId") String areaId) {
		return clinicService.listClinic(areaId);
	}

	@RequestMapping("/{clinicId}")
	public List<ClinicVO> getClinic(@PathVariable("clinicId") String id) {
		return clinicService.getClinic(id);
	}
}
