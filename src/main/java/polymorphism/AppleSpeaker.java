package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker ��ü ����");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("AppleSpeaker --- �Ҹ� Up");
	}

	@Override
	public void volumnDown() {
		System.out.println("AppleSpeaker --- �Ҹ� Down");
	}

}
