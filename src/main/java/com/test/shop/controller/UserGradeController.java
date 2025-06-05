package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.shop.service.UserGradeService;
import com.test.shop.vo.UserGradeVO;

public class UserGradeController {
	@Autowired
	private UserGradeService ugService;

	@GetMapping("/grade")
	public List<UserGradeVO> getGradeList(UserGradeVO grade){
		return ugService.selectUserGradeList(grade);
	}
	
	@GetMapping("/grade/{ugNum}")
	public UserGradeVO getGrade(@PathVariable("ugNum")int ugNum) {
		return ugService.selectUserGrade(ugNum);
	}
	
	@PostMapping("/grade")
	public int joinGrade(@RequestBody UserGradeVO grade) {
		return ugService.insertUserGrade(grade);
	}
	
	@PutMapping("/grade")
	public int updateGrade(@RequestBody UserGradeVO grade) {
		return ugService.updateUserGrade(grade);
	}
	
	@DeleteMapping("/grade/{ugNum}")
	public int deleteGrade(@PathVariable("ugNum")int ugNum) {
		return ugService.deleteUserGrade(ugNum);
	}
}
