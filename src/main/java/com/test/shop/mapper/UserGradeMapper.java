package com.test.shop.mapper;

import java.util.List;

import com.test.shop.vo.UserGradeVO;

public interface UserGradeMapper {
	List<UserGradeVO> selectUserGradeList (UserGradeVO grade);
	UserGradeVO selectUserGrade (int ugNum);
	int insertUserGrade (UserGradeVO grade);
	int updateUserGrade (UserGradeVO grade);
	int deleteUserGrade (int ugNum);
}
