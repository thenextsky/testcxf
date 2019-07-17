package cn.sky.testcxf.serviceout;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cn.sky.testcxf.bean.User;



@WebService(
		targetNamespace="http://bean.testcxf.sky.cn"//targetNamespace:业务类所在路径
)
public interface UserService {
	
	@WebMethod
	User getUserById(@WebParam(name="id")int id);
	
	@WebMethod
	List<User> getUserList();
}
