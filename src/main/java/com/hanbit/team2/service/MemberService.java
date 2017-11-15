package com.hanbit.team2.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanbit.team2.dao.MemberDAO;
import com.hanbit.team2.vo.MemberVO;

@Service
public class MemberService {

	private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	@Autowired
	private MemberDAO memberDAO;

	public void signUp(MemberVO memberVO) {
		if (memberDAO.countMember(memberVO.getEmail()) > 0) {
			throw new RuntimeException("이메일 중복입니다");
		}

		memberVO.setUid(generateUid());

		//패스워드 암호화
		PasswordEncoder passwordEncoder = new StandardPasswordEncoder("animalgo");
		String encodePassword = passwordEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(encodePassword);

		memberDAO.insertMember(memberVO);
	}

	public String generateUid() {
		int length = 12;
		char[] uid = new char[length];

		Random random = new Random();

		for (int i=0; i<length; i++) {
			uid[i] = CHARS[random.nextInt(CHARS.length)];
		}
		return new String(uid);
	}
}
