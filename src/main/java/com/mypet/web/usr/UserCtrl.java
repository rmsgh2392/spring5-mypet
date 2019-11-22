package com.mypet.web.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.Trunk;

@RestController
@RequestMapping("/users")
public class UserCtrl {
	
	@Autowired UserMapper userMapper;
	@Autowired Trunk<Integer> trunk;
	@Autowired Proxy pxy;
	
	public int rowCount(){
		int rowCount =  userMapper.rowCount();
		trunk.put("rowCount",rowCount);
		pxy.printer("회원 수 :"+rowCount);
		return trunk.get("rowCount");
	}
}
