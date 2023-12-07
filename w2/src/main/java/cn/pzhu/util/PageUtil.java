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
	
	
	public static StringBuffer createBar(List<FileMsg> list,int page,int num) {
		if(list==null || list.size()==0) {
			return null;
		}
		if(page<1) {
			page =1;
		}
		int pages = (int)Math.ceil(list.size()*1.0/num);
		if(page > pages) {
			page = pages;
		}
		if(num <1) {
			num = 10;
		}
		if(num > 50) {
			num = 50;
		}
		StringBuffer bar = new StringBuffer();
		if(page > 1) {
			bar.append("<a href='show?page="+(page-1)+"&num="+num+"'>上一页</a>");
		}
		for (int i = 1; i <= pages; i++) {
			if(page == i) {
				bar.append("["+i+"]");
			}else {
				bar.append("<a href='show?page="+i+"&num="+num+"'>"+i+"</a>");
			}
			
		}
		if(page < pages) {
			bar.append("<a href='show?page="+(page+1)+"&num="+num+"'>下一页</a>");
		}
		return bar;
	}

}
