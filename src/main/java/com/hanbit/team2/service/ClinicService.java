package com.hanbit.team2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.ClinicDAO;
import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.ClinicVO;

@Service
public class ClinicService {

	@Autowired
	private ClinicDAO clinicDAO;

	public List<AreaVO> listArea() {
		return clinicDAO.selectArea();
	}

	public List<ClinicVO> listClinic(String areaId) {
		return clinicDAO.selectClinicList(areaId);
	}

	public List<ClinicVO> getClinic(String id) {
		return clinicDAO.selectClinic(id);
	}
}
