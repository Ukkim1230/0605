package com.test.shop.mapper;

import java.util.List;

import com.test.shop.vo.GoodsInfoVO;

public interface GoodsInfoMapper {
	
	List<GoodsInfoVO> selectGoodsInfoList(GoodsInfoVO goods);
	GoodsInfoVO selectGoodsInfo(int giNum);
	int insertGoodsInfo(GoodsInfoVO goods);
	int updateGoodsInfo(GoodsInfoVO goods);
	int deleteGoodsInfo(int giNum);
}
