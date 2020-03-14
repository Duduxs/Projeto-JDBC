package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = new DaoFactory().createSellerDao();

//		System.out.println("\n=== TEST 1: seller findById! ===\n");
//		Seller seller = sellerDao.findById(2);
//		System.out.println(seller);
//
		System.out.println("\n=== TEST 2: seller findByDepartment! ===\n");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);

//		for (Seller x : sellerList) {
//			System.out.println(x);
//		}
//
//		System.out.println("\n=== TEST 3: seller findAll! ===\n");
//		 sellerList = sellerDao.findAll();
//
//		for (Seller x : sellerList) {
//			System.out.println(x);
//		}
//		
//		System.out.println("\n=== TEST 4: seller insert! ===\n");
//		Seller newSeller = new Seller(null,"Edward Joselph","Edward@hotmail.com",new Date(04/11/2000), 3500.00,department);
//		 sellerDao.insert(newSeller);
//		 
		System.out.println("\n=== TEST 5: seller update! ===\n");
		Seller newSeller = sellerDao.findById(12);
		newSeller.setEmail("testando@gmail.com");
		sellerDao.update(newSeller);
			 
//			System.out.println("\n=== TEST 6: seller delet! ===\n");
//			sellerDao.deleteById(18);

	}
}
