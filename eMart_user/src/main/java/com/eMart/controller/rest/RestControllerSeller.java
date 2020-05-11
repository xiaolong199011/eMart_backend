package com.eMart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eMart.persistence.service.BaseService;
import com.eMart.controller.rest.Result;
import com.eMart.persistence.entity.Seller;
import com.eMart.persistence.service.SellerService;

@RestController
@RequestMapping("/seller")
public class RestControllerSeller {
	
	@Autowired
	private SellerService sellerService;
	
	private BaseService getService() {
		return sellerService;
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Object> getall() {
		return getService().findAll();
	}
	
	@RequestMapping(value = "/getby/{id}", method = RequestMethod.GET)
	public Object getby(@PathVariable long id) {
		return getService().findBy(id);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Seller save (@RequestBody Seller o) {
		return (Seller) getService().save(o);
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
	public Result del(@PathVariable long id) {
		Object u = getService().findBy(id);		
		return getService().delete(u);
	}

}
