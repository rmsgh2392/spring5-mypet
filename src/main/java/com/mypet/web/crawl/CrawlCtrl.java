package com.mypet.web.crawl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.pxy.Box;
import com.mypet.web.pxy.CrawlingProxy;
import com.mypet.web.pxy.PageProxy;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.Trunk;

@RestController
@RequestMapping("/crawls")
public class CrawlCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired Box<Object> box;
	@Autowired PageProxy pager;
	@Autowired Trunk<Object> trunk;
	
	
	@GetMapping("/bugs/page/{page}")
	public Map<?,?> bugsCrawl(@PathVariable String page){
		box.clear();
		pager.printer("벅스 크롤링 들어옴");
		pager.printer("넘어온 페이지 번호 :"+page);
//		box<HashMap<String,String>>  = null;
		ArrayList<HashMap<String, String>> list = crawler.bugsCrawl();
		pager.setRowCount(list.size());
		pager.setPageSize(5);
		pager.setBlockSize(5);
		pager.setCurrPage(pager.parseInt(page));
		pager.printer("현재 페이지 : "+page);
		pager.paging();
		ArrayList<HashMap<String, String>> temp =new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(i >= pager.getStartRow() && i <= pager.getEndRow()){
				temp.add(list.get(i));
			}
			if(i > pager.getEndRow()) {break;}
		}
		trunk.put(Arrays.asList("pagination","list"),Arrays.asList(pager, temp));
		System.out.println("js에 보내는 값 :"+trunk.get());
		return trunk.get();
	}
	@GetMapping("/cgvs")
	public ArrayList<HashMap<String,String>> cgvsCrawl(){
		System.out.println("cgv컨트롤러 들어옴");
//		box.add(crawler.cgvCrawl());
		box.clear();
		return crawler.cgvCrawl();
	}
	@GetMapping("/naver")
	public ArrayList<HashMap<String,String>> naverCrawl(){
		System.out.println("naver 크롤링 들어옴");
		box.clear();
//		box.add(crawler.engCrawling());
//		System.out.println("크롤링 사이즈 :"+box.size());
		return crawler.engCrawling();
	}
	
/*	@GetMapping("/naver")
	public ArrayList<HashMap<String,String> naverCrawl(){
	 자바에서 컨트롤러에서 리턴타입이 리스트다 --> 자바스크립트는 $.each국룰 !!!
		return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
	}
	크롤링 프록시에서 값을 준것을 담지 않고 바로 던지려면 이렇게 한다.*/
	@GetMapping("/melon")
	public ArrayList<HashMap<String,String>> melonCrawl(){
		System.out.println("멜론 크롤링 들어옴");
		box.clear();
		return crawler.melonCrawling();
	}
}
