package com.eMart.controller.rest;

import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eMart.persistence.service.BaseService;
import com.eMart.controller.rest.Result;
import com.eMart.persistence.entity.Buyer;
import com.eMart.persistence.service.BuyerService;
//import com.eMart.untils.JwtUtil;

@RestController
@RequestMapping("/buyer")
public class RestControllerBuyer {
	
	@Autowired
	private BuyerService buyerService;
	
	private BaseService getService() {
		return buyerService;
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	//List<Object>
	public List<Object> getall() {

		return getService().findAll();		
	}
	
	@RequestMapping(value = "/getby/{id}", method = RequestMethod.GET)
	public Object getby(@PathVariable long id) {
		return getService().findBy(id);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Buyer save (@RequestBody Buyer o) {
		return (Buyer) getService().save(o);
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
	public Result del(@PathVariable long id) {
		Object u = getService().findBy(id);		
		return getService().delete(u);
	}

}
