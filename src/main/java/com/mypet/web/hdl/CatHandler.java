package com.mypet.web.hdl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mypet.web.cat.Cats;

@Repository
public interface CatHandler {
	@Insert("INSERT INTO CAT(BIRTH,SEX,NAME,HAIRLENGTH,HAIRCOLOR,SPECIES,SIZE,STYLE,ILLHISTORY)values(" + 
			"#{birth}, #{sex},#{name},#{hairlength},#{haircolor},#{species},#{size},#{style},#{illhistory})")
	public void insertCats(Cats param);
}
