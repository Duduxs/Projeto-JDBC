package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		

		
		Department d = new Department(1,"Books");
		Seller s = new Seller(1,"Eduardo","duduxss3@gmail.com",new Date(),3700.00,d);
		
		System.out.println(s);
		
	}
}
