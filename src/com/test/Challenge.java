package com.test;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/findAnswer")
public class Challenge {

	@GET 
	@Path("/stringClean/{str}") 
	@Produces(MediaType.TEXT_PLAIN)
	public String getStringClean(@PathParam("str") String str){
		String result = "";
		
		for(int i=0; i<str.length(); i++) {
			char a = str.charAt(i);
			if(result.isEmpty()) {
				result += a;
			}else {
				char b = result.charAt(result.length()-1);
				if(a!=b) {
					result += a;
				}
			}
		}
		
		return result;
	}
	
	@GET 
	@Path("/stringClean/") 
	@Produces(MediaType.TEXT_PLAIN)
	public String getStringCleanDefault(@PathParam("str") String str){
		String result = "";
		
		return result;
	}
	
	
	@GET 
	@Path("/maxBlock/{str}") 
	@Produces(MediaType.TEXT_PLAIN)
	public int getMaxBlock(@PathParam("str") String str){
		int result = 0;
		if(str.isEmpty()) {
			return 0;
		}
		
		int count = 1;
		char a = str.charAt(0);
		for(int i=1; i<str.length(); i++) {
			char b = str.charAt(i);
			if(a==b) {
				count++;
			}else {
				if(count>result) {
					result = count;
				}
				count = 1;
			}
			a = b;
		}
		
		// eg. "null"
		if(count>result) {
			result = count;
		}
		
		return result;
	}
	
	@GET 
	@Path("/maxBlock/") 
	@Produces(MediaType.TEXT_PLAIN)
	public int getMaxBlockDefault(@PathParam("str") String str){
		int result = 0;
		
		return result;
	}
	
	
	
	
	@GET 
	@Path("/reorderBlock/{str}") 
	@Produces(MediaType.TEXT_PLAIN)
	public static String getReorderBlock(@PathParam("str") String str){
		//?? what if string is not A-Za-z ?   assume leave it there
		//
		//ascii for A --> 65 till Z --> 90
		//ascii for a --> 97 till z --> 122
		String result = "";
		String alphaUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphaLow = "abcdefghijklmnopqrstuvwxyz";
		int[] upper = new int[26];
		int[] lower = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			int value = c;
			if(value<90) {
				//uppercase
				upper[value-65]++;
			}else {
				//lowercase
				lower[value-97]++;
			}
		}
		
		for(int j=0; j<upper.length; j++) {
			for(int k=0; k<upper[j]; k++) {
				result += alphaUp.charAt(j);
			}
			for(int p=0;p<lower[j];p++) {
				result += alphaLow.charAt(j);
			}
		}
		

		return result;
	}
	
	

	@GET 
	@Path("/reorderBlock/") 
	@Produces(MediaType.TEXT_PLAIN)
	public static String getReorderBlockDefault(@PathParam("str") String str){
		String result = "";
		
		return result;
	}
	
	
}
