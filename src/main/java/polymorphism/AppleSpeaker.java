package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 按眉 积己");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("AppleSpeaker --- 家府 Up");
	}

	@Override
	public void volumnDown() {
		System.out.println("AppleSpeaker --- 家府 Down");
	}

}
