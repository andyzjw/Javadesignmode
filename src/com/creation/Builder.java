package com.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * ������ģʽ
 * ������ģʽ�ṩ���Ǵ����������ģʽ����������ģʽ���ǽ����ֲ�Ʒ�����������й��������������϶���
 * ��ν���϶������ָĳ������в�ͬ�����ԣ���ʵ������ģʽ����ǰ����󹤳�ģʽ������Test��������õ���
 * 
 * ������ģʽ���ܶ๦�ܼ��ɵ�һ������������Դ�����Ƚϸ��ӵĶ�����
 * �����빤��ģʽ��������ǣ�����ģʽ��ע���Ǵ���������Ʒ����������ģʽ���ע�������϶��󣬶�����֡���ˣ���ѡ�񹤳�ģʽ���ǽ�����ģʽ����ʵ�����������
 * @author andy
 *
 */
public class Builder {
	private List<Sender> list = new ArrayList<>();
	
	public List produceMailSender(int count) {
		for(int i = 0;i<count ;i++) {
			list.add(new MailSender());
		}
		return list;
	}
    public List produceSmsSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new SmsSender());  
        }  
        return list;
    }
}

class BuilderTest{
	public static void main(String[] args) {
		Builder builder = new Builder();
		List<Sender> list = builder.produceMailSender(10);
		for(Sender o :list) {
			System.out.println(o);
			o.send();
		}
	}
}
