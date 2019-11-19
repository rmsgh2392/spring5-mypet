package com.mypet.web.crawl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.pxy.Box;
import com.mypet.web.pxy.CrawlingProxy;

@RestController
@RequestMapping("/crawls")
public class CrawlCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired Box<Object> box;
	
	@GetMapping("/bugs")
	public ArrayList<Object> bugsCrawl(){
		System.out.println("벅스 크롤링 들어옴");
		box.clear();
		box.add(crawler.bugsCrawl());
		return box.get();
	}
	@GetMapping("/cgvs")
	public ArrayList<HashMap<String,String>> cgvsCrawl(){
		System.out.println("cgv컨트롤러 들어옴");
		box.clear();
//		box.add(crawler.cgvCrawl());
		return crawler.cgvCrawl();
	}
	@GetMapping("/naver")
	public ArrayList<HashMap<String,String>> naverCrawl(){
		System.out.println("naver 크롤링 들어옴");
//		box.clear();
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
	
}
