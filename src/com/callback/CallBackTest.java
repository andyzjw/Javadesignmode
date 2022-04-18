package com.callback;

public class CallBackTest {
	public static void main(String[] args) {
		MainBusiness main = new MainBusiness();
		main.execute(new CallBackServiceImpl());
		main.execute(new CallBackService() {
			@Override
			public void callback() {
				System.out.println("������ �����ڿ��ǻص���");
			}
		});
		
		main.execute(()->{
			System.out.println("so dare you");
		});
		
	}
}

class MainBusiness{
	private CallBackService call;
	
	public <k> void execute(CallBackService call) {
		this.call = call;
		System.out.println("ҵ������");
		callback();
	}
	
	public void callback() {
		this.call.callback();
	}
	
	
}


interface CallBackService{
	void callback();
}

class CallBackServiceImpl implements CallBackService{

	@Override
	public void callback() {
		System.out.println("�ص�����������");
	}
	
}