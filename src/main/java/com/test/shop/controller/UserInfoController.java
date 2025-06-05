package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.shop.service.UserInfoService;
import com.test.shop.vo.UserInfoVO;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // 전체 회원 목록 조회
    @GetMapping("/user")
    public List<UserInfoVO> getUserList(UserInfoVO user) {
        return userInfoService.selectUserInfoList(user);
    }

    // 회원 1명 조회
    @GetMapping("/user/{uiNum}")
    public UserInfoVO getUser(@PathVariable("uiNum") int uiNum) {
        return userInfoService.selectUserInfo(uiNum);
    }

    // 회원 등록
    @PostMapping("/user")
    public int addUser(@ModelAttribute UserInfoVO userInfoVO) {
        return userInfoService.insertUserInfo(userInfoVO);
    }

    // 회원 정보 수정
    @PutMapping("/user")
    public int updateUser(@RequestBody UserInfoVO userInfoVO) {
        return userInfoService.updateUserInfo(userInfoVO);
    }

    // 회원 삭제
    @DeleteMapping("/user/{uiNum}")
    public int deleteUser(@PathVariable int uiNum) {
        return userInfoService.deleteUserInfo(uiNum);
    }
}