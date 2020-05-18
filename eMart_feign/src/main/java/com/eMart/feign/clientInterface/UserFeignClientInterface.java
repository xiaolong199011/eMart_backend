package com.eMart.feign.clientInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eMart.feign.model.User;
import com.eMart.feign.model.UserResponse;

@FeignClient(name  = "user-service")
@RequestMapping("unknownUser")
@ResponseBody
public interface UserFeignClientInterface {

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	UserResponse login(@RequestBody User user);
}
