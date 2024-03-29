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
		serviceName="UserService2",
		targetNamespace="http://bean.testcxf.sky.cn/",//与接口中的命名空间一致
//		targetNamespace="http://serviceout.testcxf.sky.cn/",//会报错类型转换失败
		endpointInterface="cn.sky.testcxf.serviceout.UserService"//接口地址
		)
@Component("userService222")
public class UserServiceImpl2 implements UserService {

	public UserServiceImpl2() {
		System.out.println("UserServiceImpl222初始化");
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
