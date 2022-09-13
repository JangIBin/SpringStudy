package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/* GenericXmlAplicationContext
	- ���� �ý����̳� Ŭ������ ��ο� �ִ� xml ���������� �ε��Ͽ� �����ϴ� ������ �����̳�
	
	XmlWebApplicationContext
	- �� ����� ������ ���ø����̼��� �����Ҷ�
*/

public class TVUser {

	public static void main(String[] args) {
		
		// 1. spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		// 2. Spring �����̳ʷ� ���� �ʿ��� ��ü�� ��û�Ѵ�.
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
		
		
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
		
		
	}

}
