package com.goodmanm.common;

import java.util.UUID;

/*
 * 工具类
 * */

public class ThisSystemUtil {
		
	public static int parseInt(String target, int defaultValue){
		try{
			return Integer.parseInt(target.trim());
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	public static String uuid(){
		String uuid = UUID.randomUUID().toString();
		char[] cs = new char[32];
		char c = 0;
		for(int i = uuid.length(), j = 0; i --> 0;){
			if((c = uuid.charAt(j)) != '-'){
				cs[j++] = c;
			}
		}
		return uuid;
	}
	
}
