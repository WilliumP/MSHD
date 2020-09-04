package com.miaosha.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class DataSourceCode {
	
	private static final Map<String, String> myMap1;  
    static  
    {  
        myMap1 = new HashMap<String, String>();  
        myMap1.put("101", "公网");  
        myMap1.put("102", "北斗短报文");  
        myMap1.put("103", "卫星通讯");  
        myMap1.put("104", "卫星定位");  
        myMap1.put("105", "专用救灾（例如车载通信）");  
        myMap1.put("106", "其他");
        
        myMap1.put("201", "互联网");  
        myMap1.put("202", "通信网");  
        myMap1.put("203", "电网");  
        myMap1.put("204", "其他");  
        
        myMap1.put("301", "微博");  
        myMap1.put("302", "博客");  
        myMap1.put("303", "论坛");  
        myMap1.put("304", "微信");  
        myMap1.put("305", "其他");  
        
        myMap1.put("401", "川滇");  
        myMap1.put("402", "其他");
        
        myMap1.put("501", "其他");  
        myMap1.put("502", "其他");  
        myMap1.put("503", "其他");
    }  
	private static final Map<String, String> myMap2;  
    static  
    {  
        myMap2 = new HashMap<String, String>();  
        myMap2.put("公网","101");  
        myMap2.put("北斗短报文","102");  
        myMap2.put("卫星通讯","103");  
        myMap2.put("卫星定位","104");  
        myMap2.put("专用救灾（例如车载通信）","105");  
        myMap2.put("其他","106");
        
        myMap2.put("互联网","201");  
        myMap2.put("通信网","202");  
        myMap2.put("电网","203");  
        myMap2.put("其他","204");  
        
        myMap2.put("微博","301");  
        myMap2.put("博客","302");  
        myMap2.put("论坛","303");  
        myMap2.put("微信","304");  
        myMap2.put("其他","305");  
        
        myMap2.put("川滇","401");  
        myMap2.put("其他","402");
        
        myMap2.put("其他","501");  
        myMap2.put("其他","502");  
        myMap2.put("其他","503");
    }  
	
	public static String SourceCodetoString(String code) {
        return  myMap1.get(code);
    }
	public static String SourceStringtoCode(String str) {
        return  myMap2.get(str);
    }
}
