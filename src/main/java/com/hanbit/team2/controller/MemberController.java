package com.hanbit.team2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.service.MemberService;
import com.hanbit.team2.vo.MemberVO;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/signup")
	public Map signUp(@RequestParam("email") String email, @RequestParam("password") String password) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setPassword(password);

		memberService.signUp(memberVO);

		Map result = new HashMap();
		result.put("status", "ok");

		return result;
	}
}
