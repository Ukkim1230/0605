package com.test.shop.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.shop.mapper.PointInfoMapper;
import com.test.shop.mapper.UserInfoMapper;
import com.test.shop.vo.PointInfoVO;
import com.test.shop.vo.UserInfoVO;

@Service
public class UserInfoService {
	@Value("${file.upload.path}")
	private String fileUploadPath;

	@Autowired
	private UserInfoMapper uiMapper;
	@Autowired
	private PointInfoMapper piMapper;

	public List<UserInfoVO> selectUserInfoList(UserInfoVO user) {
		return uiMapper.selectUserInfoList(user);
	}

	public UserInfoVO selectUserInfo(int uiNum) {
		return uiMapper.selectUserInfo(uiNum);
	}

	@Transactional
	public int insertUserInfo(UserInfoVO user) {
		MultipartFile uiProfile = user.getUiProfile();
		String fileName = uiProfile.getOriginalFilename();
		int idx = fileName.lastIndexOf(".");
		String extName = fileName.substring(idx);
		String uiProfileImg = UUID.randomUUID().toString() + extName;
		File f = new File(fileUploadPath + uiProfileImg);
		try {
			uiProfile.transferTo(f);
			user.setUiProfileImg(uiProfileImg);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int result = uiMapper.insertUserInfo(user);
		PointInfoVO pointInfoVO = new PointInfoVO();
		pointInfoVO.setUiNum(user.getUiNum());
		pointInfoVO.setPtType("1");
		piMapper.insertPointInfo(pointInfoVO);
		return result;
	}

	public int updateUserInfo(UserInfoVO user) {
		return uiMapper.updateUserInfo(user);
	}

	public int deleteUserInfo(int uiNum) {
		return uiMapper.deleteUserInfo(uiNum);
	}

}
