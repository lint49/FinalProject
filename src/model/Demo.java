package model;

import java.io.FileNotFoundException;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		OwnerBag o = new OwnerBag(22);
		o.importData("owner.txt");
		
		Owner a = o.findByLastName("Smith");
		System.out.println(a.getPassword());
		

	}

}
