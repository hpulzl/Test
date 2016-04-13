package qb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapperInstance {
	private static ApplicationContext applicationContext;
	private static final String CLASS_PATH = "classpath:spring/applicationContext.xml";
	private MapperInstance(){
	}
	@SuppressWarnings("unchecked")
	public static <T> T getMappperInstance(String bean){
		applicationContext = new ClassPathXmlApplicationContext(CLASS_PATH);
		return (T) applicationContext.getBean(bean);
	}
}
