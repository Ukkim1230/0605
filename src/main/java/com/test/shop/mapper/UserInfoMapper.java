package com.test.shop.mapper;

import java.util.List;

import com.test.shop.vo.UserInfoVO;

public interface UserInfoMapper {
	
	public List<UserInfoVO>selectUserInfoList(UserInfoVO user);
	public UserInfoVO selectUserInfo(int uiNum);
	public UserInfoVO selectUserInfoById(String uiId);
	public int insertUserInfo(UserInfoVO user);
	public int updateUserInfo(UserInfoVO user);
	public int deleteUserInfo(int uiNum);

}
