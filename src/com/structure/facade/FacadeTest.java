package com.structure.facade;

/**
 * 外观模式 是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，
 * 而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口
 * 
 * @author andy
 *
 */
public class FacadeTest {
	 public static void main(String[] args) {  
		 System.out.println("用户启动电脑");
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
		System.out.println(" CPU 启动了");
	}

	public void shutdown() {
		System.out.println("cpu 关闭");
	}
}

class Memory {
	public void start() {
		System.out.println("内存启动");

	}

	public void shutdown() {
		System.out.println("内存关闭");

	}
}

class Disk {
	public void start() {
		System.out.println("硬盘启动");
	}

	public void shutdown() {
		System.out.println("硬盘关闭");
	}
}
