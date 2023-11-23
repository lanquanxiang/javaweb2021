package cn.pzhu.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CommonUtils {
	 public static String encoder(String source,String charset){      
	        try {  
	            return URLEncoder.encode(source,charset);  
	        } catch (UnsupportedEncodingException e) {  
	            return "";  
	        }  
	    }  
	          
	    public static String decoder(String source,String charset){      
	        try {  
	            return URLDecoder.decode(source,charset);  
	        } catch (UnsupportedEncodingException e) {  
	            return "";  
	        }  
	    }  
}
