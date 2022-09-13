package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/* GenericXmlAplicationContext
	- 파일 시스템이나 클래스의 경로에 있는 xml 설정파일을 로딩하여 구동하는 스프링 컨테이너
	
	XmlWebApplicationContext
	- 웹 기반의 스프링 어플리케이션을 개발할때
*/

public class TVUser {

	public static void main(String[] args) {
		
		// 1. spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		// 2. Spring 컨테이너로 부터 필요한 객체를 요청한다.
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		// TV tv2 = tv1;
		// TV tv3 = tv2;
		*/
		
		
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
		
		
	}

}
