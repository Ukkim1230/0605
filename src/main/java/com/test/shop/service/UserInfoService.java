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
import com.test.shop.util.SHA256Util;
import com.test.shop.vo.PointInfoVO;
import com.test.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpSession;

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
	
	public UserInfoVO selectUserInfoById(String uiId) {
		return uiMapper.selectUserInfoById(uiId);
	}
	public UserInfoVO login(UserInfoVO user, HttpSession session) {
		UserInfoVO dbUser = uiMapper.selectUserInfoById(user.getUiId());
		String password = SHA256Util.encodePassword(user.getUiPwd());
		if(!dbUser.getUiPwd().equals(password)) {
			throw new RuntimeException("아이디나 비밀번호를 확인해주세요");
		}
		session.setAttribute("user", dbUser);
		dbUser.setUiPwd("");
		return dbUser;
	}
	@Transactional
	public int insertUserInfo(UserInfoVO user) {
		//사용자가 입력한 아이디로 검색하는 MAPPER SQL이 존재해야하고
		//아이디로 검색했을때 무언가가 존재할경우
		//Exception처리 해줘야함
		MultipartFile uiProfile = user.getUiProfile();
		String fileName = uiProfile.getOriginalFilename();
		int idx = fileName.lastIndexOf(".");
		if(uiMapper.selectUserInfoById(user.getUiId())!=null) {
			throw new RuntimeException("이미 존재하는 아이디입니다.");
		}
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
		user.setUiPwd(SHA256Util.encodePassword(user.getUiPwd()));
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
