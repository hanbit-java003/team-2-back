package com.hanbit.team2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.service.CafeService;

@RestController
public class CafeController {

	@Autowired
	private CafeService cafeService;
}
