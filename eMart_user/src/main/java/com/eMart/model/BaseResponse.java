package com.eMart.model;

public class BaseResponse {

	private long id;

	private long errornum;

	private String errormsg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getErrornum() {
		return errornum;
	}

	public void setErrornum(long errornum) {
		this.errornum = errornum;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
