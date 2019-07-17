package testcxf;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import cn.sky.testcxf.bean.User;
import cn.sky.testcxf.serviceout.UserService;

public class MyTestCXF {
	public static void main(String[] args) {
		testcxf1();
//		testcxf2();
	}
	
	/**
	 * 代理类工厂的方式,需要拿到对方的接口
	 */
	private static void testcxf1() {
		//接口地址
		String address = "http://localhost:8080/skypoj/services/UserService_publish1?wsdl";
		//代理工厂
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		//设置代理地址
		jaxWsProxyFactoryBean.setAddress(address);
		//设置接口类型
		jaxWsProxyFactoryBean.setServiceClass(UserService.class);
		//创建一个代理接口实现
		UserService us = (UserService) jaxWsProxyFactoryBean.create();
		//数据准备
		int id = 1;
		User user = us.getUserById(id);
		System.out.println(user);
		System.out.println("=============");
		List<User> userList = us.getUserList();
		for(User u:userList) {
			System.out.println(u);
		}
	}
	
	/**
	 * 动态调用方式(推荐，否则需要客户端新建跟服务器一模一样的接口定义)
	 */
	private static void testcxf2() {
		//创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/skypoj/services/UserService_publish2?wsdl");
		Object[] os;
		try {
			os = client.invoke("getUserById", new Integer(1));
			System.out.println(os[0]);
			
			os = client.invoke("getUserList");
			Object o = os[0];
			{
				@SuppressWarnings("unchecked")
				List<User> list = (List<User>) o;
				for(User u:list) {
					System.out.println(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
