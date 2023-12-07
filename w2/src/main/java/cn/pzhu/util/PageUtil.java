package cn.pzhu.util;

import java.util.ArrayList;
import java.util.List;

import cn.pzhu.pojo.FileMsg;

public class PageUtil {
	public static List<FileMsg> splitList(List<FileMsg> list, int page,int num){
		if(list==null || list.size()==0) {
			return null;
		}
		if(page<1) {
			page =1;
		}
		int pages = (int)Math.ceil(list.size()*1.0/num);
		//int pages = (list.size()-1)/num;
		if(page > pages) {
			page = pages;
		}
		if(num <1) {
			num = 10;
		}
		if(num > 50) {
			num = 50;
		}
		List<FileMsg> newlist = new ArrayList<FileMsg>();
		for (int i = (page-1)*num; i < page*num && i < list.size(); i++) {
			newlist.add(list.get(i));
		}
		return newlist;
	}

}
