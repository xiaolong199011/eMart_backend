package com.eMart.model;


import com.eMart.model.BaseResponse;


public class UserResponse extends BaseResponse{
	
    private long id;
    
    private String userName;
    
    private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    

   


}
