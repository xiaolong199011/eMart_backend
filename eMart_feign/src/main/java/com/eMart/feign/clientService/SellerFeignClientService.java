package com.eMart.feign.clientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eMart.feign.clientInterface.SellerFeignClientInterface;
import com.eMart.feign.model.Result;
import com.eMart.feign.clientInterface.BuyerFeignClientInterface;

public class SellerFeignClientService {
	
	@Autowired 
	private SellerFeignClientInterface sellerFeignClientInterface;

    public List<Object> getall(){
        return sellerFeignClientInterface.sellerGetAll();
    }
    
    public Object getby(long id) {
    	return sellerFeignClientInterface.sellerGetBy(id);
    }
    
	Object save (@RequestBody Object o) {
		return sellerFeignClientInterface.sellerSave(o);
	}
	
	public Result buerDel(@PathVariable long id) {	
		return sellerFeignClientInterface.sellerDel(id);
	}

}
