package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.shop.service.GoodsInfoService;
import com.test.shop.vo.GoodsInfoVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GoodsInfoController {
	
	@Autowired
	private GoodsInfoService gdService;
	
	@GetMapping("/goods/insert")
    public String showInsertForm() {
        return "views/goods/insert";
    }
	
	@GetMapping("/goods-infos")
	@ResponseBody
	public List<GoodsInfoVO> selectGoodsInfoList(GoodsInfoVO goods){
		return gdService.selectGoodsInfoList(goods);
	}
	@GetMapping("/goods-infos/{giNum}")
	@ResponseBody
	public GoodsInfoVO selectGoodsInfo(@PathVariable("giNum")int giNum) {
		return gdService.selectGoodsInfo(giNum);
	}
	@PostMapping("/goods-infos")
	@ResponseBody
	public int insertGoodsInfo(@ModelAttribute GoodsInfoVO goods){
		return gdService.insertGoodsInfo(goods);
	}
	@PostMapping("/goods-infos2")
	@ResponseBody
	public int insertGoodsInfo2(@ModelAttribute GoodsInfoVO goods){
		return gdService.insertGoodsInfo2(goods);
	}
	@PutMapping("/goods-infos")
	@ResponseBody
	public int updateGoodsInfo(@RequestBody GoodsInfoVO goods) {
		return gdService.updateGoodsInfo(goods);
	}
	@DeleteMapping("/goods-infos/{giNum}")
	@ResponseBody
	public int deleteGoodsInfo(@PathVariable int giNum) {
		return gdService.deleteGoodsInfo(giNum);
	}

}
