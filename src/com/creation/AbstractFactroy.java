package com.creation;
/**
 * 抽象工厂方法
 * 拓展性好，与工厂方法相比 不违反开闭原则
 * 
 * @author andy
 *
 */
public class AbstractFactroy {
	public static void main(String[] args) {
		Provider provider = new MailProvider();
		Sender sender = provider.produce();
		sender.send();

	}
}
// 接口中 默认全局静态常量  全局抽象方法
interface Provider{
	  public Sender produce();
}

class MailProvider implements Provider{
	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}
}

class SmsProvider implements Provider{
	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}
}
