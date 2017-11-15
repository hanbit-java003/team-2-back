package com.hanbit.team2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public Map signUp(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("nickname") String nickname) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setNickname(nickname);

		memberService.signUp(memberVO);

		Map result = new HashMap();
		result.put("status", "ok");

		return result;
	}

	@PostMapping("/login")
	public Map logIn(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session) {

		MemberVO memberVO = memberService.logIn(email, password);

		session.setAttribute("login", true);
		session.setAttribute("uid", memberVO.getUid());
		session.setAttribute("email", memberVO.getEmail());
		session.setAttribute("nickname", memberVO.getNickname());

		Map result = new HashMap();
		result.put("email", memberVO.getEmail());

		return result;
	}

	@RequestMapping("/get")
	public Map getMember(HttpSession session) {
		Map member = new HashMap();

		if (session.getAttribute("login") == null) {
			member.put("login", false);
		}
		else {
			member.put("login", true);
			member.put("email", session.getAttribute("email"));
			member.put("nickname", session.getAttribute("nickname"));
		}
		return member;
	}

	@RequestMapping("/logout")
	public Map logOut(HttpSession session) {
		session.invalidate();

		Map result = new HashMap();
		result.put("status", "ok");

		return result;
	}
}
