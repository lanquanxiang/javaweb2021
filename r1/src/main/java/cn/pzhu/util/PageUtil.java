package cn.pzhu.util;

import java.util.ArrayList;
import java.util.List;

import cn.pzhu.pojo.FileMsg;

public class PageUtil {
	public static List<FileMsg> getPageData(List<FileMsg> list, int page,int num){
		List<FileMsg> newlist = null;
		
		if(list==null || list.size()==0) {
			return null;
		}
		if(num<1) {
			num = 10;
		}
		//如果需要设置显示的条数上线，可以在这里进行控制
		
		//int pages = (list.size()%num == 0)? list.size()/num : list.size()/num+1;
		int pages = (list.size()-1)/num+1;
		if(page<1) {
			page =1;
		}
		if(page>pages) {
			page = pages;
		}
		newlist = new ArrayList<>();
		for(int i=(page-1)*num; i< page*num && i<list.size() ;i++) {
			newlist.add(list.get(i));
		}		
		return newlist;
	}
	
	public static StringBuffer createBar(List<FileMsg> list, int page,int num) {
		StringBuffer bar = null;
		if(list==null || list.size()==0) {
			return null;
		}
		if(num<1) {
			num = 10;
		}
		int pages = (list.size()-1)/num+1;
		if(page<1) {
			page =1;
		}
		if(page>pages) {
			page = pages;
		}
		bar = new StringBuffer();
		if(page>1) {
			bar.append("<a href='show?page="+(page-1)+"&num="+num+"'>上一页</a>  ");
		}
		
		for(int i=1;i<=pages;i++) {
			if(page==i) {
				bar.append("["+i+"]");
			}else {
				bar.append("<a href='show?page="+i+"&num="+num+"'>"+i+"</a>  ");
			}
		}
		
		if(page<pages) {
			bar.append("<a href='show?page="+(page+1)+"&num="+num+"'>下一页</a>  ");
		}
		
		
		return bar;
		
	}
	
}
