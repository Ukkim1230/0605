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

    public List<PointInfoVO> selectPointInfoList(PointInfoVO pointInfoVO) {
        return pointInfoMapper.selectPointInfoList(pointInfoVO);
    }
    public PointInfoVO selectPointInfo(int piNum) {
        return pointInfoMapper.selectPointInfo(piNum);
    }
    public int insertPointInfo(PointInfoVO pointInfoVO) {
        return pointInfoMapper.insertPointInfo(pointInfoVO);
    }
    public int updatePointInfo(PointInfoVO pointInfoVO) {
        return pointInfoMapper.updatePointInfo(pointInfoVO);
    }
    public int deletePointInfo(int piNum) {
        return pointInfoMapper.deletePointInfo(piNum);
    }
}