package com.mypet.web.hdl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mypet.web.usr.User;

@Repository
public interface UserHandler {
	@Insert("INSERT INTO USER (UID,PWD,SSN,UNAME,PHONE,ADDRESS,EMAIL,PETTYPE)values(" + 
			"#{uid}, #{pwd},#{ssn},#{uname},#{phone},#{address},#{email},#{petType})")
	public void insertUser(User param);
}
