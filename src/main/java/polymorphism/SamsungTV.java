package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��...");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setSpeaker() ȣ��...");
		this.price = price;
	}	
	
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾��� ó����....");
	}
	
	public void destroyMethod() {
		System.out.println("��ü ���� ���� ó���� ������ ó����....");
	}
	
	public SamsungTV() {
		System.out.println("====> SamsungTV(1) ��ü ����");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("====> SamsungTV(2) ��ü ����");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("====> SamsungTV(3) ��ü ����");
		this.speaker = speaker;
		this.price = price;
	}


	@Override
	public void powerOn() {
		System.out.println("SamsungTV ------ ���� �Ҵ�.(���� : "+price+")");
		// System.out.println("SamsungTV -- ���� On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ���� Off");
	}

	@Override
	public void volumnUp() {
		// speaker = new SonySpeaker();
		speaker.volumnUp();
		// System.out.println("SamsungTV -- ���� Up");
	}

	@Override
	public void volumnDown() {
		// speaker = new SonySpeaker();
		speaker.volumnDown();
		// System.out.println("SamsungTV -- ���� Down");
	}

	
}
