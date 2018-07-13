package com.ApproximateComputing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ApproximateComputing.po.Audio;
import com.ApproximateComputing.service.AudioService;
import com.ApproximateComputing.util.DownloadUtil;
import com.ApproximateComputing.util.ExportExcelUtil;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Controller
@RequestMapping("/audio")
public class AudioController {
	@Autowired
	private AudioService audioService;
	
	//返回给前端 音频页面
	@RequestMapping(value="",method=RequestMethod.GET)
	public String Audio(){
		return "audio";
	}
	
	@RequestMapping(value="/audios",method=RequestMethod.POST)
	@ResponseBody
	public CommonDTO createMultiAudio(@RequestBody List<Audio>audios){
		try {
			return audioService.createMultiAudioByCallable(audios);
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
			String fileName="音频评分记录.xls";

			List<String>exportList=new ArrayList<>();
			exportList.add("质量损失程度(%)");
			exportList.add("运行时间(ms)");
			exportList.add("用户评分");
			
			List<String>fieldNameList=new ArrayList<>();
			fieldNameList.add("qualityLossRatio");
			fieldNameList.add("time");
			fieldNameList.add("grade");
			
			List<Audio>list=audioService.getAll();
			System.out.println("记录个数："+list.size());
			
			ExportExcelUtil.exportExcel(fileName, exportList,fieldNameList, list, response);
			return new CommonDTO(Result.SUCCESS);
		} catch (Exception e) {
			return new CommonDTO(Result.FAILURE);
		}
		
	}
	
	@RequestMapping(value="/statistic",method=RequestMethod.GET)
	@ResponseBody
	public CommonDTO selectAllAvg(){
		try {
			return audioService.selectAllAvg();
		} catch (Exception e) {
			return new CommonDTO(Result.FAILURE);
		}
	}
}
