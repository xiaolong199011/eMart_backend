package com.eMart.feign.clientInterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eMart.feign.model.Result;

@FeignClient(name  = "user-service")
@RequestMapping("buyer")
@ResponseBody
public interface BuyerFeignClientInterface {
	
	@RequestMapping(value = "/getall",method = RequestMethod.GET)
	List<Object> buyerGetAll();
	
	@RequestMapping(value = "/getby/{id}", method = RequestMethod.GET)
	Object buyerGetBy(@PathVariable long id);

	@RequestMapping(value = "/save", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	Object buyerSave (@RequestBody Object o);
	
	@RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
	public Result buyerDel(@PathVariable long id);

}
