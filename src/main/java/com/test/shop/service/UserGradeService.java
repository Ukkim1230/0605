package com.test.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.shop.mapper.UserGradeMapper;
import com.test.shop.vo.UserGradeVO;

public class UserGradeService {
	@Autowired
	private UserGradeMapper ugMapper;
	
	public List<UserGradeVO> selectUserGradeList(UserGradeVO grade){
		return ugMapper.selectUserGradeList(grade);
	}
	public UserGradeVO selectUserGrade(int ugNum) {
		return ugMapper.selectUserGrade(ugNum);
	}
	public int insertUserGrade(UserGradeVO grade) {
		return ugMapper.insertUserGrade(grade);
	}
	public int updateUserGrade(UserGradeVO grade) {
		return ugMapper.updateUserGrade(grade);
	}
	public int deleteUserGrade(int ugNum) {
		return ugMapper.deleteUserGrade(ugNum);
	}
}
