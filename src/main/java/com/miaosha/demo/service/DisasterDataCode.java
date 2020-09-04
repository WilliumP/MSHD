package com.miaosha.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DisasterDataCode {
	private static HashMap<String,String[]> mapInfo = new HashMap<>();
    static  
    { 
    	mapInfo=initMap();
    }
	public static HashMap<String,String[]>  initMap(){
    	HashMap<String,String[]> mapInfo = new HashMap<>();
    	try {
			  File file = new File((System.getProperty("user.dir")+"\\src\\main\\java\\com\\miaosha\\demo\\json\\dictionary.txt"));
             // File file = new File("/home/jar/resource/dictionary.txt");
    		  //File file = new File("F:/datasource/dictionary.txt");
			  BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			  String strLine = null;
	          
			  while(null != (strLine = bufferedReader.readLine())){

	        	  String[] split=strLine.split(" ");
	        	  //System.out.println("id:"+split[0]+"  hash:"+split[0].hashCode()+" length:"+split[0].length());
	              if(!mapInfo.containsKey(split[0]+"0000000000")) {
	            	  mapInfo.put(split[0]+"0000000000",Arrays.copyOfRange(split, 5,6));
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+"00000000")) {
	            	  mapInfo.put(split[0]+split[1]+"00000000",Arrays.copyOfRange(split, 5,7));
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+"000000")) {
	            	  //System.out.println(split[0]+split[1]+split[2]+"000000");
	            	  mapInfo.put(split[0]+split[1]+split[2]+"000000",Arrays.copyOfRange(split, 5,8));
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+split[3]+"000")) {
	            	 // System.out.println(split[0]+split[1]+split[2]+split[3]+"000");
	            	  mapInfo.put(split[0]+split[1]+split[2]+split[3]+"000",Arrays.copyOfRange(split, 5,9));
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+split[3]+split[4])) {
	            	  //System.out.println(split[0]+split[1]+split[2]+split[3]+split[4]);
	            	  mapInfo.put(split[0]+split[1]+split[2]+split[3]+split[4],Arrays.copyOfRange(split, 5,10));
	              }
	        }
		  }catch(Exception e){
	            e.printStackTrace();
	      }
    	
    	return mapInfo;
    }
	
	public static  String locationCodetoData(String code) {
		if(!mapInfo.containsKey(code))
			return null;
		 String[] locations=mapInfo.get(code);
		 String location="";
		 for(int i=0;i<locations.length;i++)
			 location+=locations[i]+" ";
        return  location;
    }

	
	
}
