package polymorphism;

import org.springframework.stereotype.Component;

// @Component("sony")
public class SonySpeaker implements Speaker {
	
	
	public SonySpeaker() {
		System.out.println("SonySpeaker --- ��ü ����");
	}
	

	public void volumnUp() {
		System.out.println("SonySpeaker --- �Ҹ� �︰��.");
	}
	
	public void volumnDown() {
		System.out.println("SonySpeaker --- �Ҹ� ������.");
	}
	
	
	
}
