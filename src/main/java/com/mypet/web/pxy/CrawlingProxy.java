package com.mypet.web.pxy;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("crawler") @Lazy
//상속을 걸면 이름을 줘라 컴포넌트에
public class CrawlingProxy extends Proxy{
	@Autowired Trunk<String> trunk;
	@Autowired Box<HashMap<String , String>> box;
	//빈 역활 크롤링이니까 String !
	
	public ArrayList<HashMap<String , String>> engCrawling() {
		String url = "https://endic.naver.com/?sLn=kr";
//		box.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			Elements txtOrigin = rawData.select("div[class=\"txt_origin\"] a");
			Elements txtTrans = rawData.select("div[class=\"txt_trans\"]");
			//txt_trans 단어 뜻 이고 origin이 단어이기 떄문에 map으로 담아야됨
		/*	for (Element e : txtOrigin) {
				box.add(e.text() + "\n");

			}*/
			HashMap<String , String> map = null;
			//엘리먼츠는 box랑 똑같다 어레이리스트랑똑같
			for(int i=0;i<txtOrigin.size();i++) {
				map = new HashMap<>();
				//map은 json하나 !
				map.put("origin", txtOrigin.get(i).text());
				map.put("trans", txtTrans.get(i).text());
				box.add(map);
			}
			System.out.println("사이즈 :"+txtOrigin.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============= 크롤링 결과 ================");
		box.get().forEach(System.out :: println);
		//System.out :: println 객체이기 때문에 파라미터로 던질수 있다. 리스트 안쪽을 돌아다님 
		//원래는 System.out.println() 내가 i를 주어서 화면에 찍게 만들었는데 
		//이제 메서드를 참조해서 객체로 만들어 i를 주지 않아도 이 시스템아웃이 나(리스트)를 휘저으면서 값들을 찍게된다.
		return box.get();
	}
	public ArrayList<HashMap<String,String>> bugsCrawl(){
		String url = "https://music.bugs.co.kr/chart/track/realtime/total?chartdate=20191119&charthour=13";
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
		box.clear();
		try {
			Connection.Response homePage = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.userAgent(USER_AGENT)
					.execute();
			Document temp = homePage.parse();
			Elements photos = temp.select("a.thumbnail");
			Elements titles = temp.select("p.title");
			Elements artists = temp.select("p.artist");
			HashMap<String , String> map = null;
			
			for(int i=0; i<titles.size();i++) {
				map = new HashMap<>();
				map.put("bugsseq",toString(i+1));
				map.put("photo", photos.get(i).select("img").attr("src"));
				map.put("title", titles.get(i).text());
				map.put("artist", artists.get(i).text());
				box.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========벅스 크롤링한 값==============");
		box.get().forEach(System.out :: println);
		return box.get();
	}
public ArrayList<HashMap<String, String>> cgvCrawl(){
		//title,content,img
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
		String url = "http://www.cgv.co.kr/movies/";
	try{
		Connection.Response homePage = Jsoup.connect(url) 
				.method(Connection.Method.GET) 
				.userAgent(USER_AGENT) 
				.execute();
		Document temp = homePage.parse();
		Elements element = temp.select("div.sect-movie-chart");    
		Elements tempTitle = element.select("strong.title");
		Elements tempPrecent = element.select("strong.percent");
		Elements tempTextInfo= element.select("span.txt-info");
		Elements tempPhoto = element.select("span.thumb-image");
		
				
		HashMap<String, String> map = null;
		for(int i=0;i<tempTitle.size();i++) {
			map = new HashMap<>();
//			map.put("cgv",element.text());
			map.put("title", tempTitle.get(i).text());
			map.put("content", tempPrecent.get(i).text()+"\n"+tempTextInfo.get(i).text());
			map.put("photo", tempPhoto.get(i).select("img").attr("src"));
			box.add(map);
			
		}
//		for (Element tempTitle : tempforTitle) {
/*			tempCgvs.setCgvseq(String.valueOf(cgvseq+1));
			tempCgvs.setTitle(tempTitle.text());
			tempCgvs.setContent(tempforPrecent.get(cgvseq).text() + "/"+tempforTextinfo.get(cgvseq).text());
			tempCgvs.setImg(tempforphoto.get(cgvseq).select("img").attr("src"));
			tempList.add(tempCgvs);*/
//			cgvseq++;
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println("=========cgv 크롤링한 값==============");
			box.get().forEach(System.out :: println);
			return box.get();
		}
	public ArrayList<HashMap<String, String>> melonCrawling(){
		String url = "https://www.melon.com/chart/rise/index.htm?dayTime=2019111918#params%5Bidx%5D=1";
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
		try {
			Connection.Response melon = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.userAgent(USER_AGENT)
					.execute();
			Document temp = melon.parse();
			Elements element = temp.select("div[class=service_list_song type02 d_song_list]");
			Elements rankings = element.select("div[class=wrap t_center] span.rank");
			Elements photos = element.select("div.wrap a.image_typeAll");
			Elements songs = element.select("div[class=ellipsis rank01] a");
			Elements artists = element.select("div[class=ellipsis rank02] a");
			Elements allbums = element.select("div[class=ellipsis rank03] a");
			HashMap<String, String> map = null;
			System.out.println("랭킹 사이즈 :"+rankings.size());
			System.out.println("사진 사이즈 :"+photos.size());
			System.out.println("곡 사이즈 :"+songs.size());
			System.out.println("아티스트 사이즈 :"+artists.size());
			System.out.println("앨범 사이즈 : "+allbums.size());
			for(int i=0;i<songs.size();i++) {
				map = new HashMap<>();
				map.put("ranking",rankings.get(i+1).text());
				map.put("photo", photos.get(i).select("img").attr("src"));
				map.put("content", songs.get(i).text()+"\n"+artists.get(i*2).text());
				map.put("allbum", allbums.get(i).text());
				box.add(map);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*******************멜론 뮤직 크롤링한 값**************** ");
		box.get().forEach(System.out :: println);
		return box.get();
	}
}	

