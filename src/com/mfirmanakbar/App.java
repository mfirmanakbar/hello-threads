package com.mfirmanakbar;

// job 2 will not running after MyTask Completed
/*class MyTask {
	void executeTask() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("@@ Printer 2 Index @" + i);
		}
	}
}*/

//job 2 and MyTask will running concurrently / parallelly
class MyTask extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("@@ Printer 2 Index @" + i);
		}
	}
}

public class App {

	public static void main(String[] args) {
		
		//job 1
		System.out.println("##====Application Started====##");

		MyTask task = new MyTask();
		//task.executeTask();
		task.start();
		
		//job 2
		for (int i = 1; i <= 10; i++) {
			System.out.println("## Printer 1 Index #" + i);
		}
		
		//job 3
		System.out.println("##====Application Finished====##");
		
	}
	
}
