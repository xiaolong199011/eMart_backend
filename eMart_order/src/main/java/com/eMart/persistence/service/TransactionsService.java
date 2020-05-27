package com.eMart.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.TransactionsDao;
import com.eMart.persistence.entity.Transactions;
import com.eMart.persistence.model.ItemFileInfoModel;
import com.eMart.persistence.model.TransactionItemModel;
import com.eMart.persistence.service.BaseService;

@Service("TransactionsService")
@Transactional
public class TransactionsService extends BaseService{
	
	private String ItemFileInfoGetModelByUrl = "http://items-service/item/getmodelby/"; 

	@Autowired
	private TransactionsDao transactionsDao;	
	
	@Autowired
	private RestTemplate restTemplate;
	

//	List<TransactionItemModel> TransactionItemModels = new ArrayList<>();
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return transactionsDao;
	}
	
	public List<TransactionItemModel> getCart(String buyerid){
		
		
		
		
		List<Transactions> transactions = new ArrayList<>();
		List<TransactionItemModel> TransactionItemModelList = new ArrayList<>();
		List<Object> TransactionsObjects = transactionsDao.findByTwoCondition("buyerid", buyerid, "shopcart", "1");
		for(Object transactionsObject:TransactionsObjects) {
			Transactions transaction = new Transactions();
			 transaction = (Transactions)transactionsObject;
			 TransactionItemModel transactionItemModel = new TransactionItemModel();
			 transactionItemModel.setId(transaction.getId());
			 transactionItemModel.setBuyerid(transaction.getBuyerid());
			 transactionItemModel.setShopcart(transaction.getShopcart());
			 transactionItemModel.setTransactiontype(transaction.getTransactiontype());
			 transactionItemModel.setDatetime(transaction.getDatetime());
			 
			 String itemId = String.valueOf(transaction.getItemid());
			 
			 ResponseEntity<ItemFileInfoModel> itemFileInfoResponseEntity=restTemplate.getForEntity(ItemFileInfoGetModelByUrl+itemId, ItemFileInfoModel.class);
			 itemFileInfoResponseEntity.getBody().getItemname();
			 
			 
			 transactionItemModel.setItemname(itemFileInfoResponseEntity.getBody().getItemname());
			 transactionItemModel.setCategoryid(itemFileInfoResponseEntity.getBody().getCategoryid());
			 transactionItemModel.setSubcategoryid(itemFileInfoResponseEntity.getBody().getSubcategoryid());
			 transactionItemModel.setPrice(itemFileInfoResponseEntity.getBody().getPrice());
			 transactionItemModel.setDescription(itemFileInfoResponseEntity.getBody().getDescription());
			 transactionItemModel.setStocknumber(itemFileInfoResponseEntity.getBody().getStocknumber());
			 transactionItemModel.setSellerid(itemFileInfoResponseEntity.getBody().getSellerid());
			 transactionItemModel.setFilename(itemFileInfoResponseEntity.getBody().getFilename());
			 TransactionItemModelList.add(transactionItemModel);
		}
		
		return TransactionItemModelList;
	}
	
	public void checkoutCart(String buyerid){
		List<Object>  transactionsListObject=transactionsDao.findByTwoCondition("buyerid", buyerid, "shopcart", "1");
		for(Object transactionObject :transactionsListObject) {
			Transactions transaction = new Transactions();
			transaction = (Transactions)transactionObject;
			transaction.setShopcart(0);
			transactionsDao.save(transaction);
		}
		
	}
	
	public List<TransactionItemModel> purchaseHistory(String buyerid){
		List<Object>  transactionsObjects=transactionsDao.findByTwoCondition("buyerid", buyerid, "shopcart", "0");
		List<Transactions> transactions = new ArrayList<>();
		List<TransactionItemModel> TransactionItemModels = new ArrayList<>();
		TransactionItemModel transactionItemModel = new TransactionItemModel();
		for(Object transactionsObject:transactionsObjects) {
			Transactions transaction = new Transactions();
			 transaction = (Transactions)transactionsObject;
			 transactionItemModel.setId(transaction.getId());
			 transactionItemModel.setBuyerid(transaction.getBuyerid());
			 transactionItemModel.setShopcart(transaction.getShopcart());
			 transactionItemModel.setTransactiontype(transaction.getTransactiontype());
			 transactionItemModel.setDatetime(transaction.getDatetime());
			 
			 String itemId = String.valueOf(transaction.getItemid());
			 
			 ResponseEntity<ItemFileInfoModel> itemFileInfoResponseEntity=restTemplate.getForEntity(ItemFileInfoGetModelByUrl+itemId, ItemFileInfoModel.class);
			 itemFileInfoResponseEntity.getBody().getItemname();
			 
			 
			 transactionItemModel.setItemname(itemFileInfoResponseEntity.getBody().getItemname());
			 transactionItemModel.setCategoryid(itemFileInfoResponseEntity.getBody().getCategoryid());
			 transactionItemModel.setSubcategoryid(itemFileInfoResponseEntity.getBody().getSubcategoryid());
			 transactionItemModel.setPrice(itemFileInfoResponseEntity.getBody().getPrice());
			 transactionItemModel.setDescription(itemFileInfoResponseEntity.getBody().getDescription());
			 transactionItemModel.setStocknumber(itemFileInfoResponseEntity.getBody().getStocknumber());
			 transactionItemModel.setSellerid(itemFileInfoResponseEntity.getBody().getSellerid());
			 transactionItemModel.setFilename(itemFileInfoResponseEntity.getBody().getFilename());
			 TransactionItemModels.add(transactionItemModel);
		}
		return TransactionItemModels;
		
	}
	
}
