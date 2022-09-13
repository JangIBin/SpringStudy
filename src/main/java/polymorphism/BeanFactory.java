package polymorphism;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("SamsungTV")) {
			return new SamsungTV();
		} else if(beanName.equals("LgTV")) {
			return new LgTV();
		}
		
		return null;
	}
	
	

}
