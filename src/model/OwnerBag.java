package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwnerBag {

	private Owner[] a;
	private int nElems;

	public OwnerBag(int maxSize) {
		a = new Owner[maxSize];
		nElems = 0;
	}

	public void add(Owner o) {
		a[nElems++] = o;
	}

	public void importData(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while (in.hasNextLine()) {
			String[] q = in.nextLine().split(" ");

			Owner o = new Owner(q[0], q[1], q[2], q[3], q[4], q[5], q[6], q[7]);
			add(o);

		}
	}

	public Owner findByFirstName(String firstName) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (a[i].getFirstName().equals(firstName)) {
				break;
			}
		}

		if (i == nElems) {
			return null;
		} else {
			return a[i];
		}
	}

	public Owner findByLastName(String LastName) {
		int i = -1;
		for (i = 0; i < nElems; i++) {
			if (a[i].getLastName().equals(LastName)) {
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
