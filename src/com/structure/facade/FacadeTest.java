package com.structure.facade;

/**
 * ���ģʽ ��Ϊ�˽��������֮�ҵ�������ϵ�ģ���springһ�������Խ������֮��Ĺ�ϵ���õ������ļ��У�
 * �����ģʽ���ǽ����ǵĹ�ϵ����һ��Facade���У�����������֮�����϶ȣ���ģʽ��û���漰���ӿ�
 * 
 * @author andy
 *
 */
public class FacadeTest {
	 public static void main(String[] args) {  
		 System.out.println("�û���������");
	        Computer computer = new Computer();  
	        computer.start();  
	        computer.shutdown();  
	    }  

}

 

class Computer {
	private CPU cpu;
	private Memory memory;
	private Disk disk;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}

	public void start() {
		System.out.println("start the computer!");
		this.cpu.start();
		this.memory.start();
		this.disk.start();
		System.out.println("start computer finished!");
	}

	public void shutdown() {
		System.out.println("begin to close the computer!");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer closed!");

	}
}

class CPU {
	public void start() {
		System.out.println(" CPU ������");
	}

	public void shutdown() {
		System.out.println("cpu �ر�");
	}
}

class Memory {
	public void start() {
		System.out.println("�ڴ�����");

	}

	public void shutdown() {
		System.out.println("�ڴ�ر�");

	}
}

class Disk {
	public void start() {
		System.out.println("Ӳ������");
	}

	public void shutdown() {
		System.out.println("Ӳ�̹ر�");
	}
}
