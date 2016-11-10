package model;

import java.io.FileNotFoundException;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		CustomerBag c = new CustomerBag(22);
		OwnerBag o = new OwnerBag(22);
		ManagerBag m = new ManagerBag(22);
		c.importData("Data/Customer.txt");
		o.importData("Data/Owner.txt");
		m.importData("Data/Manager.txt");

		
		

		

	}

}
