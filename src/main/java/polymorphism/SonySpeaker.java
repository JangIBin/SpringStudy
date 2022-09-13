package polymorphism;

import org.springframework.stereotype.Component;

// @Component("sony")
public class SonySpeaker implements Speaker {
	
	
	public SonySpeaker() {
		System.out.println("SonySpeaker --- 按眉 积己");
	}
	

	public void volumnUp() {
		System.out.println("SonySpeaker --- 家府 匡赴促.");
	}
	
	public void volumnDown() {
		System.out.println("SonySpeaker --- 家府 郴赴促.");
	}
	
	
	
}
