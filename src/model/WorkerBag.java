package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkerBag {
	
	private Worker[] a;
	private int nElems;

	public WorkerBag(int maxSize) {
		a = new Worker[maxSize];
		nElems = 0;
	}

	public void add(Worker c) {
		a[nElems++] = c;
	}

	public void saveWorker() {
		try {
			FileOutputStream fout = new FileOutputStream("Data/Worker.txt", true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Data/Worker.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		a = (Worker[]) ois.readObject();
		ois.close();

	}

	public Worker findByFirstName(String name) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (a[i].getFirstName().equals(name)) {
				break;
			}
		}

		if (i == nElems) {
			return null;
		} else {
			return a[i];
		}
	}

	public void showBag() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}


}
