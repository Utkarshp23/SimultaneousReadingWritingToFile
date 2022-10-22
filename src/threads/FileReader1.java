package threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import resource.Postman;

public class FileReader1 implements Runnable {
	private Thread t;
	private File f;
	private Postman pR;

	public FileReader1(File f, Postman p) {
		t = new Thread(this);
		this.f = f;
		pR = p;
	}

	@Override
	public void run() {
		try {
			BufferedReader b = new BufferedReader(new FileReader(f));

			String l;
			while (pR.isFlag()) {

				while ((l = b.readLine()) != null) {
					System.out.println(l);
				}

			}
		} catch (Exception e) {

		}

	}

	public Thread getT() {
		return t;
	}

}