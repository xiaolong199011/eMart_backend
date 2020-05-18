package com.eMart.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eMart.model.User;
import com.eMart.model.UserResponse;
import com.eMart.persistence.service.UserService;

/**
 * Created by Administrator on 2018/1/27.
 */
@RestController
@RequestMapping("/unknownUser")
public class RestControllerUser {

	@Autowired
	private UserService userService;
	

	// 注册或登录
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public UserResponse login(@RequestBody User user) {

		return userService.usercheckService(user);
	}

}
