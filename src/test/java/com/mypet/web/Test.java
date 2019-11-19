/*package com.mypet.web;

import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String[] args) {
		String url = "https://www.google.com/maps/search/24%EC%8B%9C+%EB%8F%99%EB%AC%BC%EB%B3%91%EC%9B%90/@37.5487179,127.0003376,12z?hl=ko";
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
		try {
			Connection.Response melon = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.userAgent(USER_AGENT)
					.execute();
			Document temp = melon.parse();
			Elements element = temp.select("div.section-result");
			Elements hospital = element.select("h3.section-result-title");
			Elements star = element.select("span.cards-rating-score");
			Elements
			

			HashMap<String, String> map = null;
			for(int i=0;i<rankings.size();i++) {
				map = new HashMap<>();
				map.put("ranking",rankings.get(i).text());
				map.put("photo", photos.get(i).select("img").attr("src"));
				map.put("content", songs.get(i).text()+"\n"+artists.get(i).text());
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
}*/
