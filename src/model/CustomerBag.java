package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerBag{
	private Customer[] a;
	private int nElems;
	
	public CustomerBag(int maxSize){
		a = new Customer[maxSize];
		nElems = 0;
	}
	
	public void add(Customer c){
		a[nElems++] = c;
	}
	
	public void importData(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while (in.hasNextLine()){
		String[] q = in.nextLine().split(" ");

		Customer c = new Customer (q[0], q[1], q[2], q[3], Integer.parseInt(q[4]));
		add(c);
	
		}
	}
	
	public Customer findByFirstName(String firstName){
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
	
	public Customer findByLastName(String LastName){
		int i = -1;
		for(i = 0; i < nElems; i++) {
			if(a[i].getLastName().equals(LastName)) {
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
