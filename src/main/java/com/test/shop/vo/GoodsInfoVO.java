package com.test.shop.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsInfoVO {
	
	private int giNum;
	private String giName;
	private String giDesc;
	private int giPrice;
	private String giMainImg;
	private MultipartFile giMain;
	private List<MultipartFile> giSubList;
	private String giSubImg1;
	private String giSubImg2;
	private String giSubImg3;
	private String giSubImg4;
	private String giSubImg5;
	private MultipartFile giSub1;
	private MultipartFile giSub2;
	private MultipartFile giSub3;
	private MultipartFile giSub4;
	private MultipartFile giSub5;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;

}
