package com.mfirmanakbar;

class Printer {
	void printDocuments(int numOfCopies, String docName) {
		for (int i = 1; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(">> Printing " + docName + " " + i);
		}
	}
}

class MyThread extends Thread {
	
	Printer pRef;
	
	MyThread(Printer p) {
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printDocuments(10, "akbar.pdf");
	}
}

class YourThread extends Thread {
	
	Printer pRef;
	
	YourThread(Printer p) {
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printDocuments(10, "firman.pdf");
	}
}

public class SyncApp {
	public static void main(String[] args) {
		System.out.println("#==App Started==#");

		// only 1 single object of printer
		Printer printer = new Printer();
		//printer.printDocuments(10, "firman.pdf");
		
		MyThread mRef = new MyThread(printer);
		YourThread yRef = new YourThread(printer);
		
		// yRef & mRef will running concurrently
		//mRef.start();
		//yRef.start();
		
		
		// yRef will not running until mRef finished
		mRef.start();
		try {
			mRef.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		yRef.start();
		

		System.out.println("#==App finished==#");
	}
}
