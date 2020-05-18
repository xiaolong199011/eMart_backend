package com.eMart.feign.clientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eMart.feign.clientInterface.BuyerFeignClientInterface;
import com.eMart.feign.model.Result;

public class BuyerFeignClientService {
	
	@Autowired 
	private BuyerFeignClientInterface buyerFeignClientInterface;

    public List<Object> getall(){
        return buyerFeignClientInterface.buyerGetAll();
    }
    
    public Object getby(long id) {
    	return buyerFeignClientInterface.buyerGetBy(id);
    }
    
	Object save (@RequestBody Object o) {
		return buyerFeignClientInterface.buyerSave(o);
	}
	
	public Result buerDel(@PathVariable long id) {	
		return buyerFeignClientInterface.buyerDel(id);
	}

}
