package com.test.shop.mapper;

import java.util.List;

import com.test.shop.vo.PointInfoVO;

public interface PointInfoMapper {
	public List<PointInfoVO> selectPointInfoList();
	public PointInfoVO selectPointInfo(int piNum);
    public int insertPointInfo(PointInfoVO pointInfoVO);
    public int updatePointInfo(PointInfoVO pointInfoVO);
    public int deletePointInfo(int piNum);
   
}
