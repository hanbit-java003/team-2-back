package com.hanbit.team2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.service.ClinicService;
import com.hanbit.team2.vo.ClinicVO;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

	@RequestMapping("/{clinicsId")
	public ClinicVO getClinic(@PathVariable("clinicsId") String clinicsId) {
		
		ClinicVO clinic = new ClinicVO();
		clinic.setArea("서울시");
		clinic.setName("송파구");
		clinic.setClinicname("잠실종합동물병원");
		clinic.setLat(37.5023506);
		clinic.setLng(127.11023620000003);
		clinic.setTelephone(02-415-7585);
		clinic.setAddress("서울특별시 송파구 송파대로 388 창영빌딩 1층");
		
		return ClinicService.getClinic(clinicsId);
		

	}
	
}
