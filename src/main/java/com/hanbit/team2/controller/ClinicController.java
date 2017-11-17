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
		clinic.setName("강남구");
		clinic.setClinicname("청담우리동물병원");
		clinic.setLat(37.5144538);
		clinic.setLng(127.05284129999995);
		clinic.setTelephone(02-541-7515);
		clinic.setAddress("서울 강남구 삼성로 614");
		
		return ClinicService.getClinic(clinicsId);
		

	}
	
}
