package com.hanbit.team2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.ClinicDAO;
import com.hanbit.team2.vo.ClinicVO;

@Service
public class ClinicService {

	@Autowired
	private static ClinicDAO clinicDAO;
	
	public static ClinicVO getClinic(String id) {
		ClinicVO clinic = clinicDAO.selectClinic(id);
	
		return clinic;
	}

	
	

	
}
