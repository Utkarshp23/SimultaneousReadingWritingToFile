package app;

import java.io.File;

import threads.FileReader1;
import threads.FileWriter1;
import resource.Postman;

public class App {

	public static void main(String[] args) throws InterruptedException {
		File f1 = new File("/home/utkarsh/eclipse-workspace/RawData/demo1.txt");
		Postman p = new Postman();

		FileWriter1 w = new FileWriter1(f1, p);
		FileReader1 r = new FileReader1(f1, p);
		System.out.println("File Copying Started......");
		w.getT().start();

		r.getT().start();

		r.getT().join();
		w.getT().join();
		System.out.println("File Copying Ended......");
	}

}
