package com.creation;

public class FactoryMode {
	public static void main(String[] args) {
		SendFactoryNormal factory = new SendFactoryNormal();
		Sender send = factory.produce("mail");
		send.send();
	}
}

/**
 * ��ͨ����ģʽ
 * @author andy
 *
 */
class SendFactoryNormal{
	public Sender produce(String type) {
		if("mail".equalsIgnoreCase(type)) {
			return new MailSender();
		}else if("sms".equalsIgnoreCase(type)) {
			return new SmsSender();
		}
		System.out.println("δ�ҵ����������");
		return null;
	}
}
// �������ģʽ
class SendFactoryMulty{
	public Sender produceMail(String type) {
			return new MailSender();
	}
	public Sender produceSms(String type) {
			return new SmsSender();
	}
}
// ��̬����ģʽ
class SendFactoryMultyStatic{
	public static Sender produceMail(String type) {
		return new MailSender();
}
public static Sender produceSms(String type) {
		return new SmsSender();
}
}