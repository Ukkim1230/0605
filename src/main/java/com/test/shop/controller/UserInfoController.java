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

    @GetMapping("/user")
    public List<UserInfoVO> getUserList(UserInfoVO user) {
        return userInfoService.selectUserInfoList(user);
    }
    @GetMapping("/user/{uiNum}")
    public UserInfoVO getUser(@PathVariable("uiNum") int uiNum) {
        return userInfoService.selectUserInfo(uiNum);
    }

    @PostMapping("/user")
    public int addUser(@ModelAttribute UserInfoVO userInfoVO) {
        return userInfoService.insertUserInfo(userInfoVO);
    }

    @PutMapping("/user")
    public int updateUser(@RequestBody UserInfoVO userInfoVO) {
        return userInfoService.updateUserInfo(userInfoVO);
    }

    @DeleteMapping("/user/{uiNum}")
    public int deleteUser(@PathVariable int uiNum) {
        return userInfoService.deleteUserInfo(uiNum);
    }
}