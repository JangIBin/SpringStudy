package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출...");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setSpeaker() 호출...");
		this.price = price;
	}	
	
	public void initMethod() {
		System.out.println("객체 초기화 작업을 처리함....");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직을 처리함....");
	}
	
	public SamsungTV() {
		System.out.println("====> SamsungTV(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("====> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("====> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}


	@Override
	public void powerOn() {
		System.out.println("SamsungTV ------ 전원 켠다.(가격 : "+price+")");
		// System.out.println("SamsungTV -- 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 Off");
	}

	@Override
	public void volumnUp() {
		// speaker = new SonySpeaker();
		speaker.volumnUp();
		// System.out.println("SamsungTV -- 볼륨 Up");
	}

	@Override
	public void volumnDown() {
		// speaker = new SonySpeaker();
		speaker.volumnDown();
		// System.out.println("SamsungTV -- 볼륨 Down");
	}

	
}
