package com.ApproximateComputing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ApproximateComputing.po.Applicant;
import com.ApproximateComputing.service.ApplicantService;
import com.ApproximateComputing.util.ExportExcelUtil;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {
	@Autowired
	private ApplicantService applicantService;
	
	@RequestMapping(value="/applicant",method=RequestMethod.POST)
	@ResponseBody
	public CommonDTO addApplicant(@RequestBody Applicant applicant){
		try {
			return applicantService.addApplicant(applicant);
//			return audioService.createMultiAudio(list);
			
		} catch (Exception e) {
			CommonDTO result=new CommonDTO(Result.FAILURE);
			return result;
		}
	}
	
	@RequestMapping(value="/excel",method=RequestMethod.GET)
	@ResponseBody
	public CommonDTO exportExcel(HttpServletRequest request,HttpServletResponse response){
		try {
			//文件后缀只能是"xls"，不能是"xlsx"，否则会报错：文件损坏或后缀不匹配
			String fileName="学生填写进度记录.xls";

			List<String>exportList=new ArrayList<>();
			exportList.add("名字");
			
			List<String>fieldNameList=new ArrayList<>();
			fieldNameList.add("name");
			
			List<Applicant>list=applicantService.getAll();
			System.out.println("记录个数："+list.size());
			
			ExportExcelUtil.exportExcel(fileName, exportList,fieldNameList, list, response);
			return new CommonDTO(Result.SUCCESS);
		} catch (Exception e) {
			return new CommonDTO(Result.FAILURE);
		}
		
	}
}
