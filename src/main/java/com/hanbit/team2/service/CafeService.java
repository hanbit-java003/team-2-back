package com.hanbit.team2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.CafeDAO;
import com.hanbit.team2.vo.AreaVO;
import com.hanbit.team2.vo.CafeVO;

@Service
public class CafeService {

	@Autowired
	private CafeDAO cafeDAO;

	public CafeVO getCafe(String id) {
		CafeVO cafe = cafeDAO.selectCafe(id);
		cafe.setImages(cafeDAO.selectImage(id));
		cafe.setInfo(cafeDAO.selectInfo(id));
		cafe.setLocation(cafeDAO.selectLocation(id));
		cafe.setTraffic(cafeDAO.selectTraffic(id));

		return cafe;
	}

	public List<AreaVO> listArea() {
		return cafeDAO.selectArea();
	}

	public List<CafeVO> listCafe(String areaId) {
		return cafeDAO.selectCafeList(areaId);
	}
}
