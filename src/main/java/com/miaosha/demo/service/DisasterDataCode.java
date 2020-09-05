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
	private static HashMap<String,String> mapInfo2 = new HashMap<>();
    static  
    { 
    	initMap();
    }
	public static HashMap<String,String[]>  initMap(){
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
	            	  mapInfo2.put(split[5]+" ",split[0]+"0000000000");
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+"00000000")) {
	            	  mapInfo.put(split[0]+split[1]+"00000000",Arrays.copyOfRange(split, 5,7));
	            	  mapInfo2.put(split[5]+" "+split[6]+" ",split[0]+split[1]+"00000000");
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+"000000")) {
	            	  //System.out.println(split[0]+split[1]+split[2]+"000000");
	            	  mapInfo.put(split[0]+split[1]+split[2]+"000000",Arrays.copyOfRange(split, 5,8));
	            	  mapInfo2.put(split[5]+" "+split[6]+" "+split[7]+" ",split[0]+split[1]+split[2]+"000000");
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+split[3]+"000")) {
	            	 // System.out.println(split[0]+split[1]+split[2]+split[3]+"000");
	            	  mapInfo.put(split[0]+split[1]+split[2]+split[3]+"000",Arrays.copyOfRange(split, 5,9));
	            	  mapInfo2.put(split[5]+" "+split[6]+" "+split[7]+" "+split[8]+" ",split[0]+split[1]+split[2]+split[3]+"000");
	              }
	              if(!mapInfo.containsKey(split[0]+split[1]+split[2]+split[3]+split[4])) {
	            	  //System.out.println(split[0]+split[1]+split[2]+split[3]+split[4]);
	            	  mapInfo.put(split[0]+split[1]+split[2]+split[3]+split[4],Arrays.copyOfRange(split, 5,10));
	            	  mapInfo2.put(split[5]+" "+split[6]+" "+split[7]+" "+split[8]+" "+split[9]+" ",split[0]+split[1]+split[2]+split[3]+split[4]);
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
	public static  String locationDatatoCode(String loca) {
		
        return  mapInfo2.get(loca);
    }

	
	
}
