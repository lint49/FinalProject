package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TicketBag {
	private Ticket[] a;
	private int nElems;

	public TicketBag(int maxSize) {
		a = new Ticket[maxSize];
		nElems = 0;
	}

	public void add(Ticket c) {
		a[nElems++] = c;
	}

	public void importData(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while (in.hasNextLine()) {
			String[] q = in.nextLine().split(" ");

			Ticket c = new Ticket(q[0], q[1], Double.parseDouble(q[2]));
			add(c);

		}
	}

	public void saveTicket() {
		try {
			FileOutputStream fout = new FileOutputStream("Data/Ticket.txt", true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Data/Ticket.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		a = (Ticket[]) ois.readObject();
		ois.close();

	}

	public Ticket findByName(String name) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (a[i].getName().equals(name)) {
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
