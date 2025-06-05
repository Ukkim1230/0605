package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.shop.service.PointInfoService;
import com.test.shop.vo.PointInfoVO;

@RestController
@RequestMapping("/point")
public class PointInfoController {

    @Autowired
    private PointInfoService pointInfoService;

    // 전체 포인트 목록 조회
    @GetMapping("/list")
    public List<PointInfoVO> getPointInfoList() {
        return pointInfoService.selectPointInfoList();
    }

    // 포인트 1건 조회
    @GetMapping("/{piNum}")
    public PointInfoVO getPointInfo(@PathVariable int piNum) {
        return pointInfoService.selectPointInfo(piNum);
    }

    // 포인트 등록
    @PostMapping("/add")
    public int addPointInfo(@RequestBody PointInfoVO pointInfoVO) {
        return pointInfoService.insertPointInfo(pointInfoVO);
    }

    // 포인트 수정
    @PutMapping("/update")
    public int updatePointInfo(@RequestBody PointInfoVO pointInfoVO) {
        return pointInfoService.updatePointInfo(pointInfoVO);
    }

    // 포인트 삭제
    @DeleteMapping("/delete/{piNum}")
    public int deletePointInfo(@PathVariable int piNum) {
        return pointInfoService.deletePointInfo(piNum);
    }
}