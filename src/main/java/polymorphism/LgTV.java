package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")

public class LgTV implements TV {
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("=====> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원 Off");
	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
	}

	@Override
	public void volumnDown() {
		speaker.volumnDown();
	}

	
}
