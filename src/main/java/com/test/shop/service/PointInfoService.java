package com.test.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.shop.mapper.PointInfoMapper;
import com.test.shop.vo.PointInfoVO;

@Service
public class PointInfoService {

    @Autowired
    private PointInfoMapper pointInfoMapper;

    public List<PointInfoVO> selectPointInfoList() {
        return pointInfoMapper.selectPointInfoList();
    }

    public PointInfoVO selectPointInfo(int piNum) {
        return pointInfoMapper.selectPointInfo(piNum);
    }

    // 포인트 등록
    public int insertPointInfo(PointInfoVO pointInfoVO) {
        return pointInfoMapper.insertPointInfo(pointInfoVO);
    }

    // 포인트 수정
    public int updatePointInfo(PointInfoVO pointInfoVO) {
        return pointInfoMapper.updatePointInfo(pointInfoVO);
    }

    // 포인트 삭제
    public int deletePointInfo(int piNum) {
        return pointInfoMapper.deletePointInfo(piNum);
    }
}