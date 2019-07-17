package cn.sky.testcxf.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sky.testcxf.bean.User;

@Repository
public class UserDb {
	
	private Map<Integer,User> users = new HashMap<>();
	
	{
		for(int i=1;i<5;i++) {
			User user = new User();
			user.setId(i);
			user.setName("sky"+i);
			users.put(i, user);
		}
	}
	
	public User getUserById(int id) {
		return users.get(id);
	}
	
	public List<User> getUserList(){
		Collection<User> values = users.values();
		List<User> list = new ArrayList<>(values);
		return list;
	}
}
