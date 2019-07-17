package cn.sky.testcxf.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {
	
	/**
	 * 把xml文本转换为对象
	 * @param xml
	 * @param beanClass
	 * @return
	 */
	public static <T> T xmlToBean(String xml, Class<T> beanClass) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			@SuppressWarnings("unchecked")
			T t = (T) unmarshaller.unmarshal(new StringReader(xml));
			return t;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
