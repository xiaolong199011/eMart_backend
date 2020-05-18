package com.eMart.feign.clientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eMart.feign.clientInterface.UserFeignClientInterface;
import com.eMart.feign.model.User;
import com.eMart.feign.model.UserResponse;

public class UserFeignClientService {
	
	@Autowired 
	private UserFeignClientInterface userFeignClientInterface;
	
    public UserResponse login(User user){
        return userFeignClientInterface.login(user);
    }

}
