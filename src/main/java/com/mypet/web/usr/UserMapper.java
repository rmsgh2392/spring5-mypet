package com.mypet.web.usr;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertUser(User param);
	public User selectUserById(User param);
	public int existId(String uid);
	public int countUsers();
	public int rowCount();
	public List<User> selectAll();
	public List<User> selectUname();
	
}
