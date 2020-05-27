package com.eMart.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.ItemsDao;
import com.eMart.persistence.entity.Items;
import com.eMart.persistence.model.FileInfoModel;
import com.eMart.persistence.model.ItemModel;


@Service("ItemsService")
@Transactional
public class ItemsService extends BaseService{

	@Autowired
	private ItemsDao itemsDao;	
	
	@Autowired
	private RestTemplate restTemplate;
	
	String fileInfoUrlGetby = "http://fileinfo-service/pic/getby/";
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return itemsDao;
	}
	
	public List<ItemModel> getModel() {
		
		List<ItemModel> itemModels = new ArrayList<>();
		List<Object> itemObjects= itemsDao.findAll();
		
		for(Object itemObject:itemObjects) {
			ItemModel itemModel = new ItemModel();
			Items item = (Items)itemObject;
			String picId = String.valueOf(item.getFileinfoid());
			
			itemModel.setId(item.getId());
			itemModel.setCategoryid(item.getCategoryid());
			itemModel.setSubcategoryid(item.getSubcategoryid());
			itemModel.setPrice(item.getPrice());
			itemModel.setItemname(item.getItemname());
			itemModel.setDescription(item.getDescription());
			itemModel.setStocknumber(item.getStocknumber());
			itemModel.setRemarks(item.getRemarks());
			System.out.println(itemModel.getId());
			if(item.getFileinfoid()!=0) {
				ResponseEntity<FileInfoModel> fileInfoResponseEntity=restTemplate.getForEntity(fileInfoUrlGetby+picId, FileInfoModel.class);
				String fileName = fileInfoResponseEntity.getBody().getFilename();
				itemModel.setFilename(fileName);
			}

			
			itemModels.add(itemModel);
		} 
		
		return itemModels;
		
	}
	
	public ItemModel getModelBy(long id) {
		
		Object itemObject= itemsDao.findBy(id);
		Items item = (Items)itemObject;
		ItemModel itemModel = new ItemModel();
		String picId = String.valueOf(item.getFileinfoid());
		
		itemModel.setId(item.getId());
		itemModel.setCategoryid(item.getCategoryid());
		itemModel.setSubcategoryid(item.getSubcategoryid());
		itemModel.setPrice(item.getPrice());
		itemModel.setItemname(item.getItemname());
		itemModel.setDescription(item.getDescription());
		itemModel.setStocknumber(item.getStocknumber());
		itemModel.setRemarks(item.getRemarks());
		
		if(item.getFileinfoid()!=0) {
			ResponseEntity<FileInfoModel> fileInfoResponseEntity=restTemplate.getForEntity(fileInfoUrlGetby+picId, FileInfoModel.class);
			String fileName = fileInfoResponseEntity.getBody().getFilename();
			itemModel.setFilename(fileName);
		}
		
		return itemModel;
		
	}
	

}
