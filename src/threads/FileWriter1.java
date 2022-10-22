package threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

import resource.Postman;

public class FileWriter1 implements Runnable {
	private Thread t;
	private File f;
	private Postman pW;

	public FileWriter1(File f, Postman p) {
		t = new Thread(this);
		this.f = f;
		pW = p;

	}

	@Override
	public void run() {
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter w = new BufferedWriter(new FileWriter(f));

			String l;
			System.out.println("Enter 'stop' to quit:");
			while (!((l = b.readLine()).equals("stop"))) {
				w.write(l + "\n");
				w.flush();
			}

			b.close();
			w.close();
			pW.setFlag(false);
		} catch (Exception e) {

		}

	}

	public Thread getT() {
		return t;
	}

}