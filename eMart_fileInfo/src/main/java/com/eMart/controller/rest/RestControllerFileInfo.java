package com.eMart.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eMart.persistence.service.BaseService;
import com.eMart.persistence.service.FileInfoService;

@RestController
@RequestMapping("/pic")
public class RestControllerFileInfo {
	
	@Autowired FileInfoService fileInfoService;
	
	private BaseService getService() {
		return fileInfoService;
	}
	
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam(value = "file") List<MultipartFile> files, HttpServletRequest request) {
		return fileInfoService.upload(files, request);
	}
	@RequestMapping(value = "/getby/{id}", method = RequestMethod.GET)
	public Object getby(@PathVariable long id) {
		return getService().findBy(id);
	}
}
