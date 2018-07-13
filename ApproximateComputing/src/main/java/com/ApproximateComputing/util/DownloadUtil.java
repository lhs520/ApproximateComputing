package com.ApproximateComputing.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.ContextLoader;

public class DownloadUtil {
	//以附件形式下载excel文件，这个方法暂时不用
	public static ResponseEntity<byte[]> downloadExcel(String fileName)throws Exception{
		String filePath= ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/webapp/excel/");
		System.out.println("excel保存路径："+filePath);
		File file=new File(filePath +File.separator+ fileName);
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		//解决中文乱码
		String downloadFileName=new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		//文件名设置UTF-8编码，并以附件形式下载
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//以PDF文件格式下载
		headers.setContentType((MediaType.parseMediaType("application/msexcel")));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
}
