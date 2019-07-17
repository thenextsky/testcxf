package cn.sky.testcxf.serviceout.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sky.testcxf.bean.User;
import cn.sky.testcxf.dao.UserDb;
import cn.sky.testcxf.serviceout.UserService;

//targetNamespace:业务类所在路径
//endpointInterface:接口类所在路径
@WebService(
		serviceName="UserService1",
		targetNamespace="http://bean.testcxf.sky.cn",//与接口中的命名空间一致
		endpointInterface="cn.sky.testcxf.serviceout.UserService"//接口地址
		)
@Component("userService111")
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl111初始化");
	}

	@Autowired
	private UserDb userDb;
	
	@Override
	public User getUserById(int id) {
		return userDb.getUserById(id);
	}

	@Override
	public List<User> getUserList() {
		return userDb.getUserList();
	}

}
