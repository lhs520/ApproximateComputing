package com.ApproximateComputing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value="/chinese",method=RequestMethod.GET)
    public String ctest(){
    	//System.out.println("ctest 测试连接成功！");
        return "chinese/indexChinese"; 
    }
    
    @RequestMapping(value="/english",method=RequestMethod.GET)
    public String etest(){
    	//System.out.println("etest 测试连接成功！");
        return "english/indexEnglish"; 
    }

}
