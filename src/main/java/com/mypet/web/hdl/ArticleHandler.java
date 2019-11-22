package com.mypet.web.hdl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mypet.web.brd.Articles;

@Repository
public interface ArticleHandler {
	@Insert("INSERT INTO ARTICLES (IMAGE,UID,COMMENTS,MSG,RATING,CATEGORY,HASHTAG,CONTENT)values(" + 
			"#{image}, #{uid},#{comments},#{msg},#{rating},#{category},#{hashtag},#{content})")
	public void insertArticle(Articles param);
}
