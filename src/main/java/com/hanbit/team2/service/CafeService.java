package com.hanbit.team2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.CafeDAO;

@Service
public class CafeService {

	@Autowired
	private CafeDAO cafeDAO;
}
