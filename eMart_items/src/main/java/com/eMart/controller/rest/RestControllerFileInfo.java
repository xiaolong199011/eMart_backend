package com.eMart.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")
public class RestControllerFileInfo {
	
	@RequestMapping("/fileupload")
	public String fileUpload(@RequestParam(value = "file") List<MultipartFile> files, HttpServletRequest request) {
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
	            if (originalFilename != null && !originalFilename.equals("")) {
	                try {
	                    // 对文件名做加UUID值处理
	                    originalFilename = UUID.randomUUID() + "_" + originalFilename;
	                    file.transferTo(new File(basePath + originalFilename));
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

}
