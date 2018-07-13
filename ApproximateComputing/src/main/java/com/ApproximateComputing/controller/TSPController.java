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

import com.ApproximateComputing.po.TSP;

import com.ApproximateComputing.service.TSPService;
import com.ApproximateComputing.util.ExportExcelUtil;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Controller
@RequestMapping("/tSP")
public class TSPController {
	@Autowired
	private TSPService tSPService;
	//返回给前端 旅行商问题页面
	@RequestMapping(value="",method=RequestMethod.GET)
	public String TSP(){
		return "tSP";
	}
	@RequestMapping(value="/tSPs",method=RequestMethod.POST)
	@ResponseBody
	public CommonDTO createMultiTSP(@RequestBody List<TSP>list){
		try {
			return tSPService.createMultiTSP(list);
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
			String fileName="旅行商问题评分记录.xls";

			List<String>exportList=new ArrayList<>();
			exportList.add("质量损失程度(%)");
			exportList.add("路径长度(km)");
			exportList.add("运行时间(ms)");
			exportList.add("用户评分");
			
			List<String>fieldNameList=new ArrayList<>();
			fieldNameList.add("qualityLossRatio");
			fieldNameList.add("pathLength");
			fieldNameList.add("time");
			fieldNameList.add("grade");
			
			List<TSP>list=tSPService.getAll();
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
			return tSPService.selectAllAvg();
		} catch (Exception e) {
			return new CommonDTO(Result.FAILURE);
		}
	}
}
