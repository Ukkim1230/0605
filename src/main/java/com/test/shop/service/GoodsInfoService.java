package com.test.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.shop.mapper.GoodsInfoMapper;
import com.test.shop.util.FileUtils;
import com.test.shop.vo.GoodsInfoVO;

@Service
public class GoodsInfoService {
	@Value("${file.upload.path}")
	private String fileUploadPath;
	
	@Autowired
	private GoodsInfoMapper gdMapper;
	@Autowired
	private FileUtils fileUtils;
	
	public List<GoodsInfoVO> selectGoodsInfoList(GoodsInfoVO goods){
		return gdMapper.selectGoodsInfoList(goods);
	}
	public GoodsInfoVO selectGoodsInfo(int giNum){
		return gdMapper.selectGoodsInfo(giNum);
	}
	@Transactional
	public int insertGoodsInfo(GoodsInfoVO goods) {
		String giMainImg = fileUtils.saveFile(goods.getGiMain(),"goods-imgs");
		goods.setGiMainImg(giMainImg);
		String giSubImg1 = fileUtils.saveFile(goods.getGiSub1(),"goods-imgs");
		goods.setGiSubImg1(giSubImg1);
		String giSubImg2 = fileUtils.saveFile(goods.getGiSub2(),"goods-imgs");
		goods.setGiSubImg2(giSubImg2);
		String giSubImg3 = fileUtils.saveFile(goods.getGiSub3(),"goods-imgs");
		goods.setGiSubImg3(giSubImg3);
		String giSubImg4 = fileUtils.saveFile(goods.getGiSub4(),"goods-imgs");
		goods.setGiSubImg4(giSubImg4);
		String giSubImg5 = fileUtils.saveFile(goods.getGiSub5(),"goods-imgs");
		goods.setGiSubImg5(giSubImg5);
		return gdMapper.insertGoodsInfo(goods);
	}
	
	public int insertGoodsInfo2(GoodsInfoVO goods) {
		String giMainImg = fileUtils.saveFile(goods.getGiMain(),"goods-imgs");
		goods.setGiMainImg(giMainImg);
		List<MultipartFile> subImgsList = goods.getGiSubList();
		if(subImgsList!=null && !subImgsList.isEmpty()) {
			for(int i=0;i<subImgsList.size();i++) {
				MultipartFile file = subImgsList.get(i);
				String giSubImg = fileUtils.saveFile(file, "goods-sub-imgs");
				if(i==0) {
					goods.setGiSubImg1(giSubImg);
				}
				if(i==1) {
					goods.setGiSubImg2(giSubImg);
				}
				if(i==2) {
					goods.setGiSubImg3(giSubImg);
				}
				if(i==3) {
					goods.setGiSubImg4(giSubImg);
				}
				if(i==4) {
					goods.setGiSubImg5(giSubImg);
				}
				
			}
		}
		return gdMapper.insertGoodsInfo(goods);
	}
	public int updateGoodsInfo(GoodsInfoVO goods) {
		return gdMapper.updateGoodsInfo(goods);
	}
	public int deleteGoodsInfo(int giNum) {
		return gdMapper.deleteGoodsInfo(giNum);
	}
}
