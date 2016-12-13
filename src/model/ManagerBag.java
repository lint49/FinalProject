package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ManagerBag{
	
	private Manager[] a;
	private int nElems;
	
	public ManagerBag(int maxSize){
		a = new Manager[maxSize];
		nElems = 0;
	}
	
	public void add(Manager m){
		a[nElems++] = m;
	}
	
	public void importData(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while (in.hasNextLine()){
		String[] q = in.nextLine().split(" ");

		Manager m = new Manager (q[0], q[1], q[2], q[3], q[4], q[5], q[6], q[7], 
								 q[8], q[9]);
		add(m);
	
		}
	}
	
	public void saveManager() {
		try {
			FileOutputStream fout = new FileOutputStream("Data/Manager1.txt", true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Data/Manager1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		a = (Manager[]) ois.readObject();
		ois.close();

	}
	
	public Manager findByFirstName(String firstName){
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(a[i].getFirstName().equals(firstName)) {
				break;
			}
		}

		if(i == nElems) {
			return null;
		} else {
			return a[i];
		}
	}
	
	public void showBag() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
}
