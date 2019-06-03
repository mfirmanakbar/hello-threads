package com.mfirmanakbar;

// acak berdasarkan thread @@, ##, **, ##, **

class CA {

}

class MyTask2 extends CA implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("@@ Printer 2 Index @" + i);
		}
	}
}

class YourTask implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("** Printer 3 Index *" + i);
		}
	}
}

public class App2 {

	public static void main(String[] args) {

		// job 1
		System.out.println("##====Application Started====##");

		Runnable r = new MyTask2();
		Thread task = new Thread(r);
		task.start();
		
		Thread yourTask	= new Thread(new YourTask());
		yourTask.start();

		// job 2
		for (int i = 1; i <= 10; i++) {
			System.out.println("## Printer 1 Index #" + i);
		}

		// job 3
		System.out.println("##====Application Finished====##");

	}

}
