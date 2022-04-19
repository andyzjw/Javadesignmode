package com.creation;

public class FactoryMode {
	public static void main(String[] args) {
		SendFactoryNormal factory = new SendFactoryNormal();
		Sender send = factory.produce("mail");
		send.send();
	}
}

/**
 * 普通工厂模式
 * @author andy
 *
 */
class SendFactoryNormal{
	public Sender produce(String type) {
		if("mail".equalsIgnoreCase(type)) {
			System.out.println("i am coming");
			return new MailSender();
		}else if("sms".equalsIgnoreCase(type)) {
			int i =1;
			int i =2;
			return new SmsSender();
		}
		System.out.println("未找到输入的类型");
		return null;
	}
}
// 多个工厂模式
class SendFactoryMulty{
	public Sender produceMail(String type) {
			return new MailSender();
	}
	public Sender produceSms(String type) {
			return new SmsSender();
	}
}
// 静态工厂模式
class SendFactoryMultyStatic{
	public static Sender produceMail(String type) {
		return new MailSender();
}
public static Sender produceSms(String type) {
		return new SmsSender();
}
}
