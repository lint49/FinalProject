package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WineBag {
	private Wine[] a;
	private int nElems;

	public WineBag(int maxSize) {
		a = new Wine[maxSize];
		nElems = 0;
	}

	public void add(Wine c) {
		a[nElems++] = c;
	}

	public void importData(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while (in.hasNextLine()) {
			String[] q = in.nextLine().split(" ");

			Wine c = new Wine(q[0], q[1], q[2], Integer.parseInt(q[3]), Double.parseDouble(q[4]));
			add(c);

		}
	}

	public void saveWine() {
		try {
			FileOutputStream fout = new FileOutputStream("Data/Wine.txt", true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Data/Wine.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		a = (Wine[]) ois.readObject();
		ois.close();

	}

	public Wine findByName(String name) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (a[i].getWineName().equals(name)) {
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
