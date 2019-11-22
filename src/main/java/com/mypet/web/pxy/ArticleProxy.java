package com.mypet.web.pxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.brd.Articles;
import com.mypet.web.hdl.ArticleHandler;

@Component("/comm")
public class ArticleProxy {
	@Autowired Trunk<String> trunk;
	@Autowired CrawlingProxy crawler;
	@Autowired ArticleHandler articleHandler;
	
	public String setImage() {
		return null;
	}
	public String setComments() {
		 List<String> fcomments = Arrays.asList("첫 방문인데", "세번째 방문인데", "여러번 방문인데", "다시 오고싶은", "훌륭한", "다시한번 오고싶은", "두번째 방문인데", "자주왔지만 다음엔");
	     List<String> comment = Arrays.asList("너무좋아요", "또오고 싶어요", "여기 살고 싶어요", "주변에 알리고 싶어요", "주변에 소개하고 싶어요", "다음에 다시 올게요!", "다음엔 또치도 데리고 올게요","다음엔 둘리도 데리고 올게요"
	            , "다음엔 꽁이도 데리고 올게요", "다음엔 콩이도 데리고 올게요", "다음엔 나래도 데리고 올게요", "다음엔 방울이도 데리고 올게요", "다음엔 고양이도 데리고 올게요", "다음엔 강아지도 데리고 올게요", "다음엔 구찌도 데리고 올게요");
	      Collections.shuffle(fcomments);
	      Collections.shuffle(comment);
	      String fullComment = fcomments.get(0)+comment.get(0);
	      return fullComment;
		
	}
	public String setMsg() {
		 List<String> msgs = Arrays.asList("좋아요","싫어요!","대단하시네여","분발하셔야겠어요",
				 "혹시 시간괜찮으신가요?","안녕하세요","안녕히가세여","반갑습니다","처음 뵙겠습니다");
	     Collections.shuffle(msgs);
	     String msg = msgs.get(0);
	     return msg;
		
	}
	public String setRating() {
		List<String> ratings = Arrays.asList("1점","2점","3점","4점","5점","6점","7점","8점","9점","10점");
	    Collections.shuffle(ratings);
	    String rating = ratings.get(0);
	    return rating;
	
	}
	public String setCategory() {
		List<String> categorys = Arrays.asList("강아지","고양이","산책","동반 음식점","공기좋은 공원","깨끗한 공원","예방주사","백신","동물병원","24시");
	    Collections.shuffle(categorys);
	    String category = categorys.get(0);
		return category;
	}
	public String setHashtag() {
		return null;
	}
	public ArrayList<String> setContent() {
		 trunk.put(Arrays.asList("site","srch"),Arrays.asList("기타","스톤애견풀빌라"));
//		 ArrayList<String> t = crawler.choose(trunk.get()).getList();
	
//		 box = crawler.choose(trunk.get());
//		 Collections.shuffle(t);
		  
	     return null;
		
	}
	public String setUid() {
		 List<String> uids = 
		Arrays.asList("0HTxe","0HU5f","0JCc2","0oRiP","14v6p","0w6l5","1fmb9","1J65C","1k3BU","1scq6");
	    Collections.shuffle(uids);
	    String uid = uids.get(0);
	       return uid;
		
	}
	public String articleseq() {
		return null;
	}
//	image , uid, comments, msg, rating, category, hashtag, content
	@Transactional
	public void insertArticles() {
		ArrayList<String> t = setContent();
		
		for(int i=0;i<100; i++) {
			Collections.shuffle(t);
			articleHandler.insertArticle(new Articles(articleseq(),
		   			   setImage(),
		   			   setUid(),
					   setComments(),
					   setMsg(),
					   setRating(),
					   setCategory(),
					   setHashtag(),
					   t.get(0)));
		}
	}
}
