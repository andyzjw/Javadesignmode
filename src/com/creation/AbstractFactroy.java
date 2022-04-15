package com.creation;
/**
 * ���󹤳�����
 * ��չ�Ժã��빤��������� ��Υ������ԭ��
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
// �ӿ��� Ĭ��ȫ�־�̬����  ȫ�ֳ��󷽷�
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
