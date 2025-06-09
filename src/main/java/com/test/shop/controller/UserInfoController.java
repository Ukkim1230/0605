package com.test.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user-infos")
@RequiredArgsConstructor
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public List<UserInfoVO> getUserList(UserInfoVO user) {
        return userInfoService.selectUserInfoList(user);
    }
    @GetMapping("/{uiNum}")
    public UserInfoVO getUser(@PathVariable("uiNum") int uiNum) {
        return userInfoService.selectUserInfo(uiNum);
    }
    
    @GetMapping("/id/{uiId}")
    public ResponseEntity<UserInfoVO> getUserInfoById(@PathVariable String uiId) {
        return ResponseEntity.ok(userInfoService.selectUserInfoById(uiId));
    }
    
    @PostMapping("/login")
    public UserInfoVO login(@RequestBody UserInfoVO userInfo, HttpSession session) {
    	
    	return userInfoService.login(userInfo, session);
    }
    
    @PostMapping
    public int addUser(@ModelAttribute UserInfoVO userInfoVO) {
        return userInfoService.insertUserInfo(userInfoVO);
    }

    @PutMapping("/{uiNum}")
    public int updateUser(@RequestBody UserInfoVO userInfoVO) {
        return userInfoService.updateUserInfo(userInfoVO);
    }

    @DeleteMapping("/{uiNum}")
    public int deleteUser(@PathVariable int uiNum) {
        return userInfoService.deleteUserInfo(uiNum);
    }
}