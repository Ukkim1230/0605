package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.shop.service.PointInfoService;
import com.test.shop.vo.PointInfoVO;

@RestController
public class PointInfoController {

	@Autowired
	private PointInfoService piService;

	@GetMapping("/point")
	public List<PointInfoVO> getPointList(PointInfoVO point){
		return piService.selectPointInfoList(point);
	}
	
	@GetMapping("/point/{piNum}")
	public PointInfoVO getPoint(@PathVariable("uiNum")int piNum) {
		return piService.selectPointInfo(piNum);
	}
	
	@PostMapping("/point")
	public int addPoint(@RequestBody PointInfoVO point) {
		return piService.insertPointInfo(point);
	}
	
	@PutMapping("/point")
	public int modifyPoint(@RequestBody PointInfoVO point) {
		return piService.updatePointInfo(point);
	}
	
	@DeleteMapping("/point/{piNum}")
	public int removePoint(@PathVariable("uiNum")int piNum) {
		return piService.deletePointInfo(piNum);
	}
}