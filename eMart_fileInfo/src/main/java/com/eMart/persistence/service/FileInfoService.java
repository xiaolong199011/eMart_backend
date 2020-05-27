package com.eMart.persistence.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.eMart.controller.rest.Result;
import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.FileInfoDao;
import com.eMart.persistence.entity.FileInfo;
import com.eMart.persistence.model.Items;

@Service("fileInfoService")
@Transactional
public class FileInfoService extends BaseService {

	@Autowired
	private FileInfoDao fileInfoDao;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
//	@Autowired
//	private  Items items;
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return fileInfoDao;
	}
	
	FileInfo fileInfo = new FileInfo();
	
	public String upload(@RequestParam(value = "file") List<MultipartFile> files, HttpServletRequest request) {
		String itemId = request.getParameter("id");
		String itemsUrlGetby = "http://items-service/item/getby/"+itemId;
		String itemsUrlSave = "http://items-service/item/save/";

		ResponseEntity<Items> itemsEntity= restTemplate.getForEntity(itemsUrlGetby, Items.class);
		Items item = itemsEntity.getBody();
		item.setFileinfoid(Integer.valueOf(itemId));
		restTemplate.postForEntity(itemsUrlSave, item, Items.class);
		
	    String msg = "";
	    // 判断文件是否上传
	    if (!files.isEmpty()) {
	        // 设置上传文件的保存目录
	        String basePath = request.getServletContext().getRealPath("/upload/");
	        // 判断文件目录是否存在
	        File uploadFile = new File(basePath);
	        if (!uploadFile.exists()) {
	            uploadFile.mkdirs();
	        }
	        for (MultipartFile file : files) {
	            String originalFilename = file.getOriginalFilename();
	            
	            //file.getOriginalFilename().split("\\\\.")[1]
	            if (originalFilename != null && !originalFilename.equals("")) {
	                try {
	                    // 对文件名做加UUID值处理
	                    originalFilename = UUID.randomUUID() + "_" + originalFilename;
	                    file.transferTo(new File(basePath + originalFilename));
	                    
	                    fileInfo.setFilename(originalFilename);
	                    fileInfo.setFileextension(file.getOriginalFilename().split("\\.")[1]);
	                    fileInfo.setPath(basePath);
	                    fileInfo.setLastupdate(new Date());
	                    fileInfoDao.save(fileInfo);
	                    
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    msg = "文件上传失败！";
	                }
	            } else {
	                msg = "上传的文件为空！";
	            }
	        }
	        msg = "文件上传成功！";
	    } else {
	        msg = "没有文件被上传！";
	    }
	    request.setAttribute("msg", msg);
	    return "fileupload";
		
	}
	
//	@Override
//	public Result delete(Object o) {
//		FileInfo fi = (FileInfo) o;
//		if(null != fi.getPath()) {
//			File file = new File(fi.getPath());
//			if (file.exists()) {
//				file.delete();
//			}
//		}
//		try {
//			getDao().delete(o);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result("Failed",
//					"Exception happened while deleting the object.");
//		}
//		return new Result("Success", "Deleted successfully");
//	}

}
